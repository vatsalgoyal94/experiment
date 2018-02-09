package com.example.Vatsal;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    @GetMapping("/getDataFromServer")
    public String getDataFromServer(){
        Client htttpClient = Client.create();
        WebResource webresource = htttpClient.resource("http://localhost:8081/");
        return webresource.path("name").get(String.class);
    }

}
