package com.mycompany.finalproyect;

import java.util.Scanner;

public class tickets {
    public int op1=0;
    int ntickets= 0;
    int money = 0;
    int do2 = 0;


    public void tickets(){
    }
    Scanner reader = new Scanner(System.in);
    public int NticketsG;
    public void menu(){
        System.out.println("Ingrese el numero de entradas:");
        NticketsG = reader.nextInt();
        this.money = this.NticketsG * 30;
        System.out.println("Total a pagar es: "+ money);
        this.do2 = this.do2 + this.money;
        User.entradas = User.entradas + NticketsG;
        User.dailyentradas = User.dailyentradas + NticketsG;
        this.ntickets = this.NticketsG + this.ntickets;
        System.out.println("Gracias por la compra");
    }
}

