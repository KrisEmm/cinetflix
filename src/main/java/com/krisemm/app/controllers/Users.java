/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.controllers;

import com.krisemm.app.models.Profile;
import com.krisemm.app.models.User;
import com.krisemm.app.services.ProfileService;
import com.krisemm.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kristian
 */
@Controller
@RequestMapping(value = "/users")
public class Users {
    
    @Autowired
    private BCryptPasswordEncoder bcript;
    @Autowired 
    private UserService userService;
    @Autowired 
    private ProfileService profileService;
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String handleShowFormNewUser(@ModelAttribute User user){
        return "users/formCreateNewUser";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String handleSaveNewUser(@ModelAttribute User user, @RequestParam("profile") String nameProfile){
        Profile profile = new Profile();
        profile.setUsername(user.getUsername());
        profile.setProfile(nameProfile);
        String encript = bcript.encode(user.getPassword());
        user.setPassword(encript);
        user.setActive(1);
        userService.save(user);
        profileService.save(profile);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/encrypt")
    public String handleEncript(){
        String password = "hithere";
        String encript = bcript.encode(password);
        System.out.println(encript);
        return "redirect:/";
    }
}
