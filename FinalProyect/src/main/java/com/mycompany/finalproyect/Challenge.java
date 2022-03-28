/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;
import java.util.Scanner;

public class Challenge {
    static Scanner sn = new Scanner(System.in);
    boolean complete, claim;
    int target, weekcount, current, type, points;
    String goal, action;
    boolean modify = false;
    public Challenge(String action, String goal, int target,int type, int points){
        this.action = action;
        this.goal = goal;
        this.complete = false;
        this.claim = false;
        this.target = target;
        this.weekcount = 0;
        this.type = type;
        this.points = points;
    }
    public static void CompleteChallenge(Challenge[] chall, int points){
        for(Challenge chall2: chall){
            if(chall2.target <= chall2.current){
                chall2.complete = true;
            }
            if (chall2.claim == false && chall2.complete == true){
                chall2.claim = true;
                points = points+chall2.points;
                chall2.weekcount ++;
            }
        }
        Gamificacion.getPoints(points);
    }
    public static void printChallenge(Challenge[] chall){
        for(Challenge chall2: chall){
            if(chall2.complete == false){
                System.out.println(chall2.action+ " " + chall2.target + " " + chall2.goal +" : "+ chall2.current+"/" + chall2.target+ " [Puntos : "+chall2.points+"]");
           }
            else{
                System.out.println(chall2.action+ " " + chall2.target + " " + chall2.goal +" : "+ chall2.current+"/" + chall2.target+" [Puntos: "+chall2.points+"] (COMPLETADO)");
            }
        }
    }
        
}
