/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.controllers;

import com.krisemm.app.models.Movie;
import com.krisemm.app.services.DetailService;
import com.krisemm.app.services.ManagerUploadedFiles;
import com.krisemm.app.services.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author kristian
 */
@Controller
@RequestMapping(value = "/movies")
public class Movies {

    @Autowired
    @Qualifier("InMySQL")
    private MovieService movieService;
    @Autowired
    @Qualifier("InMySQL")
    private DetailService detailService;
    @Autowired
    private ManagerUploadedFiles managerUploadedFiles;
    
    @GetMapping(value = "/list")
    public String handleRoot(Model model) {
        List<Movie> movies = movieService.all();
        model.addAttribute("movies", movies);
        return "movies/listMovies";
    }

    @GetMapping(value = "/add")
    public String handleAddMovie(@ModelAttribute Movie movie) {
        return "movies/formCreateNewMovie";
    }

    @PostMapping(value = "/add")
    public String handleCreateNewMovie(
            @RequestParam("imageFile") MultipartFile file,
            @ModelAttribute Movie movie,
            BindingResult result,
            RedirectAttributes attributes
    ) {
        if (result.hasErrors()) {

            System.out.println(result);
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            return "movies/formCreateNewMovie";

        } else {

            if (!file.isEmpty()) {
                movie.setImage(managerUploadedFiles.store(file));
            }
            String action = movie.getId() != 0 ? "Se ha actualizado":"Se ha agregado";
            String message = action +" "+movie.getTitle()+" "+"correctamente";
            System.out.println(movie);
            detailService.save(movie.getDetail());
            movieService.save(movie);
            attributes.addFlashAttribute("message", message);
        }
        return "redirect:/movies/list";
    }
    
    @GetMapping(value="/edit/{id}")
    public String handleEditMove(@PathVariable("id") int idMovie, Model model){
        model.addAttribute("movie", movieService.ById(idMovie));
        return "movies/formCreateNewMovie";
    }
    
    @GetMapping(value = "/delete/{id}")
    public String handleDeleteMove(@PathVariable("id") int idMovie, RedirectAttributes attributes){
        Integer idDetail = movieService.ById(idMovie).getDetail().getId();
        String message = "Se ha eliminado"+ " "+movieService.ById(idMovie).getTitle()+" "+"correctamente";
        movieService.delete(idMovie);
        detailService.delete(idDetail);
        attributes.addFlashAttribute("message", message);
        return "redirect:/movies/list";
    }
    
    @ModelAttribute("types")
    public List<String> setTypesList(){
        return Movie.getTypesList();
    }
    @ModelAttribute("classifications")
    public List<String>  setClassificationsList(){
        return Movie.getClassificationsList();
    }
}
