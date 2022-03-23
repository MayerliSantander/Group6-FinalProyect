/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;
import java.util.Random;

public final class Gamificacion {
    static Random rd = new Random();
    String dailygenre, challenge;
    Scanner sn = new Scanner(System.in);
    //Esto es solo de prueba
<<<<<<< HEAD
    int dailyrew = 4;
    int dailytcks = 6;
    int dailyinfo = 8;
=======
    int dailyrew = 7;//Reviews.getDailyRewind();
    int dailytcks = 7;//Tickets.getDailyTickets();
    int dailyinfo = 7;//Cartelera.getDailyInfo();
>>>>>>> 3e81d5a0298f478027e61c20235fbba1ceeb783b
    int points, count;
    boolean daily = true, week = true;
    Challenge reto1 = new Challenge("Hacer","reviews", 5, dailyrew,5);
    Challenge reto2 = new Challenge("Reservar","entradas", 5, dailytcks,10);
    Challenge reto3 = new Challenge("Ver","infos", 5, dailyinfo, 1);
    Challenge reto4 = new Challenge("Cumplir los","retos de la fila 1",7, reto1.weekcount,3);
    Challenge reto5 = new Challenge("Cumplir los","retos de la fila 2",7, reto2.weekcount,5);
    Challenge reto6 = new Challenge("Cumplir los","retos de la fila 3",7, reto3.weekcount,2);
    Challenge[] challdaily = {reto1,reto2,reto3};
    Challenge[] challweek = {reto4,reto5,reto6};
    Challenge[] challtotal ={reto1,reto2,reto3,reto4,reto5,reto6};
    Gamificacion() {
        //esto es de prueba
        if(this.daily == true){
            dailyrandomgenre(this.challdaily);
            this.daily = false;
        }
        Challenge.CompleteChallenge(this.challtotal);
        getGenre();
        this.points = Challenge.getPoints(challtotal, this.points);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Puntos: "+this.points);
        ShowChallenge();
        
    }
    public void ShowChallenge(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("Retos diarios:");
        System.out.println("--------------------------------------------------------------");
        Challenge.printChallenge(this.challdaily);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Retos semanales:");
        System.out.println("--------------------------------------------------------------");
        Challenge.printChallenge(this.challweek);
        System.out.println("--------------------------------------------------------------");
    }
    public void dailyrandomgenre(Challenge[] chall){
        for(Challenge chall2: chall){
            if (chall2 != null){
                chall2.genre1 = rd.nextBoolean();
            }
        }
    }
    //Esto es solo de prueba
    public void getGenre(){
        String[] genre3 = {"fantasy", "horror", "adventure", "medieval"};
        int random = (int) ((Math.random()*genre3.length-0)+0);
        for(Challenge chall4: this.challdaily){
            if (chall4 != null){
                chall4.genre =genre3[random];
            }
        }
    }
    
}


