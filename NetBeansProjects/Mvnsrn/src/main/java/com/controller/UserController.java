/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.google.gson.Gson;
import com.model.User;
import com.model.UserImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author farad
 */
@Controller
public class UserController {

    UserImpl usr = new UserImpl();
    ArrayList<User> users = new ArrayList();

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public @ResponseBody
    String addUser(@RequestParam(value = "first") String first,
            @RequestParam(value = "last") String last, @RequestParam(value = "email") String email,
            @RequestParam(value = "date") String date) {

        User newuser = new User(first, last, email, date);

        if (usr.addUser(newuser)) {

            return "User created!";

        } else {

            return "User is not created";
        }

    }

    /**
     *   Taking all registers users
     *   from table in this case from
     *   file
     *   gson API used for storing array into json format
     */
    @RequestMapping(value = "getUsers.htm", method = RequestMethod.GET)
    public @ResponseBody String getUsers() {
      usr.readfile();
//      
      HashMap<String, User> map = usr.getUser();
//      
        users.clear();
//        
        for (Map.Entry<String, User> entry : map.entrySet()) {
//            
           users.add(entry.getValue());
	}      
       Gson gson = new Gson();
//       
       String json = gson.toJson(users);
//      
      return json;
    }
    
    /**
     *   Delete user from db based on
     *   user email address
     *   
     *   then refresh HasMap for display
     */
    
    @RequestMapping(value = "deleteUser.htm", method = RequestMethod.POST)
    public @ResponseBody String deleteUser(@RequestParam(value = "email") String email) {
//        
     HashMap<String, User> allusr = usr.getUser();
//     
     if(usr.removeuser(email)){
//         
        usr.readfile();
//        
        return "User has been deleted!";
     }
//      
        return null;
    }

}
