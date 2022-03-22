/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;;
import java.util.Scanner;

public class Challenge {
    static Scanner sn = new Scanner(System.in);
    boolean complete,genre1, claim;
    int target, weekcount, current, points;
    String goal,genre, action;
    public Challenge(String action, String goal, int target,int current, int points){
        this.action = action;
        this.goal = goal;
        this.complete = false;
        this.claim = false;
        this.target = target;
        this.genre = "";
        this.genre1 = false;
        this.weekcount = 0;
        this.current = current;
        this.points = points;
    }
    
    public static void CompleteChallenge(Challenge[] chall){
        for(Challenge chall2: chall){
            if(chall2.target <= chall2.current){
                chall2.complete = true;
                chall2.weekcount ++;
            }
        }
    }
    public static int getPoints(Challenge[] chall, int points){
        for(Challenge chall2: chall){
            if (chall2.claim == false && chall2.complete == true){
                    chall2.claim = true;
                    points = points+chall2.points;
            }
        }
        return points;
    }
    public static void printChallenge(Challenge[] chall){
        for(Challenge chall2: chall){
            if(chall2.complete == false){
                if(chall2.genre1 == false){
                    System.out.println(chall2.action+ " " + chall2.target + " " + chall2.goal +" : "+ chall2.current+"/" + chall2.target+ " [Puntos : "+chall2.points+"]");
                }
                else{
                    System.out.println(chall2.action+ " " + chall2.target + " " + chall2.goal +" del genero "+chall2.genre+" : "+ chall2.current+"/" + chall2.target+ " [Puntos : "+chall2.points+"]");
                }
           }
            else{
                if(chall2.genre1 == false){
                    System.out.println(chall2.action+ " " + chall2.target + " " + chall2.goal +" : "+ chall2.current+"/" + chall2.target+" [Puntos: "+chall2.points+"] (COMPLETADO)");
                }
                else{
                    System.out.println(chall2.action+ " " + chall2.target + " " + chall2.goal +" del genero "+chall2.genre+" : "+ chall2.current+"/" + chall2.target+ " [Puntos: "+chall2.points+"] (COMPLETADO)");
                }
            }
        }
    }
    
    public static void modifyChallenge(Challenge[] chall, int challenge) {
        
        if(challenge < 4){
            System.out.println("Estructura del reto: [accion] [requisito] [objetivo] ( del genero [genero] ): [progreso]/[requisito]  [puntos:[puntos]]");
            System.out.println("Modificar accion:");
            chall[challenge].action = sn.nextLine();
            System.out.println("Modificar objetivo:");
            chall[challenge].goal = sn.nextLine();
            System.out.println("Modificar requisito:");
            chall[challenge].target = sn.nextInt();
            System.out.println("Modificar puntos:");
            chall[challenge].points = sn.nextInt();
            System.out.println("Relacionar un genero al reto:");
            boolean genre2 = sn.nextBoolean();
            chall[challenge].genre1 = genre2;
            if(genre2 == true){
                System.out.println("Designar un genero:");
                chall[challenge].genre = sn.next();
                System.out.println(chall[challenge].action+ " " +chall[challenge].target + " " + chall[challenge].goal +" del genero "+chall[challenge].genre+" : "+ chall[challenge].current+"/" + chall[challenge].target+ " [Puntos : "+chall[challenge].points+"]");
            }
            else{
                System.out.println("Resultado de la modificacion");
                System.out.println(chall[challenge].action+ " " + chall[challenge].target + " " + chall[challenge].goal+" : "+ chall[challenge].current+"/" + chall[challenge].target+ " [Puntos : "+chall[challenge].points+"]");
            }
        }
        else{
            System.out.println("Estructura del reto: [accion] [requisito] [objetivo]: [progreso]/[requisito] [puntos:[puntos]]:");
            System.out.println("Modificar puntos:");
                chall[challenge].points = sn.nextInt();
        }
    }
        
}
