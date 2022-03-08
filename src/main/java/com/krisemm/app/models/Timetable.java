/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.models;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author kristian
 */
@Entity
@Table(name="Timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateAvailable;
    private LocalTime hourAvailable;
    private String room;
    private double price;
    @ManyToOne
    @JoinColumn(name = "idMovie")
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(LocalDate dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public LocalTime getHourAvailable() {
        return hourAvailable;
    }

    public void setHourAvailable(LocalTime hourAvailable) {
        this.hourAvailable = hourAvailable;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Timetable{" + "id=" + id + ", dateAvailable=" + dateAvailable + ", hourAvailable=" + hourAvailable + ", room=" + room + ", price=" + price + ", movie=" + movie + '}';
    }

    
    
}
