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
 * @author fundacion
 */
public class User {
    private String name;
    private String lastname;
    //? private String avatar;
    private String user;
    private String emailadress;
    private String contraseña;
    private String[][] lista_usuarios = new String[100][5];
    private final boolean[] correo_correcto = new boolean[1];

    public User(String name, String lastname, String user, String emailadress, String contraseña) {
        this.name = name;
        this.lastname = lastname;
        this.user = user;
        this.emailadress = emailadress;
        this.contraseña = contraseña;
        //Usuario Administrador
        lista_usuarios[0][0] = "YkdRyN#dTStB3jzULDmD@6Oqqw4wYp";
        lista_usuarios[0][1] = "447982761810495398113920963649";    
    }

    public String getEmailadress() {
        //Conseguir correo
        return emailadress;
    }

    public String getUser() {
        //Conseguir usuario
        return user;
    }
    

    public boolean registrarUsuario(String name2, String lastname2, String user2, String emailadress2, String contraseña2){
        name = name2;
        lastname = lastname2;
        user = user2;
        emailadress = emailadress2;
        contraseña = contraseña2;
        //verificar validez del correo ingresado
        ArrayList<String> email = new ArrayList<String>();  
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
            if (correo_correcto[0] == true){
               for(int i = 0;i<lista_usuarios.length;i++){
                   if (lista_usuarios[i][0] == null || lista_usuarios[i][0] == " "){
                       //Guardar el usuario creado
                       lista_usuarios[i][0] = emailadress;
                       lista_usuarios[i][1] = contraseña;
                       lista_usuarios[i][2] = name;
                       lista_usuarios[i][3] = lastname;
                       lista_usuarios[i][4] = user;
                       //Sustituir los valores para seguir usando el ciclo del main
                       name = " ";
                       lastname = " ";
                       emailadress = " ";
                       contraseña = " ";
                       user = " ";
                   }
               } 
            }
        }
        return correo_correcto[0];  
    }
    
    public boolean iniciarSesion(String emailadress, String password){
        boolean[] sesion = new boolean[2];
        for(int l = 0; l<lista_usuarios.length;l++){
            if(lista_usuarios[l][0].equals(emailadress) && lista_usuarios[l][1].equals(password)){
                //Comprobar usuario administrador
                if("YkdRyN#dTStB3jzULDmD@6Oqqw4wYp".equals(lista_usuarios[l][0]) && "447982761810495398113920963649".equals(lista_usuarios[l][1])){
                    sesion[0] = true;
                    sesion[1] = true;
                    user = "ADMINISTRADOR";
                    break;
                }
                //Usuario Estandar
                else{
                    sesion[0] = true;
                    sesion[1] = false;
                    user = lista_usuarios[l][4];
                    break;
                }
            }
            //Error al iniciar sesion
            else if(lista_usuarios[l][0].equals(emailadress) || lista_usuarios[l][1].equals(password)){
                sesion[0] = false;
            }
        }
        return sesion[0];
    }
}

