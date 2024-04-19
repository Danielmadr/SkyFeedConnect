package com.Ada.SkyFeedConnect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    private @Id @GeneratedValue Long id;
    @Column(nullable = false)
    private String userName;

    public User() {}

    public User(String name) {
        this.userName = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
