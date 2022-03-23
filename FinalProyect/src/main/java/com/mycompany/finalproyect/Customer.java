/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;

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
                    + "\n* 2. Reservar Entradas            *"
                    + "\n* 3. Calificar y Comentar una Pelicula            *"
                    + "\n* 4. Salir                        *"
                    + "\n***********************************");
            //Moverse por el Menu
            chosenOption = menu.nextInt();
            switch (chosenOption) {
                case 1:
                    cinema.billboard.showBillboard();
                    break;
                case 2:
                    
                    break;
                case 3:
                    // System.out.println("\nIngrese el indice de la pelicula que quieres calificar");
                    // cinema.billboard.showMoviesList();
                    // Scanner scan = new Scanner(System.in);
                    // int i = scan.nextInt();
                    // Review review = new Review();
                    // cinema.billboard.movies.get(i).addReview(review);
                    // scan.close();
                    
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }
}
