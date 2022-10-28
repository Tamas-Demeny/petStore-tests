package org.example.steps;

import io.restassured.response.Response;
import org.example.service.Services;

import static org.example.service.uritemplate.PetStoreOrderUri.*;

public class OrderServiceSteps {
    public static final Services STORE_SERVICE = Services.getInstance();

    public static Response placeOrder(Object body) {
        return STORE_SERVICE.postRequest(PLACE_ORDER, body);
    }

    public static Response getInventory() {
        return STORE_SERVICE.getRequest(STORE_INVENTORY);
    }

    public static Response getOrderById(){
        return STORE_SERVICE.getRequest(GET_ORDER_BY_ID);
    }

}
