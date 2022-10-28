package org.example.service.uritemplate;

public class PetStoreUserUri {
    public static String userName = "test_name_3";
    public static final UriTemplate CREATE_USER = new UriTemplate("user/createWithArray");
    public static final UriTemplate USER_BY_USERNAME = new UriTemplate("user/" + userName);
    public static final UriTemplate USER_BY = new UriTemplate("user");
    public static final UriTemplate USER_LOGIN = new UriTemplate("user/login?username=" + userName + "&password=****");
    public static final UriTemplate USER_LOGOUT = new UriTemplate("user/logout");
}
