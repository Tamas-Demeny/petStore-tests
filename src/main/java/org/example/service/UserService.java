package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class UserService extends CommonService {
    private UserService() {

    }

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Response getRequest(UriTemplate uri) {
        return super.getRequest(uri.getUri());
    }

    public Response getRequest(UriTemplate uri, int id) {
        return super.getRequest(uri.getUri(id));
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public void deleteRequest(UriTemplate uri, int id) {
        super.deleteRequest(uri.getUri(id));
    }
}
