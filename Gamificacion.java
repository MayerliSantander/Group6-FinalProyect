/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;

public class Gamificacion{
    String dailygenre, challenge;
    static Scanner sn = new Scanner(System.in);
    static boolean modify;
    static int dailyrew;
    static int dailytcks;
    static int dailyinfo;
    static Trophies[] trophies;
    static Trophies[] defaultrophies;
    static boolean reset;
    static int points;
    static int count;
    boolean z = false;
    static Awards[] awards;
    static Challenge[] challtotal;
    static Challenge[] challdaily;
    static Challenge[] challweek;
    public Gamificacion() {
        this.dailyrew = User.dailyreviews;
        this.dailytcks = User.dailyentradas;
        this.dailyinfo = User.dailyinfos;
        this.awards = User.awrds;
        this.trophies = User.thphs;
        this.challtotal = User.chllg;
        setChall();
    }
    public void showGamificacion(){
        while(!z){
            curret();
            System.out.println("***********************************");
            System.out.println("Puntos: "+this.points);
            System.out.println("***********************************"
                                +"\n* Seleccione una opcion           *"
                                +"\n***********************************"
                                +"\n* 1. Retos                        *"
                                +"\n* 2. Trofeos                      *"
                                +"\n* 3. Canjeo de Premios            *"
                                +"\n* 4. Volver                       *"
                                +"\n***********************************");
            int opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    ShowChallenge();
                    break;
                case 2:
                    Trophies.showTrophies(this.trophies);
                    break;
                case 3:
                    Awards.showAwards(this.awards);
                    break;
                case 4:
                    z = true;
                    setGam();
                    break;
                default:
                    System.out.println("Elige una opcion");
                    break;
            }
        }
    }
    public static void getPoints(int pts){
        Gamificacion.points = pts;
    }
    public static void setChall(){
        Challenge[] chall = challtotal;
        Challenge[] chall2 = {chall[0],challtotal[1],challtotal[3]};
        Challenge[] chall3 = {chall[3],challtotal[4],challtotal[5]};
        challdaily = chall2;
        challweek = chall3;
    }
    public void ShowChallenge(){
        System.out.println("***********************************************************");
        System.out.println("Retos diarios:");
        System.out.println("***********************************************************");
        Challenge.printChallenge(this.challdaily);
        System.out.println("***********************************************************");
        System.out.println("Retos semanales:");
        System.out.println("***********************************************************");
        Challenge.printChallenge(this.challweek);
        System.out.println("***********************************************************");
    }
    public static void modifyAwards(){
        int index = sn.nextInt();
        if (index <= count && index >= 0){
            String premio = sn.nextLine();
            int price = sn.nextInt();
            awards[index].award = premio;
            awards[index].cost = price;
            modify = true;
        }
        else{
            System.out.println("Premio no encontrado");
        }
    }
    public static void resetAwards(){
        for(Awards aw: awards){
            if(aw != null){
                aw.exchange = false;
            }
        }
        reset = false;
    }
    public void setGam(){
        User.awrds = awards;
        User.chllg = challtotal;
        User.thphs = trophies;
    }
    public static void modifyGamificacion(){
        boolean a = false;
        while(!a){
            System.out.println("*********************************");
            System.out.println("*1. Modificar Retos:            *");
            System.out.println("*2. Modificar Trofeos:          *");
            System.out.println("*3. Modificar Premios:          *");
            System.out.println("*4. Incluir Trofeos             *");
            System.out.println("*5. Incluir Premios             *");
            System.out.println("*7. Reiniciar los premios       *");
            System.out.println("*8. Cambio diario               *");
            System.out.println("*9. Cambio semanal              *");
            System.out.println("*9. Volver                      *");
            System.out.println("*********************************");
            int opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    modifyChallenge();
                    break;
                case 2:
                    modifyTrophies();
                    break;
                case 3:
                    modifyAwards();
                    break;
                case 4:
                    Trophies.addTrophies();
                    break;
                case 5:
                    Awards.addAwards();
                    break;
                case 6:
                    reset = true;
                    System.out.println("***************************");
                    System.out.println("*Premios reiniciados      *");
                    System.out.println("***************************");
                    break;
                case 7:
                    Default.daily = true;
                    Default.dailychange();
                    System.out.println("***************************");
                    System.out.println("*Se cambio el dia         *");
                    System.out.println("***************************");
                    break;
                case 8:
                    Default.week = true;
                    Default.weekchange();
                    System.out.println("***************************");
                    System.out.println("*Se cambio la semana      *");
                    System.out.println("***************************");
                    break;
                case 9:
                    a = true;
                    break;
                default:
                    System.out.println("Elige una opcion");
                    break;
            }
        }
        a =false;
    }
    public static void modifyChallenge(){
        int challenge1 = sn.nextInt();
        Challenge[] chall = challtotal;
        if(challenge1 < 4 && challenge1 >= 0){
            System.out.println("***********************************************************************************************");
            System.out.println("Estructura del reto: [accion] [requisito] [objetivo]: [progreso]/[requisito]  [puntos:[puntos]]");
            System.out.println("***********************************************************************************************");
            System.out.println("*Modificar accion:             *");
            System.out.println("********************************");
            chall[challenge1].action = sn.nextLine();
            System.out.println("********************************");
            System.out.println("*Modificar objetivo:           *");
            System.out.println("********************************");
            chall[challenge1].goal = sn.nextLine();
            System.out.println("********************************");
            System.out.println("*Modificar requisito:          *");
            System.out.println("********************************");
            chall[challenge1].target = sn.nextInt();
            System.out.println("********************************");
            System.out.println("*Modificar puntos:             *");
            System.out.println("********************************");
            chall[challenge1].points = sn.nextInt();
            System.out.println("********************************");
            System.out.println("*Resultado de la modificacion: *");
            System.out.println("*************************************************************************************************************************");
            System.out.println(chall[challenge1].action+ " " + chall[challenge1].target + " " + chall[challenge1].goal+" : [progreso]/" + chall[challenge1].target+ " [Puntos : "+chall[challenge1].points+"]");
            System.out.println("*************************************************************************************************************************");
        }
        else if (challenge1 < 7 && challenge1 >= 4){
            System.out.println("***********************************************************************************************");
            System.out.println("Estructura del reto: [accion] [requisito] [objetivo]: [progreso]/[requisito] [puntos:[puntos]]:");
            System.out.println("***********************************************************************************************");
            System.out.println("*Modificar puntos:             *");
            System.out.println("********************************");
            chall[challenge1].points = sn.nextInt();
            System.out.println("*************************************************************************************************************************");
            System.out.println(chall[challenge1].action+ " " + chall[challenge1].target + " " + chall[challenge1].goal+" : [progreso]/" + chall[challenge1].target+ " [Puntos : "+chall[challenge1].points+"]");
            System.out.println("*************************************************************************************************************************");
        }
        else{
            System.out.println("Elije una opcion");
        }
    }
    
    public void curret(){
        for(Challenge chall: this.challdaily){
            switch(chall.type){
                case 1:
                    chall.current = User.dailyreviews;
                case 2:
                    chall.current = User.dailyentradas;
                case 3:
                    chall.current = User.dailyinfos;
            }
        }
        for(Challenge chall: this.challweek){
            switch(chall.type){
                case 4:
                    chall.current = this.challdaily[0].weekcount;
                case 5:
                    chall.current = this.challdaily[1].weekcount;
                case 6:
                    chall.current = this.challdaily[2].weekcount;
            }
        }
        for(Trophies trophie5: this.trophies){
            if(trophie5 != null){
                switch(trophie5.type){
                    case 1:
                        trophie5.current = User.getReviews();
                    case 2:
                        trophie5.current = User.getEntradas();
                    case 3:
                        trophie5.current = User.getInfos();
                }
            }
        }
        
    }
    public static void updateTrophies(){
        for(int i= 0; Trophies.getLength(Default.trophie)>=i; i++){
            if(Default.trophie[i].modify == true || trophies[i] == null){
                Default.trophie[i].modify = false;
                trophies[i] = Default.trophie[i];
            }
        }
    }
    public static void updateAwards(){
        for(int i= 0; Awards.getLength(Default.award)>=i; i++){
            if(Default.award[i].modify == true || awards[i] == null){
                Default.trophie[i].modify = false;
                awards[i] = Default.award[i];
            }
        }
    }
    public static void modifyTrophies() {
        int index = sn.nextInt();
        Trophies[] trop = Default.trophie;
        if(index < Trophies.getLength(trop) && index >= 0){
            System.out.println("********************************************************************************");
            System.out.println("Estructura del trofeo: [accion] : [progreso]/[requisito]  [puntos:[puntos]]");
            System.out.println("********************************************************************************");
            System.out.println("Modificar accion:");
            trop[index].action = sn.nextLine();
            System.out.println("Modificar requisito:");
            trop[index].target = sn.nextInt();
            System.out.println("Modificar puntos:");
            trop[index].points = sn.nextInt();
            System.out.println("Resultado de la modificacion :");
            System.out.println("***********************************************************************************************");
            System.out.println(trop[index].action+" : [progreso]/" + trop[index].target+ " [Puntos : "+trop[index].points+"]");
            System.out.println("***********************************************************************************************");
            trop[index].modify = true;
        }
        else{
            System.out.println("Trofeo no encontrado");
        }
        Default.trophie = trop;
    }
}


