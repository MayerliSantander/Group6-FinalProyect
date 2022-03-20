/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.finalproyect;

import java.util.Scanner;

/**
 *
 * @author fundacion
 */
public class FinalProyect {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner menu = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        boolean programa = true, sesion = false;
        int elegir_opcion;
        //crear un usuario vacio
        User usuario = new User(" "," "," "," "," ");
        OUTER:
        while (programa) {
            if (" ".equals(usuario.getUser()) && " ".equals(usuario.getEmailadress())) {
                System.out.println("\n***********************************"
                        + "\n*****BIENVENIDO AL CINE CENTER*****"
                        + "\n***********************************"
                        + "\n* 1. Iniciar Sesión               *"
                        + "\n* 2. Registrar Usuario            *"
                        + "\n* 3. Salir                        *"
                        + "\n***********************************");
                //Moverse por el Menu
                elegir_opcion = menu.nextInt();
                switch (elegir_opcion) {
                    //Inicio de sesion
                    case 1:
                        sesion = false;
                        while (sesion == false){
                            //Proceso de inicio de sesion
                            System.out.println("\n**********************************\n* Ingrese su correo electronico: *\n**********************************");
                            String emailadress = datos.nextLine();
                            System.out.println("**************************\n* Ingrese su contraseña: *\n**************************");
                            String contraseña = datos.nextLine();
                            sesion = usuario.iniciarSesion(emailadress, contraseña);
                            if(sesion == true){
                                System.out.println("\nBienvenido " + usuario.getUser());
                                if (usuario.getUser() == "ADMINISTRADOR"){
                                    System.out.println("OPCIONES DE ADMINISTRADOR");
                                }
                                else{
                                    System.out.println("OPCIONES DE USUARIO ESTANDAR");
                                }
                            }
                            else{
                                System.out.println("\nEl correo o la contraseña con incorrectas");
                            }
                        }   break;
                        //Registrar usuario
                    case 2:
                        sesion = false;
                        while(sesion == false){
                            //Proceso de registro
                            System.out.println("\n**********************\n* Ingrese su nombre: *\n**********************");
                            String name = datos.nextLine();
                            System.out.println("************************\n* Ingrese su apellido: *\n************************");
                            String lastname = datos.nextLine();
                            System.out.println("*********************************\n* Ingrese su nombre de usuario: *\n*********************************");
                            String user = datos.nextLine();
                            System.out.println("**********************************\n* Ingrese su correo electronico: *\n**********************************");
                            String emailadress = datos.nextLine();
                            System.out.println("**************************\n* Ingrese su contraseña: *\n**************************");
                            String contraseña = datos.nextLine();
                            sesion = usuario.registrarUsuario(name, lastname, user, emailadress, contraseña);
                            //Verificar validez del registro
                            if(sesion == true){
                                System.out.println("**************************************\n* ¡Usuario registrado existosamente! *\n**************************************");
                            }
                            else if (sesion == false){
                                System.out.println("******************************\n* ¡Ingrese un correo valido! *\n******************************");
                            }
                        }
                        break;
                        //Salir
                    case 3:
                        break OUTER;
                        //Repetir ciclo
                    default:
                        System.out.println("\nIngrese una opción valida");
                        break;
                }
            }
        }
    }
}
