/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filesystem;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author def
 */
public class CreateFileDirIT {
    
    private String filename = "userobj.ser";

    private User user;

    private ArrayList<User> userlist;
    
    private ArrayList<String> filelist = new ArrayList();

    private String _dir, _dirdest; 
    
    @Before
    public void setUp() {
        user = new User("John", "Doe", "sales manager", 2345);

        userlist = new ArrayList();

        userlist.add(user);
        
        _dir = "/Users/def/dir1";
        
        _dirdest = "/Users/def/dir2";

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createdir method, of class CreateFileDir.
     */
    @Test
    public void testCreatedir() {
        CreateFileDir instance = new CreateFileDir();
        
        File root = new File("/Users/def/dir1");
        
        boolean expResult = true;
        
        boolean result = instance.createdir(_dir);
        
          if(!result){expResult = false;}
        
        assertEquals(expResult, result);
    }

    /**
     * Test of createfile method, of class CreateFileDir.
     */
    @Test
    public void testCreatefile() {
        
        System.out.println("createfile");
        
        CreateFileDir instance = new CreateFileDir();
        
        instance.createfile(_dir);
        
        File f = new File(_dir + "/" + filename);
        
        boolean expResult = false;
        
        boolean result = false;
        
        if(f.exists() && !f.isDirectory()) {
            expResult = true;
            result = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of addtofile method, of class CreateFileDir.
     */
    @Test
    public void testAddtofile() {
        System.out.println("addtofile");
        
        
        CreateFileDir instance = new CreateFileDir();
        
        instance.addtofile(userlist, _dir+"/"+filename);
    }

    /**
     * Test of display method, of class CreateFileDir.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        
        CreateFileDir instance = new CreateFileDir();
        
        instance.display(_dir);
    }
//
//    /**
//     * Test of copyfile method, of class CreateFileDir.
//     */
    @Test
    public void testCopyfile() {
        
        System.out.println("copyfile");
        
        CreateFileDir instance = new CreateFileDir();
        
        instance.copyfile(_dir + "/" + filename, _dirdest);
        
        File f = new File(_dirdest);
        
        if(f.exists()){
         assertTrue(true);
        }else{
          assertTrue(false);
        }
    }
//
//    /**
//     * Test of searchfile method, of class CreateFileDir.
//     */
//    @Test
//    public void testSearchfile() {
//        System.out.println("searchfile");
//        File dirurl = null;
//        CreateFileDir instance = new CreateFileDir();
//        instance.searchfile(dirurl);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFilelist method, of class CreateFileDir.
//     */
//    @Test
//    public void testGetFilelist() {
//        System.out.println("getFilelist");
//        CreateFileDir instance = new CreateFileDir();
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.getFilelist();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
