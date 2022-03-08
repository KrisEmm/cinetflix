/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.repositories;

import com.krisemm.app.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kristian
 */
@Repository
public interface MovieRepositoryJPA extends JpaRepository<Movie,Integer> {
    
}
