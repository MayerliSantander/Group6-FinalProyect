/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;

import javax.xml.validation.Validator;

/**
 *
 * @author fundacion
 */
public class Customer {
    Cinema cinema;
    User usuario;
    public Customer(Cinema cinema, User usuario){
        this.cinema = cinema;
        this.usuario = usuario;
    }
    public void showCustomerOptions(){
        Gamificacion gm = new Gamificacion();
        int chosenOption;
        Scanner menu = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        boolean salir = false;
        while(salir == false){
            System.out.println("\n******************************************"
                    + "\n************BIENVENIDO CLIENTE************"
                    + "\n******************************************"
                    + "\n* 1. Mostrar Cartelera                   *"
                    + "\n* 2. Ver reseñas                         *"
                    + "\n* 3. Reservar Entradas                   *"
                    + "\n* 4. Calificar y Comentar una Pelicula   *"
                    + "\n* 5. Retos, trofeos y canjeo de premios  *"
                    + "\n* 6. Salir                               *"
                    + "\n******************************************");
            //Moverse por el Menu
            chosenOption = menu.nextInt();
            switch (chosenOption) {
                case 1:
                    cinema.billboard.showSumaryBillboard();
                    int chosenOpt;
                    Scanner numInput = new Scanner(System.in);
                    Scanner textInput = new Scanner(System.in);
                    boolean out = false;
                    while(out == false){
                        System.out.println("\n********************************************"
                        + "\n**************ELIGE UNA OPCION**************"
                        + "\n********************************************"
                        + "\n* 1. Mostrar Info Detallada de Pelicula    *"
                        + "\n* 2. Salir                                 *"
                        + "\n********************************************");
                        chosenOpt = numInput.nextInt();
                        switch (chosenOpt) {
                            case 1:
                                System.out.println("\n***********************************************\n* Elige de que Pelicula ver la info completa: *\n***********************************************");
                                var names = cinema.billboard.getMovieNames();
                                for(int i = 0; i<names.length; i++){
                                    System.out.println((i + 1) + ". " + names[i]);
                                }
                                int chosenMovie = numInput.nextInt();
                                var movieToShow = cinema.billboard.getMovie(names[chosenMovie-1]);
                                if(chosenMovie>names.length || chosenMovie<=0){
                                    System.out.println("Numero no esta en la lista");
                                } else{
                                    movieToShow.show();
                                }
                                break;
                            case 2:
                                out = true;
                                break;
                            default:
                                System.out.println("Opción invalida");
                                break;
                        }
                    }
                    break;
                case 2:
                    viewReviews();
                    break;
                case 3:
                    menu men = new menu(cinema);
                    men.elmenu();

                    break;
                case 4:
                    reviewMenu();
                    break;
                case 5:
                    gm.showGamificacion();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
        }


    private void reviewMenu(){
        int i = setIndexMovie(2);
        Review review = new Review(usuario);
        cinema.billboard.movies.get(i).addReview(review);
    }

    private void viewReviews() {
        int i = setIndexMovie(1);
        cinema.billboard.movies.get(i).showReviews(usuario);
    }

    private int setIndexMovie(int in) {
        if (in==1){
            System.out.println("\nMostrar reseña de pelicula: ");
        }
        if (in==2){
            System.out.println("\nIngrese el indice de la pelicula a calificar");
        }
        cinema.billboard.showMoviesList();
        int i= 0;
        boolean valid = false;
        while(!valid){
            Scanner scan = new Scanner(System.in);
            i = scan.nextInt();
            if(i <= 0 || i > cinema.billboard.movies.size()){
                valid = false;
                System.out.println("valor fuera del limite, vuelva a intentarlo");
            }else{
                valid = true;
            }
        }
        return i-1;
    }
}
