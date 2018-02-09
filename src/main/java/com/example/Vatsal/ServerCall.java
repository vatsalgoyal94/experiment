package com.example.Vatsal;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ServerCall {
    public static void main(String args[]){
        Client htttpClient = Client.create();
        WebResource webresource = htttpClient.resource("http://localhost:8081/");
        System.out.println(webresource.path("name").get(String.class));
    }
}
