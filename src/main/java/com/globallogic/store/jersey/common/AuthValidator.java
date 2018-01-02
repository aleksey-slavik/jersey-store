package com.globallogic.store.jersey.common;

import com.globallogic.store.jersey.exception.AuthException;
import com.globallogic.store.jersey.model.User;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/**
 * User authentication.
 * Check that user have permissions.
 *
 * @author oleksii.slavik
 */
public class AuthValidator {

    /**
     * Check given username and password
     *
     * @param username given username
     * @param password given password
     * @return user data if authentication is complete successfully
     * @throws AuthException throws if authentication is failed
     */
    public User validate(String username, String password) throws AuthException {
        WebResource webResource = ClientInstance.getInstance().getClient().resource(createRequest(username, password));
        User[] response = webResource.accept(MediaType.APPLICATION_JSON).get(User[].class);

        if (response.length != 0 && response[0].getRole().equals("ADMIN")) {
            return response[0];
        } else {
            throw new AuthException();
        }
    }

    /**
     * Request to rest service with given parameters
     *
     * @param username given username
     * @param password given password
     * @return request to rest service
     */
    private String createRequest(String username, String password) {
        return "http://localhost:8080/users/" + username + "/" + password;
    }
}
