/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;
/**
 *
 * @author fundacion
 */
public class Cinema {
    private String name;
    int phoneNumber;
    String emailAdress;
    //List<Sala> salas;
    Billboard billboard = new Billboard();
    public void addMovieToBillboard(Movie movie){
        billboard.addMovie(movie);
    }
}
