package com.example.Vatsal;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class UserEntityListener {
    @PrePersist
    void prePersist(User user){
        System.out.println("Persisting user");
    }

    @PostPersist
    void postPersist(User user) throws Exception {
        if(!user.getName().equals("vatsal")){
            throw new Exception("Wrong data persisted");
        }
    }
}
