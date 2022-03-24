/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mayerli
 */
public class Movie {
    String name;
    String synopsis;
    int duration;
    String languages;
    String genre;
    String schedule;
    String quality;
    List<Review> reviews = new ArrayList<Review>();
    public Movie(String name, String synopsis, int duration, String languages, String genre, String schedule, String quality){
        this.name = name;
        this.synopsis = synopsis;
        this.duration = duration;
        this.languages = languages;
        this.genre = genre;
        this.schedule = schedule;
        this.quality = quality;
    }
    
    public String getName(){
        return name;
    }
    public String getSynopsis(){
        return synopsis;
    }
    public int getDuration(){
        return duration;
    }
    public String getLanguages(){
        return languages;
    }
    public String getGenre(){
        return genre;
    }
    public String getSchedule(){
        return schedule;
    }
    public String getQuality(){
        return quality;
    }
    public void show(){
        System.out.println("Titulo: " + getName());
        System.out.println("Sinopsis: " + getSynopsis());
        System.out.println("Duracion: " + getDuration());
        System.out.println("Lenguajes: " + getLanguages());
        System.out.println("Género: " + getGenre());
        System.out.println("Horario: " + getSchedule());
        System.out.println("Calidad: " + getQuality());
        System.out.println("\n");
    }

    //metodos para review
    public void showTitleAndindex(int index){
        System.out.println(index + ".- Titulo: " + getName());
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
    public void showReviews(){
        for(Review review : reviews ){
            System.out.println("_____________________");
            System.out.print("|-");
            for(int i = 0; i < review.getRanking(); i++){
                System.out.print("-$");
            }
            System.out.println("\n|--" + review.getRanking() + "/5");
            System.out.println("|--" + review.getComment());
        }
    }
}
