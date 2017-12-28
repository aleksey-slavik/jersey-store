package com.globallogic.store.jersey.user;

import com.globallogic.store.jersey.model.User;
import com.globallogic.store.jersey.common.ClientInstance;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;


public class AuthValidator {

    public boolean validate(String username, String password) {
        WebResource webResource = ClientInstance.getInstance().getClient().resource(createRequest(username, password));
        User[] response = webResource.accept(MediaType.APPLICATION_JSON).get(User[].class);
        return response.length != 0 && response[0].getRole().equals("ADMIN");
    }

    private String createRequest(String username, String password) {
        return "http://localhost:8080/users/" + username + "/" + password;
    }
}
