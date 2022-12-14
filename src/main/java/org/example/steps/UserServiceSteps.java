package org.example.steps;

import io.restassured.response.Response;
import org.example.entities.User;
import org.example.service.Services;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.example.service.uritemplate.PetStoreUserUri.*;

public class UserServiceSteps {
    public static final Services USER_SERVICE = Services.getInstance();

    public static LinkedHashMap<String, String> getUser() {
        return USER_SERVICE.getRequest(USER_BY_USERNAME).jsonPath().get();
    }

    public static Response createUser(ArrayList<User> expectedUser) {
        return USER_SERVICE.postRequest(CREATE_USER, expectedUser);
    }

    public static Response loginWithUser() {
        return USER_SERVICE.getRequest(USER_LOGIN);
    }

    public static Response logoutWithUser() {
        return USER_SERVICE.getRequest(USER_LOGOUT);
    }

    public static Response updateUser(User userUpdate) {
        return USER_SERVICE.putRequest(USER_BY_USERNAME, userUpdate);
    }

    public static Response deleteUser() {
        return USER_SERVICE.deleteRequest(USER_BY_USERNAME);
    }
}
