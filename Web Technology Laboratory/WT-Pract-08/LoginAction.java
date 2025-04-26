package com.example.actions;

import com.example.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private User user;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String execute() {
        // Business logic would go here
        return SUCCESS;
    }
}