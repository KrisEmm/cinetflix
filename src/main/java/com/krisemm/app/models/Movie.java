/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krisemm.app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author kristian
 */
@Entity
@Table(name="Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;
    private String classification;
    private String type;
    private String image;
    private String status;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date releaseDate;
    @OneToOne
    @JoinColumn(name="idDetail")
    private Detail detail;
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Timetable> timetables;
    
    {
        image = "cinema.png";
        status = "Active";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
    }
    
    
    public static List<String> getTypesList(){
        
        List<String> typesList = new ArrayList<>();
        
        for(Types type : Types.values()){
            typesList.add(type.getValue());
        }
        return typesList;
    } 
    
    public static List<String> getClassificationsList(){
        List<String> classificationsList = new ArrayList<>();
        
        for(Classifications classification : Classifications.values()){
            classificationsList.add(classification.toString());
        }
        return classificationsList;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", duration=" + duration + ", classification=" + classification + ", type=" + type + ", image=" + image + ", status=" + status + ", releaseDate=" + releaseDate + ", detail=" + detail + ", timetables=" + timetables + '}';
    }

   

      
}
  