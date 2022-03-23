package com.mycompany.finalproyect;

import java.util.Scanner;

public class Review {
    private String comment;
    private int ranking;

    public Review(){
        setReview();
    }

    public void setReview(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su comentario:");
        this.comment = scan.nextLine();
        setRanking();
        scan.close();
    }
    public void setRanking() {
            System.out.println("Ingrese su calificacion del 1 al 5");
            Scanner scan = new Scanner(System.in);
            this.ranking = scan.nextInt();
            scan.close();
    }

    public String getComment(){
        return comment;
    }

    public int getRanking(){
        return ranking;
    }

}