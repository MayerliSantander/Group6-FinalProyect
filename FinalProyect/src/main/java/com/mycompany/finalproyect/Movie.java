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
 class Movie {
    String name;
    String synopsis;
    int duration;
    String languages;
    String genre;
    String schedule;
    String quality;
    boolean info = false;
    List<Review> reviews = new ArrayList<Review>();

    public Movie(String name, String synopsis, int duration, String languages, String genre, String schedule, String quality) {
        this.name = name;
        this.synopsis = synopsis;
        this.duration = duration;
        this.languages = languages;
        this.genre = genre;
        this.schedule = schedule;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void showSumary() {
        System.out.println("Titulo: " + getName());
        System.out.println("Sinopsis: " + getSynopsis());
        System.out.println("\n");
    }

    public void show() {
        System.out.println("****************************************************\n* -Titulo: " + getName());
        System.out.println("* -Sinopsis: " + getSynopsis());
        System.out.println("* -Duracion: " + getDuration() +" min.");
        System.out.println("* -Lenguajes: " + getLanguages());
        System.out.println("* -Género: " + getGenre());
        System.out.println("* -Horario: " + getSchedule());
        System.out.println("* -Calidad: " + getQuality() +"\n****************************************************");
        System.out.println("\n");
        if (info == false) {
            User.dailyinfos++;
            User.infos++;
            info = true;
        }
    }

    //metodos para review
    public void showTitleAndindex(int index) {
        System.out.println(index + ".- Titulo: " + getName());
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void showReviews(User usuario) {
        for (Review review : reviews) {
            System.out.println("_____________________");
            System.out.print("|");
            System.out.print(review.getUsername());
            System.out.println("\n|Calificación: " + review.getRanking() + "/5");
            System.out.println("|Comentario: " + review.getComment());
        }
    }


    }
