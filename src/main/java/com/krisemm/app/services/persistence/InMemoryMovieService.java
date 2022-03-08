/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services.persistence;

import com.krisemm.app.models.Movie;
import com.krisemm.app.services.GenerateFakeMovies;
import com.krisemm.app.services.MovieService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
@Qualifier("InMemory")
public class InMemoryMovieService implements MovieService {
    
    private List<Movie> movies = new ArrayList<>();
    
    @Autowired
    public InMemoryMovieService(GenerateFakeMovies generateFakeMovies) {
        this.movies = generateFakeMovies.generateList();
    }
    
    @Override
    public void save(Movie movie) {
        movies.add(movie);
        System.out.println("New Movie Saved");
        System.out.println(movie);
        System.out.println(movies);
    }

    @Override
    public List<Movie> all() {
        return movies;
    }

    @Override
    public Movie ById(Integer id) {
        for(Movie movie : movies){
            if(movie.getId() == id  ) return movie; 
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
