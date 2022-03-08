/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author kristian
 */
public class Contact {
    private UUID id;
    private String name;
    private String email;
    private int rating;
    private List<String> types;
    private List<String> notifications;
    private String comments;

    public Contact() {
        this.id = UUID.randomUUID();
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public static List<String> getNotificationsList(){
        List<String> notificationsList = new ArrayList<>();
        for(Notifications notification : Notifications.values()){
            notificationsList.add(notification.getValue());
        }
        return notificationsList;
    }
    
    public static Map<String, String> getRatings(){
        
        Map<String, String> ratings = new HashMap<>();
        for(Rating rating : Rating.values()){
            ratings.put(rating.getValue(),rating.getDescription());
        }
        
        return ratings;
    }
    
    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name=" + name + ", email=" + email + ", rating=" + rating + ", types=" + types + ", notifications=" + notifications + ", comments=" + comments + '}';
    }

    
    
}
