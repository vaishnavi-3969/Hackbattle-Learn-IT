package com.hackbattle.learnit.model;

public class User {
    private String email;
    private String uid;

    public User(String email, String uid) {
        this.email = email;
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }
}
