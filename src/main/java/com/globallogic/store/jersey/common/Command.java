package com.globallogic.store.jersey.common;

public class Command {

    public static class Request {
        public static final String GET_USERS = "http://localhost:8080/users";

        public static String GET_VALIDATE_USER_DATA(String username, String password) {
            return GET_USERS + "/" + username + "/" + password;
        }
    }
}
