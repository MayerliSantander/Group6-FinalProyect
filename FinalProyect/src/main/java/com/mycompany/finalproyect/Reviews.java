package com.mycompany.finalproyect;

import java.util.Scanner;

public class Reviews {
    private String comment;
    private int ranking;

    public Reviews(){
        setReview();
    }

    public void setReview(){
        Scanner scan = new Scanner(System.in);
        this.comment = scan.nextLine();
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