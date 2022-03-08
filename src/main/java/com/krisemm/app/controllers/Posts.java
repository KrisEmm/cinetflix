/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.controllers;

import com.krisemm.app.models.Post;
import com.krisemm.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kristian
 */
@Controller
@RequestMapping(value = "/posts")
public class Posts {
    
    @Autowired
    @Qualifier("InMySQL")
    private PostService postService;
    
    @GetMapping(value = "/add")
    public String handleAddPosts(){
        return "posts/formCreateNewPost";
    }
    
    @PostMapping(value = "/add")
    public String handleCreatePost(Post post, BindingResult result){
       
       if(result.hasErrors()){
            System.out.println(result);
            for(ObjectError error : result.getAllErrors()){
                System.out.println(error.getDefaultMessage());
            }
        }else{
            postService.save(post);
        }

       return "posts/formCreateNewPost";
    }
}
