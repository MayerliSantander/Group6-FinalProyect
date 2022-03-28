/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.Scanner;

public class Gamificacion{
    String dailygenre, challenge;
    static Scanner sn = new Scanner(System.in);
    static Scanner sn1 = new Scanner(System.in);
    static Scanner sn2 = new Scanner(System.in);
    static int dailyrew;
    static int dailytcks;
    static int dailyinfo;
    static boolean daily = false,week = false;
    static Trophies[] trophies;
    static Trophies[] defaultrophies;
    static boolean reset = false;
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
        updateTrophies();
        updateAwards();
        updateChallenge();
        Gamificacion.dailychange();
        while(!z){
            if(reset ==true){
                resetAwards();
                reset = false;
            }
            curret();
            System.out.println("***********************************");
            System.out.println("Puntos: "+User.points);
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
        z=false;
    }
    public static void getPoints(int pts){
        User.points = pts;
    }
    public static void setChall(){
        Challenge[] chall = challtotal;
        Challenge[] chall2 = {chall[0],challtotal[1],challtotal[2]};
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
        int y = 0;
        System.out.println("Elige el premio:");
        for(Awards aw: Default.award){
            if(aw != null){
                System.out.println(y+". "+aw.award+": "+aw.cost+" puntos");
                y++;
            }
        }
        int index = sn.nextInt();
        if (index < Awards.getLength(Default.award) && index >= 0){
            System.out.println("Modifica el premio ganado:");
            String premio = sn2.nextLine();
            System.out.println("Modifica el precio:");
            int price = sn1.nextInt();
            Default.award[index].award = premio;
            Default.award[index].cost = price;
            Default.award[index].modify = true;
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
            System.out.println("*6. Reiniciar los premios       *");
            System.out.println("*7. Cambio diario               *");
            System.out.println("*8. Volver                      *");
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
                    System.out.println("***************************");
                    System.out.println("*Se cambio el dia         *");
                    System.out.println("***************************");
                    break;
                case 8:
                    a = true;
                    break;
                default:
                    System.out.println("Elige una opcion");
                    break;
            }
        }
        a =false;
    }
    public static void dailychange(){
        if(Gamificacion.daily == true){
            Gamificacion.daily = false;
            User.dailyentradas = 0;
            User.dailyinfos = 0;
            User.dailyreviews = 0;
            if(Gamificacion.week == true){
                Gamificacion.week = false;
                User.chllg[0].weekcount = 0;
                User.chllg[1].weekcount = 0;
                User.chllg[2].weekcount = 0;
            }
        }
    }
    public static void modifyChallenge(){
        Challenge[] chall = Default.challenge;
        System.out.println("Seleccione un reto");
        int a = 0;
        for(Challenge chall6:chall){
            System.out.println(a+". "+chall6.action+ " " + chall6.target + " " + chall6.goal+" : [progreso]/" + chall6.target+ " [Puntos : "+chall6.points+"]");
            a++;
        }
        int challenge1 = sn.nextInt();
        if(challenge1 < 3 && challenge1 >= 0){
            System.out.println(chall[challenge1].action+ " " + chall[challenge1].target + " " + chall[challenge1].goal+" : [progreso]/" + chall[challenge1].target+ " [Puntos : "+chall[challenge1].points+"]");
            System.out.println("***********************************************************************************************");
            System.out.println("Estructura del reto: [accion] [requisito] [objetivo]: [progreso]/[requisito]  [puntos:[puntos]]");
            System.out.println("***********************************************************************************************");
            System.out.println("*Modificar requisito:          *");
            System.out.println("********************************");
            chall[challenge1].target = sn.nextInt();
            System.out.println("********************************");
            System.out.println("*Modificar puntos:             *");
            System.out.println("********************************");
            chall[challenge1].points = sn1.nextInt();
            System.out.println("********************************");
            System.out.println("*Resultado de la modificacion: *");
            System.out.println("*************************************************************************************************************************");
            System.out.println(chall[challenge1].action+ " " + chall[challenge1].target + " " + chall[challenge1].goal+" : [progreso]/" + chall[challenge1].target+ " [Puntos : "+chall[challenge1].points+"]");
            System.out.println("*************************************************************************************************************************");
            chall[challenge1].modify = true;
        }
        else if (challenge1 < 6 && challenge1 >= 3){
            System.out.println("***********************************************************************************************");
            System.out.println("Estructura del reto: [accion] [requisito] [objetivo]: [progreso]/[requisito] [puntos:[puntos]]:");
            System.out.println("***********************************************************************************************");
            System.out.println("*Modificar puntos:             *");
            System.out.println("********************************");
            chall[challenge1].points = sn.nextInt();
            System.out.println("*************************************************************************************************************************");
            System.out.println(chall[challenge1].action+ " " + chall[challenge1].target + " " + chall[challenge1].goal+" : [progreso]/" + chall[challenge1].target+ " [Puntos : "+chall[challenge1].points+"]");
            System.out.println("*************************************************************************************************************************");
            chall[challenge1].modify = true;
        }
        else{
            System.out.println("Reto no encontrado");
        }
    }
    
    public void curret(){
        Challenge[] chall7 = this.challdaily;
        for(Challenge chall: chall7){
            if(chall.type == 1){
                chall.current = User.dailyreviews;
            }
            else if(chall.type == 2){
                chall.current = User.dailyentradas;
            }
            else if(chall.type == 3){
                    chall.current = User.dailyinfos;
            }
        }
        this.challdaily =chall7;
        Challenge[] chall8 = Gamificacion.challweek;
        for(Challenge chall: chall8){
            if(chall.type == 1){
                chall.current = Gamificacion.challdaily[0].weekcount;
            }
            else if(chall.type == 2){
                chall.current = Gamificacion.challdaily[1].weekcount;
            }
            else if(chall.type == 3){
                chall.current = Gamificacion.challdaily[2].weekcount;
            }
        }
        this.challweek =chall8;
        Trophies[] trophie4 = this.trophies;
        for(Trophies trophie5: trophie4){
            if(trophie5 != null){
                if(trophie5.type == 1){
                        trophie5.current = User.getReviews();
                }
                else if(trophie5.type == 2){
                        trophie5.current = User.getEntradas();
                }
                else if(trophie5.type == 3){
                        trophie5.current = User.getInfos();
                }
            }
        }
        this.trophies = trophie4;
        Trophies.CompleteTrophies(Gamificacion.trophies, User.points);
        Challenge.CompleteChallenge(Gamificacion.challtotal, User.points);
    }
    public static void updateTrophies(){
        for(int i= 0; Trophies.getLength(Default.trophie)>i;){
            if(Default.trophie[i].modify == true || trophies[i] == null){
                Default.trophie[i].modify = false;
                trophies[i]  = Default.trophie[i];
            }
            i++;
        }
    }
    public static void updateChallenge(){
        for(int i= 0; 6>i;){
            if(Default.challenge[i].modify == true){
                Default.challenge[i].modify = false;
                challtotal[i].target = Default.challenge[i].target;
                challtotal[i].points = Default.challenge[i].points;
            }
            i++;
        }
    }
    public static void updateAwards(){
        for(int j= 0; Awards.getLength(Default.award)>j; ){
            if(Default.award[j].modify == true || awards[j] == null){
                Default.award[j].modify = false;
                awards[j] = Default.award[j];
            }
            j++;
        }
    }
    public static void modifyTrophies() {
        Trophies[] trop = Default.trophie;
        System.out.println("Seleccione un trofeo");
        int a = 0;
        for(Trophies trop6:trop){
            if(trop6 != null){
                System.out.println(a+". "+trop6.action+" : [progreso]/" + trop6.target+ " [Puntos : "+trop6.points+"]");
                a++;
            }
        }
        int index = sn.nextInt();
        if(index < Trophies.getLength(trop) && index >= 0){
            System.out.println("********************************************************************************");
            System.out.println("Estructura del trofeo: [accion] : [progreso]/[requisito]  [puntos:[puntos]]");
            System.out.println("********************************************************************************");
            System.out.println("Modificar requisito:");
            trop[index].target = sn.nextInt();
            System.out.println("Modificar puntos:");
            trop[index].points = sn1.nextInt();
            System.out.println("Resultado de la modificacion:");
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


