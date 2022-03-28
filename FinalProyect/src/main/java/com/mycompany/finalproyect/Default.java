/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

public class Default {
    public static Challenge[] challenge;
    public static Trophies[] trophie;
    public static Awards[] award;
    static boolean daily = false, week = false;
    static boolean newdef = true;
    static int dailycount = 0;
    public static void dailychange(){
        if(Default.daily == true){
            Gamificacion.daily = true;
            Default.dailycount ++;
            Default.daily = false;
            if(dailycount == 7){
                Gamificacion.week = true;
                Default.dailycount = 0;
            }
        }
    }
    public static void setDefault(){
        if(Default.newdef == true){
            Default.newdef = false;
            Default.challenge = defaultChallenge();
            Default.trophie = defaultTrophies();
            Default.award = defaultAwards();
        }
    }
    
    public static void setUserDefault(){
        if(User.newuser == true){
            User.chllg = Default.challenge;
            User.thphs = Default.trophie;
            User.awrds = Default.award;
            User.newuser = false;
        }
    }
    public static Challenge[] defaultChallenge(){
        Challenge reto1 = new Challenge("Hacer","reviews", 5, 1,5);
        Challenge reto2 = new Challenge("Reservar","entradas", 5, 2,10);
        Challenge reto3 = new Challenge("Ver","infos", 5, 3, 1);
        Challenge reto4 = new Challenge("Cumplir los","retos de la fila 1",7, reto1.weekcount,3);
        Challenge reto5 = new Challenge("Cumplir los","retos de la fila 2",7, reto2.weekcount,5);
        Challenge reto6 = new Challenge("Cumplir los","retos de la fila 3",7, reto3.weekcount,2);
        Challenge[] chall = {reto1,reto2,reto3,reto4,reto5,reto6};
        return chall;
    }
    public static Trophies[] defaultTrophies(){
        Trophies[] trophies1 = new Trophies[100];
        trophies1[0] = new Trophies("Hacer 10 reviews", 10, 1, 5);
        trophies1[1] = new Trophies("Hacer 20 reviews", 20, 1, 5);
        trophies1[2] = new Trophies("Hacer 30 reviews", 30, 1, 5);
        trophies1[3] = new Trophies("Hacer 40 reviews", 40, 1, 5);
        trophies1[4] = new Trophies("Hacer 50 reviews", 50, 1, 10);
        trophies1[5] = new Trophies("Hacer 60 reviews", 60, 1, 10);
        trophies1[6] = new Trophies("Hacer 70 reviews", 70, 1, 10);
        trophies1[7] = new Trophies("Hacer 80 reviews", 80, 1, 10);
        trophies1[8] = new Trophies("Hacer 90 reviews", 90, 1, 10);
        trophies1[9] = new Trophies("Hacer 100 reviews", 100, 1, 20);
        trophies1[10] = new Trophies("Reservar 10 entradas", 10, 2, 5);
        trophies1[11] = new Trophies("Reservar 20 entradas", 20, 2, 5);
        trophies1[12] = new Trophies("Reservar 30 entradas", 30, 2, 5);
        trophies1[13] = new Trophies("Reservar 40 entradas", 40, 2, 5);
        trophies1[14] = new Trophies("Reservar 50 entradas", 50, 2, 10);
        trophies1[15] = new Trophies("Reservar 60 entradas", 60, 2, 10);
        trophies1[16] = new Trophies("Reservar 70 entradas", 70, 2, 10);
        trophies1[17] = new Trophies("Reservar 80 entradas", 80, 2, 10);
        trophies1[18] = new Trophies("Reservar 90 entradas", 90, 2, 10);
        trophies1[19] = new Trophies("Reservar 100 entradas", 100, 2, 20);
        trophies1[20] = new Trophies("Leer 10 infos", 10, 3, 5);
        trophies1[21] = new Trophies("Leer 20 infos", 20, 3, 5);
        trophies1[22] = new Trophies("Leer 30 infos", 30, 3, 5);
        trophies1[23] = new Trophies("Leer 40 infos", 40, 3, 5);
        trophies1[24] = new Trophies("Leer 50 infos", 50, 3, 10);
        trophies1[25] = new Trophies("Leer 60 infos", 60, 3, 10);
        trophies1[26] = new Trophies("Leer 70 infos", 70, 3, 10);
        trophies1[27] = new Trophies("Leer 80 infos", 80, 3, 10);
        trophies1[28] = new Trophies("Leer 90 infos", 90, 3, 10);
        trophies1[29] = new Trophies("Leer 100 infos", 100, 3, 20);
        return trophies1;
    }
    public static Awards[] defaultAwards(){
        Awards[] awards1 = new Awards[100];
        awards1[0] = new Awards("Refresco chico", 100);
        awards1[1] = new Awards("Palomitas de maiz chico", 200);
        awards1[2] = new Awards("Palomitas de mariz acarameladas chico", 200);
        awards1[3] = new Awards("Refresco mediano", 300);
        awards1[4] = new Awards("Palomitas de maiz mediano", 300);
        awards1[5] = new Awards("Palomitas de maiz acarameladas mediano", 300);
        awards1[6] = new Awards("Refresco grande", 400);
        awards1[7] = new Awards("Palomitas de maiz grande", 400);
        awards1[8] = new Awards("Palomitas de maiz acarameladas grande", 400);
        awards1[9] = new Awards("Entrada gratis", 2000);
        awards1[10] = new Awards("Entrada gratis a pelicula 3D", 2100);
        return awards1;
    }
}
