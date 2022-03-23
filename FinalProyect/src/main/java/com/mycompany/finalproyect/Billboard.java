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
    public String[] getMovieInformation(){
        
        String[] synopsis = new String[movies.size()];
        String[] duration = new String[movies.size()];
        String[] languages = new String[movies.size()];
        String[] genre = new String[movies.size()];
        String[] schedule = new String[movies.size()];
        String[] quality = new String[movies.size()];
        for(int i = 0; i<movies.size(); i++){
            synopsis[i] = movies.get(i).getSynopsis();
            //duration[i] = movies.get(i).getDuration();
            languages[i] = movies.get(i).getLanguages();
            genre[i] = movies.get(i).getGenre();
            schedule[i] = movies.get(i).getSchedule();
            quality[i] = movies.get(i).getQuality();
        }
        return synopsis;
    }


    public void showMoviesList(){
        for(Movie movie : movies ){
            movie.showTitleAndindex(movies.indexOf(movie));
        }
    }
}
