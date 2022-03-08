/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.services;

import com.krisemm.app.models.Movie;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kristian
 */
@Service
public class GenerateFakeMovies {
        
    public List<Movie> generateList(){
        List<Movie> movies = new ArrayList<>();
//        String release = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Movie movie_1 = new Movie();
        movie_1.setTitle("Kong La Isla Calavera");
        movie_1.setDuration(118);
        movie_1.setClassification("B");
        movie_1.setType("Acción y Aventura");
//        movie_1.setRelease(release);
        
        Movie movie_2 = new Movie();
        movie_2.setTitle("Logan: Wolverine");
        movie_2.setDuration(135);
        movie_2.setClassification("C");
        movie_2.setType("Acción");
//        movie_2.setRelease(release);
        
        Movie movie_3 = new Movie();
        movie_3.setTitle("Fragmentado");
        movie_3.setDuration(118);
        movie_3.setClassification("B15");
        movie_3.setType("Thriller");
//        movie_3.setRelease(release);
        
        Movie movie_4 = new Movie();
        movie_4.setTitle("En este Rincón del Mundo");
        movie_4.setDuration(130);
        movie_4.setClassification("A");
        movie_4.setType("Drama");
//        movie_4.setRelease(release);
                
        movies.add(movie_1);
        movies.add(movie_2);
        movies.add(movie_3);
        movies.add(movie_4);

        return movies;
    }
}
