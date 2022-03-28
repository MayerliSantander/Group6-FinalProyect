/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;

public class Trophies{
    static Scanner sn = new Scanner(System.in);
    boolean complete, claim;
    boolean modify = false;
    int target, current, type, points;
    String action;
    public Trophies(String action, int target,int type, int points){
        this.action = action;
        this.complete = false;
        this.claim = false;
        this.target = target;
        this.type = type;
        this.points = points;
    }
    public static void CompleteTrophies(Trophies[] trophies, int points){
        for(Trophies trophies1: trophies){
            if(trophies1.target <= trophies1.current){
                trophies1.complete = true;
            }
            if (trophies1.claim == false && trophies1.complete == true && trophies != null){
                trophies1.claim = true;
                points = points+trophies1.points;
            }
        }
        Gamificacion.getPoints(points);
    }
    public static void addTrophies(){
        Trophies[] trophies = Default.trophie;
        int target = sn.nextInt();
        String action = sn.nextLine();
        int pnts = sn.nextInt();
        System.out.println("1. Hacer reviews");
        System.out.println("2. Reservar entradas");
        System.out.println("3. Leer infos");
        int type = sn.nextInt();
        switch(type){
            case 1:
                trophies[getLength(trophies)] = new Trophies(action, target, 1,pnts);
                break;
            case 2:
                trophies[getLength(trophies)] = new Trophies(action, target, 2,pnts);
                break;
            case 3:
                trophies[getLength(trophies)] = new Trophies(action, target, 3,pnts);
                break;
            default:
                System.out.println("Elige un tipo");
                break;
        }
    }
    public static void showTrophies(Trophies[] trophies){
        boolean x = false;
        while(!x){
            for(Trophies trop: trophies){
                if(trop != null){
                    if(trop.complete != true){
                        System.out.println(trop.action+" : "+trop.current+"/" + trop.target+ " [Puntos : "+trop.points+"]");
                    }
                    else{
                        System.out.println(trop.action+" : "+trop.current+"/" + trop.target+ " [Puntos : "+trop.points+"] (Completado)");
                    }
                }
            }
            System.out.println("**********************************");
            System.out.println("0. Volver");
            System.out.println("**********************************");
            int op =sn.nextInt();
            if(op == 0){
                x = true;
            }
            else{
                System.out.println("Selecione una opcion"); 
            }
        }
    }
    public static int getLength(Trophies[] trophies1){
        int count = 0;
        for(Trophies th: trophies1){
            if(th != null){
                count++;
            }
        }
        return count;
    }
}
