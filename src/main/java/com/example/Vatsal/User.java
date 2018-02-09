package com.example.Vatsal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@EntityListeners(UserEntityListener.class)
public class User {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
