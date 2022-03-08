/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.Movie;
import com.krisemm.app.repositories.MovieRepositoryJPA;
import com.krisemm.app.services.MovieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMySQL")
public class InMySQLMovieService implements MovieService {
    
    @Autowired
    private MovieRepositoryJPA repository;
    
    @Override
    public void save(Movie movie) {
        repository.save(movie);
    }

    @Override
    public List<Movie> all() {
        return repository.findAll();
    }

    @Override
    public Movie ById(Integer id) {
        Optional<Movie> optional = repository.findById(id);
        return optional.get();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}
