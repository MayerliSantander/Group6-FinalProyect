/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;
import java.util.ArrayList;

public class Awards {
    static int pts = User.points; 
    static Scanner sn = new Scanner(System.in);
    static Scanner sn1 = new Scanner(System.in);
    String award;
    int cost;
    boolean exchange;
    boolean modify = false;
    public Awards(String award, int cost){
            this.award = award;
            this.cost = cost;
            this.exchange = false;
        }
    public static void addAwards(){
        System.out.println("Designe el premio:");
        String award2 = sn.nextLine();
        System.out.println("Designe el precio:");
        int cost1 = sn1.nextInt();
        Default.award[getLength(Default.award)] = new Awards(award2,cost1);
        System.out.println("Premio incluido");
    }
    public static int getLength(Awards[] awards1){
        int count = 0;
        for(Awards th: awards1){
            if(th != null){
                count++;
            }
        }
        return count;
    }
    public static void buyAwards(Awards awards){
        boolean x = false;
        while(!x){
            System.out.println("***********************");
            System.out.println("*Canjear premio?      *");
            System.out.println("***********************");
            System.out.println("*1. Si                *");
            System.out.println("*2. No                *");
            System.out.println("***********************");
            int op2 = sn.nextInt();
            switch(op2){
                case 1:
                    if(awards.exchange == true){
                        System.out.println("***************************");
                        System.out.println("*Ya reclamaste este premio*");
                        System.out.println("***************************");
                    }
                    else if(awards.exchange == false && awards.cost <= User.points){
                        awards.exchange = true;
                        System.out.println("***********************************************");
                        System.out.println("Premio "+awards.award +" reclamado");
                        System.out.println("***********************************************");
                        User.awardsobtenied.add(awards.award);
                        x = true;
                    }
                    else{
                        System.out.println("Puntos insuficientes");
                    }
                    x = true;
                    break;
                case 2:
                    x = true;
                    break;
                default:
                    System.out.println("Selecione una opcion");
            }
        }
    }
    public static void showAwards(Awards[] awards2){
        boolean x = false;
        while(!x){
            int y = 1;
            System.out.println("***********************************************************");
            System.out.println("Seleccionar un premio:");
            System.out.println("***********************************************************");
            for(Awards aw: awards2){
                if(aw != null){
                    if(aw.exchange != true){
                        System.out.println(y+". "+aw.award+": "+aw.cost+" puntos");
                        y++;
                    }
                    else{
                        System.out.println(y+". "+aw.award+": Premio reclamado");
                        y++;
                    }
                }
            }
            System.out.println("***********************************************************");
            System.out.println("0. Volver");
            System.out.println("***********************************************************");
            int op =sn.nextInt();
            if(op <= getLength(awards2) && op > 0){
                buyAwards(awards2[op-1]);
            }
            else if (op == 0){
                x = true;
            }
            else{
                System.out.println("Selecione una opcion"); 
            }
        }
    }
}
