/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.controllers;

import com.krisemm.app.models.Contact;
import com.krisemm.app.models.Movie;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.krisemm.app.services.MovieService;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 *
 * @author kristian
 */
@Controller
public class Web {
    
    @Autowired()
    @Qualifier("InMySQL")
    private MovieService movieService;
    private final int amountNextDates;
    private final DateTimeFormatter formatter;
    private List<Movie> movies;
    private List<String> nextDates;
    
    {
        amountNextDates = 5;
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }
  
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleShowRoot(Model model) {
        
        movies = movieService.all();
        nextDates = getNextDates(amountNextDates, LocalDate.now());       
        
        model.addAttribute("movies", movies);
        model.addAttribute("nextDates", nextDates);
        model.addAttribute("date", formatter.format(LocalDate.now()));
        System.out.println(movies);
        System.out.println(nextDates);
        
        return "index";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String handleShowSearch(
            Model model,
            @RequestParam(value = "date") String dateSelected
    ){
        movies = movieService.all();
        nextDates = getNextDates(amountNextDates, LocalDate.now()); 
        
        model.addAttribute("movies", movies);
        model.addAttribute("nextDates", nextDates);
        model.addAttribute("date", dateSelected);
        model.addAttribute("dateSelected", dateSelected);
        
        System.out.println(movies);
        System.out.println(nextDates);
        System.out.println(dateSelected);
        
        return "index";
    }
    
    @RequestMapping(value = "/details/{id}/{date}", method = RequestMethod.GET)
    public String handleShowDetails(
            Model model,
            @PathVariable("id") int idMovie, 
            @PathVariable("date") String date
    ) {
        
        model.addAttribute("movie", movieService.ById(idMovie));
        
        return "details";
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String handleShowContact(@ModelAttribute Contact contact, Model model){
        
        model.addAttribute("types", Movie.getTypesList());
        model.addAttribute("notifications", Contact.getNotificationsList());
        model.addAttribute("ratings", Contact.getRatings());
        
        return "formContact";
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String handleSaveContactInfo(@ModelAttribute Contact contact){
        System.out.println(contact);
        return "redirect:/contact";
    }
    
    private List<String> getNextDates(int amountDays, LocalDate fromTheDate){        
        
        List<String> dates = new ArrayList<>();
        Period period = Period.ofDays(1);
        
        if(amountDays <= 0) return dates;
        
        while(amountDays > 0){
            dates.add(fromTheDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            fromTheDate = fromTheDate.plus(period);
            --amountDays;
        }
        
        return dates;
    }
    
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String handleShowFormLogin(){
        return "formLogin"; 
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout(HttpServletRequest request){
        SecurityContextLogoutHandler logoutHandle = new SecurityContextLogoutHandler();
        logoutHandle.logout(request, null, null);
        return "redirect:/login";
    }
    
    @RequestMapping(value="/admin" ,method = RequestMethod.GET)
    public String handleShowAdmin(Authentication auth){
        Consumer<GrantedAuthority> action = x -> System.out.println(x.getAuthority());
        System.out.println(auth.getName());
        List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
        roles.forEach(action);
        return "admin";
    }
}
