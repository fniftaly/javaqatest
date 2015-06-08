/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author farad
 */
public class User implements Serializable{
    
    private String firstname;
    private String lastname;
    private String email;
    private String date;
    private String users[];
    
    public User(String firstname, String lastname, String email, String date){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email  = email;
        this.date = date;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getUsers() {
        return users;
    }
    
    
}
