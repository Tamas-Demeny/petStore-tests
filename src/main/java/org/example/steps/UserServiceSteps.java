package org.example.steps;

import io.restassured.response.Response;
import org.example.entities.User;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.example.service.uritemplate.PetStoreUri.*;

public class UserServiceSteps {
    public static final UserService USER_SERVICE = UserService.getInstance();

    public static List<User> getAllUsers() {
        return USER_SERVICE.getRequest(USER_BY).jsonPath().getList("", User.class);
    }

    public static LinkedHashMap<String, String> getUser() {
        return USER_SERVICE.getRequest(USER_BY_USERNAME).jsonPath().get();
    }

    public static Response createUser(ArrayList<User> expectedUser) {
        return USER_SERVICE.postRequest(CREATE_USER, expectedUser);
    }
}
