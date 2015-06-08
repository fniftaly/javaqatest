/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.Date;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RandomController {
    
    @RequestMapping(value="getRandom.htm", method=RequestMethod.GET)
    public @ResponseBody String getRandom(){
      Random rnd = new Random();
      String result = "<br/>Response from controller " + rnd.nextFloat()*100 + " time " + new Date().toString();
      return result;
    }
    

    @RequestMapping(value="getUser.htm", method=RequestMethod.POST)
    public @ResponseBody String getUser(@RequestParam(value = "first") String first,
            @RequestParam(value = "last") String last){
        
//        System.out.println(first+" "+last);
        
      return first+" "+last;
    }
    
}
