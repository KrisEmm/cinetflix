/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services;

import com.krisemm.app.models.Post;
import java.util.List;

/**
 *
 * @author kristian
 */
public interface PostService {
    String save(Post post);
    List<Post> all();
}
