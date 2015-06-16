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
public class ProcessFiles {
    
    private String filename;
    
    private String _dir = "/Users/def/dir1";
    
    private String _dirdest;
    
    private Create_dir_file _dirfile;
    
    private ArrayList<User> users;
    
    private User user;
    
    public ProcessFiles(Create_dir_file dir){
        
        users = new ArrayList();
        
        this._dirfile = dir;
        
        this.filename = "userobj.ser";
        
        this.users.add(new User("John","Doe","ceo", 1234));
        
        this._dirdest  = "/Users/def/dir2";
    }
    
    public static void main(String[] args){
        
//        ProcessFiles prf = new ProcessFiles(new CreateFileDir());
//          
//           prf.getDirfile().createdir(prf.getDir());
//           
//           prf.getDirfile().createfile(prf.getDir());
//           
//           String filedir = prf.getDir() + "/" + prf.getFilename();
//           
//           prf.getDirfile().addtofile(prf.getUsers(),filedir);
//           
//           prf.getDirfile().display(prf.getDir());
//           
//           prf.getDirfile().copyfile(filedir, prf.getDirdest());
      
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getFilename() {
        return filename;
    }

    public String getDir() {
        return _dir;
    }

    public Create_dir_file getDirfile() {
        return _dirfile;
    }

    public String getDirdest() {
        return _dirdest;
    }
    
    
}
