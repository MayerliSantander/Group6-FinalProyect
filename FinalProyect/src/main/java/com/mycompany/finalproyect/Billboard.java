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
    
    public Billboard(){
       Movie movieTest = new Movie("test", "synopsis test", 777, "languages test", "genre test", "schedule test", "quality test");
       movies.add(movieTest);
    }
    
    public void showBillboard(){
        System.out.println("La cartelera es:");
        for(Movie movie : movies ){
            movie.show();
        }
    }
    public Movie showMovie(Movie name){
        System.out.println("Info: ");
        Movie [] movieToShow = new Movie[1];
        for(int i = 0; i<movies.size(); i++){
            if(movies.get(i).getName()==(name.toString())){
                movieToShow[0] = movies.get(i);
               System.out.println(movieToShow[0]);
                return movieToShow[0];
            }
        }
        return null;
    }
    public void showSumaryBillboard(){
        System.out.println("La cartelera es:");
        for(Movie movie : movies ){
            movie.showSumary();
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
    public void updateWholeMovie(String name, Movie movie){
        for(int i = 0; i<movies.size(); i++){
            if(movies.get(i).getName().equalsIgnoreCase(name)){
                movies.remove(i);
            break;
            }
        }
        movies.add(movie);
    }
    public Movie getMovie(String name){
        for(int i = 0; i<movies.size(); i++){
            if(movies.get(i).getName().equalsIgnoreCase(name)){
                return movies.get(i);
            }
        }
        return null;
    }


    public void showMoviesList(){
        for(Movie movie : movies ){
            movie.showTitleAndindex(movies.indexOf(movie)+1);
        }
    }
}
