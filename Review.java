package com.mycompany.finalproyect;

import java.util.Scanner;

public class Review {
    private String comment;
    private String username;
    private int ranking;

    public Review(User usuario){
        this.username = usuario.getUser();
        setReview();
        setRanking();
    }

    private void setReview(){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Ingrese su comentario:");
        this.comment = scan1.nextLine();
        User.dailyreviews++;
        User.reviews++;
    }
    private void setRanking() {
        boolean valid = false;
        while(!valid){
            System.out.println("Ingrese su calificacion del 1 al 5");
            Scanner scan2 = new Scanner(System.in);
            this.ranking = scan2.nextInt();
            if(ranking < 1 || ranking >5){
                valid = false;
                System.out.println("valor fuera del limite");
            }else{
                valid = true;
            }
        }
    }

    public String getComment(){
        return comment;
    }

    public int getRanking(){
        return ranking;
    }

    public String getUsername() {
        return username;
    }

}