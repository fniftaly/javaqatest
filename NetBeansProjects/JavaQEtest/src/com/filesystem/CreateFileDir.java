/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author def
 */
public class CreateFileDir implements Create_dir_file {

    private String filename = "userobj.ser";

    private User user, user2, user3;

    private ArrayList<User> userlist;
    
    private ArrayList<String> filelist = new ArrayList();

    public CreateFileDir() {

    }

    @Override
    public boolean createdir(String dirurl) {

        File file = new File(dirurl);

        if (!file.exists()) {

            if (file.mkdir()) {
                System.out.println("Directory is created!");
                return true;
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        return false;
    }

    @Override
    public void createfile(String dirurl) {
        try {
            FileOutputStream fos = new FileOutputStream(dirurl + "/" + filename);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void addtofile(ArrayList<User> user, String fileurl) {
        try {
            FileOutputStream fos = new FileOutputStream(fileurl);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    @Override
    public boolean display(String fileurl) {
        try {
            FileInputStream fis = new FileInputStream(fileurl + "/" + filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.userlist = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            System.err.println("An IOException was caught!");
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        Iterator<User> iterator = userlist.iterator();
        while (iterator.hasNext()) {
            User userobj = iterator.next();
            System.out.println("ID: " + userobj.getUserid() + " FirstName: " + userobj.getFirstname()
                    + " LastName: " + userobj.getLastname()+ " Title: " + userobj.getTitle());
        }
        if(userlist.size() != 0){ return true;}
        else{return false;}
    }

    @Override
    public void copyfile(String sourceurl, String desturl) {

        InputStream inStream = null;
        OutputStream outStream = null;
        try {

            File file1 = new File(sourceurl);
            File file2 = new File(desturl);

            inStream = new FileInputStream(file1);
            outStream = new FileOutputStream(file2);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            if (inStream != null) {
                inStream.close();
            }
            if (outStream != null) {
                outStream.close();
            }

            System.out.println("File Copied..");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void searchfile(File dirurl) {
        
       if (dirurl.isDirectory()) {
	    search(dirurl);
	} else {
	    System.out.println(dirurl.getAbsoluteFile() + " is not a directory!");
	}
       
    }
    
    
    private void search(File file) {
 
	if (file.isDirectory()) {
 
	    if (file.canRead()) {
		for (File temp : file.listFiles()) {
		    if (temp.isDirectory()) {
			search(temp);
		    } else {
			if (filename.equals(temp.getName().toLowerCase())) {			
			    filelist.add(temp.getAbsoluteFile().toString());
		    }
 
		}
	    }
 
	 } else {
		System.out.println(file.getAbsoluteFile() + "You have no permission to access this file");
	 }
      }
 
  }


    public ArrayList<String> getFilelist() {
        return filelist;
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(ArrayList<User> userlist) {
        this.userlist = userlist;
    }

    public void setFilelist(ArrayList<String> filelist) {
        this.filelist = filelist;
    }
    
}
