package com.mycompany.finalproyect;


import java.util.Scanner;

public class menu {
    Cinema cinema;
    public int op, money = 0;

    public menu(Cinema cinema) {
        this.cinema=cinema;

        tickets tickets = new tickets();
        Scanner reader = new Scanner(System.in);
    }


    public void elmenu(){
        tickets tickets = new tickets();
        Scanner reader = new Scanner(System.in);

            do {
                System.out.println("Elija la pelicula que desea reservar:");
                cinema.billboard.showMoviesList();
                int chosenMovie = reader.nextInt();
                if (chosenMovie > cinema.billboard.movies.size() || chosenMovie <= 0){
                    System.out.println("Numero no esta en la lista");
                } else tickets.menu();
                System.out.println("\n******************************************"
                    + "\n************ELIGE UNA OPCION************"
                    + "\n*****************************************"
                    + "\n* 1. Reservar más Entradas              *"
                    + "\n* 2. Salir                              *"
                    + "\n*****************************************");
                op= reader.nextInt();
            }
                while (op != 2) ;
                System.out.println("*****|||*******   Total dinero por entradas: "+tickets.do2+"   *****|||******* ");
                System.out.println("*****|||*******   Total de entradas: "+tickets.ntickets+"            *****|||******* ");
                money = tickets.do2;
                System.out.println("*****|||*******   Total a pagar es: "+money+"            *****|||*******");
                System.out.println("*****************************************************************");



    }
}