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
    public Customer(Cinema cinema){
        this.cinema = cinema;
    }
    public void showCustomerOptions(){
        int chosenOption;
        Scanner menu = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        boolean salir = false;
        while(salir == false){
            System.out.println("\n***********************************"
                    + "\n*****BIENVENIDO CLIENTE*****"
                    + "\n***********************************"
                    + "\n* 1. Mostrar Cartelera               *"
                    + "\n* 2. Ver reseñas                        *"
                    + "\n* 3. Reservar Entradas            *"
                    + "\n* 4. Calificar y Comentar una Pelicula            *"
                    + "\n* 5. Salir                        *"
                    + "\n***********************************");
            //Moverse por el Menu
            chosenOption = menu.nextInt();
            switch (chosenOption) {
                case 1:
                    cinema.billboard.showSumaryBillboard();
                    
                    break;
                case 2:
                    viewReviews();
                    break;
                case 3:
                        
                    break;
                case 4:
                    reviewMenu();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }

    private void reviewMenu(){
        int i = setIndexMovie();
        Review review = new Review();
        cinema.billboard.movies.get(i).addReview(review);
    }

    private void viewReviews() {
        int i = setIndexMovie();
        cinema.billboard.movies.get(i).showReviews();
    }

    private int setIndexMovie() {
        System.out.println("\nIngrese el indice de la pelicula que quieres calificar");
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
