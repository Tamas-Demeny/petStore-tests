package org.example;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.entities.User;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PetStoreTests {
    @Test
    public void getUser1User() {
        LinkedHashMap<String, String> users = UserServiceSteps.getUser();
        Assert.assertEquals(users.get("username"), "user1",
                "user1 was not found..");
    }

    @Test
    public void createUserArrayTest() {
        ArrayList<User> expectedUser = createUser();
//        List<User> listOfNewUsers = new LinkedList<>();
//        listOfNewUsers.add((User) expectedUser.get(0));
        Response actualUser = UserServiceSteps.createUser(expectedUser);
        Assert.assertEquals(actualUser.getStatusCode(), 200,
                "The expected user name doesn't match the actual user name");
    }

//    @Test
//    public void createUserTest() {
//        ArrayList expectedUser = createUser();
//        List<User> listOfNewUsers = new LinkedList<>();
//        User actualUser = UserServiceSteps.createUser(listOfNewUsers);
//        Assert.assertEquals(actualUser.getUsername(), expectedUser.getUsername(),
//                "The expected user name doesn't match the actual user name");
//    }

    private ArrayList<User> createUser() {
        Random random = new Random();
        ArrayList<User> userInfo = new ArrayList<>(1);
        userInfo.add(new User().setId(0)
                .setUsername("test_name" )
                .setFirstName("John")
                .setLastName("Johnson")
                .setEmail("test_name" + random.nextInt() + "@gmail.com")
                .setPassword("****")
                .setPhone("0987654321")
                .setUserStatus(0));
        return userInfo;
    }
}
