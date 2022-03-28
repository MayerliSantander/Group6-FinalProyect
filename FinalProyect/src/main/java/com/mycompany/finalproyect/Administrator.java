/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;

/**
 *
 * @author Mayerli
 */
public class Administrator {
    Cinema cinema;
    public Administrator(Cinema cinema){
        this.cinema = cinema;
    }
    public void showAdministratorOptions(){
        int chosenOption;
        Scanner menu = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        boolean salir = false;
        while(salir == false){
            System.out.println("\n***********************************"
                    + "\n*****BIENVENIDO ADMINISTRADOR*****"
                    + "\n***********************************"
                    + "\n* 1. Añadir Pelicula                  *"
                    + "\n* 2. Quitar Pelicula                  *"
                    + "\n* 3. Actualizar toda una Pelicula     *"
                    + "\n* 4. Actualizar parte de una Pelicula *"
                    + "\n* 5. Mostrar Cartelera                *"
                    + "\n* 6. Modificar Gamificacion           *"
                    + "\n* 7. Salir                            *"
                    + "\n***********************************");
            //Moverse por el Menu
            chosenOption = menu.nextInt();
            switch (chosenOption) {
                case 1:
                    System.out.println("\n**********************************\n* Ingrese nombre de la Pelicula: *\n**********************************");
                    String name = datos.nextLine();
                    System.out.println("**************************\n* Ingrese su sinopsis: *\n**************************");
                    String synopsis = datos.nextLine();
                    System.out.println("**************************\n* Ingrese su duracion en minutos: *\n**************************");
                    int duration = menu.nextInt();
                    System.out.println("**************************\n* Ingrese su lenguaje: *\n**************************");
                    String language = datos.nextLine();
                    System.out.println("**************************\n* Ingrese su género: *\n**************************");
                    String genre = datos.nextLine();
                    System.out.println("**************************\n* Ingrese el horario: *\n**************************");
                    String schedule = datos.nextLine();
                    System.out.println("**************************\n* Ingrese la calidad: *\n**************************");
                    String quality = datos.nextLine();
                    var movie = new Movie(name, synopsis, duration, language, genre, schedule, quality);
                    cinema.addMovieToBillboard(movie);
                break;
                case 2:
                    System.out.println("\n**********************************\n* Seleccione la Pelicula a eliminar: *\n**********************************");
                    var names = cinema.billboard.getMovieNames();
                    for(int i = 0; i<names.length; i++){
                        System.out.println((i + 1) + ". " + names[i]);
                    }
                    int chosenMovie = menu.nextInt();
                    if(chosenMovie>names.length || chosenMovie<=0){
                        System.out.println("Numero no esta en la lista");
                    } else{
                        cinema.billboard.removeMovie(names[chosenMovie-1]);
                        System.out.println("Se ha removido la Pelicula "+ names[chosenMovie-1]);
                    }
                    break;
                case 3:
                    System.out.println("\n**********************************\n* Seleccione la Pelicula a actualizar completamente: *\n**********************************");
                    var namesMovies = cinema.billboard.getMovieNames();
                    for(int i = 0; i<namesMovies.length; i++){
                        System.out.println((i + 1) + ". " + namesMovies[i]);
                    }
                    int movieToUpdate = menu.nextInt();
                    if(movieToUpdate>namesMovies.length || movieToUpdate<=0){
                        System.out.println("Numero no esta en la lista");
                    } else{
                        System.out.println("\n**********************************\n* Ingrese nombre de la Pelicula por la que se actualizara: *\n**********************************");
                        String nameMovie = datos.nextLine();
                        System.out.println("**************************\n* Ingrese su sinopsis: *\n**************************");
                        String synopsisMovie = datos.nextLine();
                        System.out.println("**************************\n* Ingrese su duracion en minutos: *\n**************************");
                        int durationMovie = menu.nextInt();
                        System.out.println("**************************\n* Ingrese su lenguaje: *\n**************************");
                        String languageMovie = datos.nextLine();
                        System.out.println("**************************\n* Ingrese su género: *\n**************************");
                        String genreMovie = datos.nextLine();
                        System.out.println("**************************\n* Ingrese el horario: *\n**************************");
                        String scheduleMovie = datos.nextLine();
                        System.out.println("**************************\n* Ingrese la calidad: *\n**************************");
                        String qualityMovie = datos.nextLine();
                        var movieUpdate = new Movie(nameMovie, synopsisMovie, durationMovie, languageMovie, genreMovie, scheduleMovie, qualityMovie);
                        
                        cinema.billboard.updateWholeMovie(namesMovies[movieToUpdate-1],movieUpdate);
                        System.out.println("Se ha actualizado toda la Pelicula "+ namesMovies[movieToUpdate-1]);
                    }
                    break;
                case 4:
                    System.out.println("\n**********************************\n* Seleccione la Pelicula a actualizar: *\n**********************************");
                    var namesMoviesToUpdate = cinema.billboard.getMovieNames();
                    for(int i = 0; i<namesMoviesToUpdate.length; i++){
                        System.out.println((i + 1) + ". " + namesMoviesToUpdate[i]);
                    }
                    int moviesToUpdate = datos.nextInt();
                    var movieToBeUpdated = cinema.billboard.getMovie(namesMoviesToUpdate[moviesToUpdate-1]);
                    if(moviesToUpdate>namesMoviesToUpdate.length || moviesToUpdate<=0){
                        System.out.println("Numero no esta en la lista");
                    } else{
                        Scanner numInput = new Scanner(System.in);
                        Scanner textInput = new Scanner(System.in);
                        System.out.println("\n**********************************\n* Elija la información que se actualizara: *\n**********************************");
                        int chosenOpt;
                        System.out.println("\n***********************************"
                        + "\n*****BIENVENIDO ADMINISTRADOR*****"
                        + "\n***********************************"
                        + "\n* 1. Sinopsis                     *"
                        + "\n* 2. Duración                     *"
                        + "\n* 3. Lenguaje                     *"
                        + "\n* 4. Género                       *"
                        + "\n* 5. Horario                      *"
                        + "\n* 6. Calidad                      *"
                        + "\n***********************************");
                        chosenOpt = numInput.nextInt();
                        switch (chosenOpt) {
                            case 1:
                                System.out.println("**************************\n* Ingrese su sinopsis: *\n**************************");
                                String newSynopsis = textInput.nextLine();
                                movieToBeUpdated.setSynopsis(newSynopsis);
                                break;
                            case 2:
                                System.out.println("**************************\n* Ingrese su duracion en minutos: *\n**************************");
                                int newDuration = numInput.nextInt();
                                movieToBeUpdated.setDuration(newDuration);
                                break;
                            case 3:
                                System.out.println("**************************\n* Ingrese su lenguaje: *\n**************************");
                                String newLanguage = textInput.nextLine();
                                movieToBeUpdated.setLanguages(newLanguage);
                                break;
                            case 4:
                                System.out.println("**************************\n* Ingrese su género: *\n**************************");
                                String newGenre = textInput.nextLine();
                                movieToBeUpdated.setGenre(newGenre);
                                break;
                            case 5:
                                System.out.println("**************************\n* Ingrese el horario: *\n**************************");
                                String newSchedule = textInput.nextLine();
                                movieToBeUpdated.setSchedule(newSchedule);
                                break;
                            case 6:
                                System.out.println("**************************\n* Ingrese la calidad: *\n**************************");
                                String newQuality = textInput.nextLine();
                                movieToBeUpdated.setQuality(newQuality);
                                break;
                            default:
                                System.out.println("Opción invalida");
                                break;
                        }
                    }
                    break;
                case 5:
                    cinema.billboard.showBillboard();
                    break;
                case 6:
                    Gamificacion.modifyGamificacion();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }
}