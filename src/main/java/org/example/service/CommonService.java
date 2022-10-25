package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.example.log.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CommonService {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    private final Function<String, String> prepareUri = uri -> String.format("%s%s", BASE_URL, uri);

    protected RequestSpecification requestSpecification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//        this.requestSpecification = RestAssured.given().auth().oauth2("8d3edc50fd5dbb75c78aa0e6b003827314f21f4aa8f03facd79465c96ce44c55");
        this.requestSpecification = RestAssured.given().auth().oauth2("b130970e-be37-4611-95ff-6aac2cd7aef0");
        setCommonParams();
    }

    protected void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
//        headers.put("api_key", "1");
        requestSpecification.headers(headers);
    }

    protected Response getRequest(String uri) {
        Log.info("Sending the GET request to the Uri: " + prepareUri.apply(uri));
        Response response = requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
        Log.info("Response body is " + response.asPrettyString());
        return response;
    }

    protected Response postRequest(String uri, Object body) {
        return requestSpecification.body(body).expect().log().ifError()
                .when().post(prepareUri.apply(uri));
    }

    protected void deleteRequest(String uri) {
        requestSpecification.expect().statusCode(HttpStatus.SC_NO_CONTENT).log().ifError()
                .when().delete(prepareUri.apply(uri));
    }
}
