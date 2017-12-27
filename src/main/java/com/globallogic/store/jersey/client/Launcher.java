package com.globallogic.store.jersey.client;

import com.globallogic.store.jersey.common.Command;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Launcher {
    public static void main(String[] args) {
        Client client = Client.create();
        String user = "admin";
        String password = "admin";
        WebResource webResource = client.resource(Command.Request.GET_VALIDATE_USER_DATA(user, password));
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error= response.getEntity(String.class);
            System.out.println("Error: "+error);
        } else {
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output);
        }
    }
}
