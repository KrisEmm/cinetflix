/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.Post;
import com.krisemm.app.services.PostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMemory")
public class InMemoryPostService implements PostService {

    private List<Post> posts = new ArrayList<>();
    
    @Override
    public String save(Post post) {
        System.out.println("New Post Saved");
        System.out.println(post);
        return "Nueva Noticia Agregada Correctamente";
    }

    @Override
    public List<Post> all() {
        return posts;
    }   
    
}
