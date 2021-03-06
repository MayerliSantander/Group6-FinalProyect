/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproyect;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ignacio
 */
public class User {
    private String name;
    private String lastname;
    //? private String avatar;
    private String user;
    private String emailadress;
    private String contraseña;
    private ArrayList<String> email_list = new ArrayList<>();
    private ArrayList<String> password_list = new ArrayList<>();
    private ArrayList<String> user_list = new ArrayList<>();
    private ArrayList<String> name_list = new ArrayList<>();
    private ArrayList<String> lastname_list = new ArrayList<>();
    private final boolean[] correo_correcto = new boolean[2];
    
    public static int dailyreviews = 0;
    public static int dailyentradas = 0;
    public static int dailyinfos = 0;
    public static int entradas = 0;
    public static int infos = 0;
    public static int reviews = 0;
    public static int points = 0;
    public static boolean newuser = true;
    public static Awards[] awrds;
    public static Challenge[] chllg;
    public static Trophies[] thphs;
    public static ArrayList<String> awardsobtenied = new ArrayList<>();
    

    public User(String name, String lastname, String user, String emailadress, String contraseña) {
        this.name = name;
        this.lastname = lastname;
        this.user = user;
        this.emailadress = emailadress;
        this.contraseña = contraseña;
        //Usuario Administrador
        email_list.add("administrador4321@gmail.com");
        password_list.add("447982761810495398113920963649"); 
        user_list.add("ADMINISTRADOR");
        name_list.add(" ");
        lastname_list.add(" ");

        //usuario de prueba
        email_list.add("user@test");
        password_list.add("upt123"); 
        user_list.add("USERTEST");
        name_list.add("_");
        lastname_list.add("_");
    }

    public String getEmailadress() {
        //Conseguir correo
        return emailadress;
    }

    public String getUser() {
        //Conseguir usuario
        return user;
    }
    
    public static int getReviews() {
        return reviews;
    }

    public static int getEntradas() {
        return entradas;
    }

    public static int getInfos() {
        return infos;
    }

    public boolean registrarUsuario(String name2, String lastname2, String user2, String emailadress2, String contraseña2){
        name = name2;
        lastname = lastname2;
        user = user2;
        emailadress = emailadress2;
        contraseña = contraseña2;
        //verificar validez del correo ingresado
        ArrayList<String> email = new ArrayList<>();  
        //Correo a verificar  
        email.add(emailadress);    
        //Expresiones regularmente usadas en correos   
        String expresiones_regulares = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
        //Compilar las expresiones o simbolos regulares
        Pattern pattern = Pattern.compile(expresiones_regulares);  
        //Definir el array  
        for(String email1 : email){  
            //Crear una instancia matcher(verdadero/falso) para comprobar el correo   
            Matcher matcher = pattern.matcher(email1);
            correo_correcto[0] = matcher.matches();
            correo_correcto[1] = usuarioExistente(emailadress);
            if (correo_correcto[0] == true && correo_correcto[1] == false){
                //Guardar el usuario creado
                email_list.add(emailadress);
                password_list.add(contraseña);
                name_list.add(name);
                lastname_list.add(lastname);
                user_list.add(user);
            }
            else{
                correo_correcto[0] = false;
            }
        }
        return correo_correcto[0];  
    }
    public boolean usuarioExistente(String email_creado){
        boolean emailver = false;
        for(String verificar:email_list){
            if(verificar.contains(email_creado)){
                emailver = true;
            }
            else{
                emailver = false;
            }
        }
        return emailver;
    }
    
    public boolean iniciarSesion(String emailadress, String password){
        boolean[] sesion = new boolean[1];
        int count = 0, count2 = 0;
        for(String emailver:email_list){
            if(emailver != emailadress){
                count++;
            }
            if(emailver.equals(emailadress)){
                for(String passwordver:password_list){
                    if(passwordver.equals(password)){
                        //Verificar administrador
                        if(emailadress.equals("administrador4321@gmail.com") && password.equals("447982761810495398113920963649")){
                            sesion[0] = true;
                            user = "ADMINISTRADOR";
                            break;
                        }
                        //Verificar cliente
                        else if(emailver.equals(emailadress) && passwordver.equals(password)){
                            sesion[0] = true;
                            //Verificar el usuario del correo
                            for(String userver:user_list){
                                count2++;
                                if (count2 == count){
                                    user = userver;
                                    break;
                                }
                            }
                        }
                        //Correo incorrecto
                        else if(emailver.equals(emailadress) || passwordver.equals(password)){
                            sesion[0] = false;
                        }
                        
                    }
                }
            }
        }
        return sesion[0];
    }
}

