package com.globallogic.store.jersey.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class User {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private static String format = "%5s|%15s|%15s|%15s|%15s|%15s|%15s";

    public static String header() {
        return String.format(
                format,
                "id",
                "firstname",
                "lastname",
                "username",
                "password",
                "email",
                "role");
    }

    public static String separator() {
        return "------------------------------------------------------------------------------------------------------";
    }

    @Override
    public String toString() {
        return String.format(
                format,
                id,
                firstname,
                lastname,
                username,
                password,
                email,
                role);
    }
}
