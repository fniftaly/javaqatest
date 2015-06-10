/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filesystem;

/**
 *
 * @author def
 */
public class ProcessFiles {
    
    private String filename;
    
    private String dir = "/Users/def/dir1";
    
    private Create_dir_file _dirfile;
    
    public ProcessFiles(Create_dir_file dir){
        this._dirfile = dir;
        this.filename = "userobj.ser";
    }
    
    public static void main(String[] args){
        
        ProcessFiles prf = new ProcessFiles(new CreateFileDir());
        
        /**
         *   call all methods through _dirfile object;
         * 
         * 
         */
      
    }
    
}
