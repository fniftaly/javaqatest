/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filesystem;

import java.util.ArrayList;

/**
 *
 * @author def
 */
public interface Create_dir_file {
    
    public boolean createdir(String dirurl);
    
    public void createfile(String dirurl);
    
    public void addtofile(ArrayList<User> user, String fileurl);
    
    public void display(String fileurl);
    
    public void copyfile(String sourceurl, String desturl);
    
    public String[] searchfile(String dirurl, String fileurl);
    
}
