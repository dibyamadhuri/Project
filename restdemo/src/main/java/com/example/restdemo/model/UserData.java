package com.example.restdemo.model;

public class UserData {
    
    private int id;
    private String userName;
    
    public UserData() {
    }

    public UserData(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserData [id=" + id + ", userName=" + userName + "]";
    }
    
}
