package com.james;

/**
 * Created by jamesyburr on 6/15/16.
 */
public class User {
    Integer userId;
    String username;
    String address;
    String email;

    public User() {
    }

    public User(Integer userId, String username, String address, String email) {
        this.userId = userId;
        this.username = username;
        this.address = address;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
