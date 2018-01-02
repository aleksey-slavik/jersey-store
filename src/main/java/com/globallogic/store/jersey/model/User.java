package com.globallogic.store.jersey.model;

/**
 * User bean
 *
 * @author oleksii.slavik
 */
public class User extends Entity {

    /**
     * First name of user
     */
    private String firstname;

    /**
     * Last name of user
     */
    private String lastname;

    /**
     * Username of user
     */
    private String username;

    /**
     * Password of user
     */
    private String password;

    /**
     * E-mail of user
     */
    private String email;

    /**
     * Role of user
     */
    private String role;

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

    /**
     * Header of table
     *
     * @return row of table
     */
    @Override
    public String header() {
        return row("Id", "Firstname", "Lastname", "Username", "Password", "Email", "Role");
    }

    /**
     * Separator between table rows
     *
     * @return string representation of separator
     */
    @Override
    public String separator() {
        return separator(7);
    }

    /**
     * Formatted representation of user bean for console output
     *
     * @return string representation of user bean
     */
    @Override
    public String toString() {
        return row(Long.toString(getId()), firstname, lastname, username, password, email, role);
    }
}
