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
                    + "\n* 1. Añadir Pelicula               *"
                    + "\n* 2. Quitar Pelicula            *"
                    + "\n* 3. Mostrar Cartelera            *"
                    + "\n* 4. Salir                        *"
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
                    int duration = datos.nextInt();
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
                    int chosenMovie = datos.nextInt();
                    if(chosenMovie>names.length || chosenMovie<=0){
                        System.out.println("Numero no esta en la lista");
                    } else{
                        cinema.billboard.removeMovie(names[chosenMovie-1]);
                        System.out.println("Se ha removido la Pelicula "+ names[chosenMovie-1]);
                    }
                    break;
                case 3:
                    cinema.billboard.showBillboard();
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