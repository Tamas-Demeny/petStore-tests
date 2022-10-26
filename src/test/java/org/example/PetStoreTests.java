package org.example;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.entities.User;
import org.example.service.uritemplate.PetStoreUri;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PetStoreTests {

    String userName = PetStoreUri.userName;
    @Test(dependsOnMethods = "createUserArrayTest")
    public void getUser(String expected) {
        LinkedHashMap<String, String> users = UserServiceSteps.getUser();
        Assert.assertEquals(users.get("username"), expected,
                "user1 was not found..");
    }

    @Test
    public void createUserArrayTest(ArrayList<User> expectedUser) {
//        ArrayList<User> expectedUser = createUserArray();
        Response actualUser = UserServiceSteps.createUser(expectedUser);
        Assert.assertEquals(actualUser.getStatusCode(), HttpStatus.SC_OK,
                "The expected user name doesn't match the actual user name");
    }

    @Test(dependsOnMethods = "createUserArrayTest")
    public void logInWithUserTest() {
        Response loginResponse = UserServiceSteps.loginWithUser();
        Assert.assertEquals(loginResponse.statusCode(), HttpStatus.SC_OK,
                "Oops, something went wrong!");
    }

    @Test(dependsOnMethods = "updateUserTest")
    public void logOutWithUserTest() {
        Response logoutResponse = UserServiceSteps.logoutWithUser();
        Assert.assertEquals(logoutResponse.statusCode(), HttpStatus.SC_OK,
                "Oops! Now something definitely went wrong!!");
    }

    @Test(dependsOnMethods = "logInWithUserTest")
    public void updateUserTest(User updateUser) {
//        User updateUser = createUser();
        Response updatedUser = UserServiceSteps.updateUser(updateUser);
        Assert.assertEquals(updatedUser.statusCode(), HttpStatus.SC_OK);

        LinkedHashMap<String, String> users = UserServiceSteps.getUser();
        Assert.assertEquals(users.get("email"), updateUser.getEmail());
    }

    @Test(dependsOnMethods = "logOutWithUserTest")
    public void deleteUserTest() {
        Response response = UserServiceSteps.deleteUser();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }


    private ArrayList<User> createUserArray() {
        Random random = new Random();
        ArrayList<User> userInfo = new ArrayList<>(1);
        userInfo.add(new User().setId(0)
                .setUsername(userName)
                .setFirstName("John")
                .setLastName("Johnson")
                .setEmail("test_name" + random.nextInt() + "@gmail.com")
                .setPassword("****")
                .setPhone(989876556)
                .setUserStatus(0));
        return userInfo;
    }

    private User createUser() {
        Random random = new Random();
        return new User().setId(0)
                .setUsername(userName)
                .setFirstName("John")
                .setLastName("Johnson")
                .setEmail("test_name" + random.nextInt() + "@gmail.com")
                .setPassword("****")
                .setPhone(random.nextInt(999999999))
                .setUserStatus(0);
    }

    @Test
    public void completeTest() {
        ArrayList<User> expectedUser = createUserArray();
        User updateUser = createUser();

        createUserArrayTest(expectedUser);

        getUser(userName);

        logInWithUserTest();

        logOutWithUserTest();

        updateUserTest(updateUser);

        deleteUserTest();
    }
}
