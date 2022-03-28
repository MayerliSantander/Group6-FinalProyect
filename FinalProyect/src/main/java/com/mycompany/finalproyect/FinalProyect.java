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
        Cinema cinema = new Cinema();
        Scanner menu = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        boolean programa = true, sesion;
        int elegir_opcion;
        //crear un usuario vacio
        User usuario = new User(" "," "," "," "," ");
        //Definir el OUTER para poder romper el ciclo de todo el programa, esta definido en el switch "case 3"
        OUTER:
        while (programa) {
                System.out.println("\n***********************************"
                        + "\n*****BIENVENIDO AL CINE CENTER*****"
                        + "\n***********************************"
                        + "\n* 1. Iniciar Sesión               *"
                        + "\n* 2. Registrar Usuario            *"
                        + "\n* 3. Salir                        *"
                        + "\n***********************************");
                //Moverse por el Menu
                Default.setDefault();
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
                                if ("ADMINISTRADOR".equals(usuario.getUser())){
                                    var administrator = new Administrator(cinema);
                                    administrator.showAdministratorOptions();
                                }
                                else{
                                    var customer = new Customer(cinema, usuario);
                                    Default.setUserDefault();
                                    customer.showCustomerOptions();
                                }
                            }
                            else{
                                System.out.println("\nEl correo o la contraseña con incorrectas");
                            }
                        }   
                        break;
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
                        //Romper ciclo Inicio/Registrarse
                    default:
                        //Repetir ciclo
                        System.out.println("\nIngrese una opción valida");
                        break;
                }
            //}
        }
     
    }
    
}
