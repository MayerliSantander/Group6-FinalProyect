package com.mycompany.finalproyect;

import java.util.Scanner;

public class Review {
    private String comment;
    private int ranking;

    public Review(){
        setReview();
        setRanking();
    }

    private void setReview(){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Ingrese su comentario:");
        this.comment = scan1.nextLine();
    }
    private void setRanking() {
            System.out.println("Ingrese su calificacion del 1 al 5");
            Scanner scan2 = new Scanner(System.in);
            this.ranking = scan2.nextInt();
    }

    public String getComment(){
        return comment;
    }

    public int getRanking(){
        return ranking;
    }

}