/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author fundacion
 */
public class Billboard {
    List<Movie> movies = new ArrayList();
    
    public void showBillboard(){
        System.out.println("La cartelera es:");
        for(Movie movie : movies ){
            movie.show();
        }
    }
    public void addMovie(Movie movie){
        movies.add(movie);
    }
    public String[] getMovieNames(){
        String[] names = new String[movies.size()];
        for(int i = 0; i<movies.size(); i++){
            names[i] = movies.get(i).getName();
        }
        return names;
    }
    public void removeMovie(String name){
        for(int i = 0; i<movies.size(); i++){
            if(movies.get(i).getName().equalsIgnoreCase(name)){
                movies.remove(i);
            break;
            }
        }
    }
    public void updateMovie(String name){
        
    }
}
