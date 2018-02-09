package com.example.Vatsal;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/create")
    public User create(){
        User user = new User();
        user.setName("vatsal");
        //userRepo.save(user);
        return userRepo.save(user);
    }

    @GetMapping("/update")
    @Transactional
    public User update(){
        User user = userRepo.findOne(1L);
        user.setName("Nishant");
        return user;
    }

    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        userRepo.save(user);
    }

    @GetMapping("/add")
    public void insert(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepo.save(user);
    }

    @PostMapping("/login")
    public void login(HttpServletRequest request) throws IOException {

//        Header[] headers = request.getAllHeaders();

        String response = request.getParameter("g-recaptcha-response");
        System.out.println(response);
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://www.google.com/recaptcha/api/siteverify");
        List<BasicNameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("secret","6LfPYEUUAAAAAGDbJ_Mdp-cd7UydQU7-qQ5jv4Pz"));
        nameValuePairs.add(new BasicNameValuePair("response", response));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response1 = client.execute(post);
        String json = EntityUtils.toString(response1.getEntity());
        System.out.print(json);
//        Header[] headers = response1.getAllHeaders();
//                for(Header header:headers){
//            System.out.println("Key - "+header.getName()+" Value - "+header.getValue());
//        }

    }

}
