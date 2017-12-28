package com.globallogic.store.jersey.user;

import com.globallogic.store.jersey.User;
import com.globallogic.store.jersey.common.ClientInstance;
import com.globallogic.store.jersey.common.Command;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;


public class AuthValidator {

    public boolean validate(String username, String password) {
        WebResource webResource = ClientInstance.getInstance().getClient().resource(createRequest(username, password));
        User[] response = webResource.accept(MediaType.APPLICATION_JSON).get(User[].class);
        return response[0] != null && response[0].getRole().equals("ADMIN");
    }

    private String createRequest(String username, String password) {
        return Command.Request.GET_USERS + "/" + username + "/" + password;
    }
}
