/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filesystem;

import java.io.Serializable;

/**
 *
 * @author def
 */
public class User implements Serializable{
    
    private String firstname;
    private String lastname;
    private String title;
    private int    userid;
    
    public User(String firstname,String lastname, String title, int userid){
        
        this.firstname = firstname;
        this.lastname  = lastname;
        this.title     = title;
        this.userid    = userid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
    
}
