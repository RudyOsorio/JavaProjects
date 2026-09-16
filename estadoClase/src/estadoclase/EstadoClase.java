/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estadoclase;

import java.util.Scanner;

/**
 *
 * @author UserCP
 */
public class EstadoClase {

    /**
     * @param args the command line arguments
     */
    
    /*
      1. Conocer la estructura de seleccion:
        a. Toma de desicion simple
        b. Toma de desicion doble
        c. Desiciones numericas y caracteres/cadenas
    */
    
    /* 
    Se necesita desarrollar un algoritmo que determina si un bote
    con agua de 500ml esta arriba de la mitad:
        a. Esta arriba de la mitad. (dato numerico)
        b. Contiene agua o no. (dato de caracter)
        c. Es amigable con el ambiente. (dato de cadena)
    */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        // Conociendo la estructura
        // Palabra clave "if" y/o "else"
        // El grupo de instrucciones se encierra entre llaves { }
        // No se usa ";" para los bloques
        /* La condicion es una comparacion bajo los siguientes elementos:
            a. menor que
            b. mayor que
            c. menor o igual que
            d. mayor o igual
            e. igual (uso de dos signos de igual)
            f. distinto (signos pegados)
        */
        
        int cantidadAgua = 0;
        char respuesta = '@';
        String respuestaAmbiente = "John Doe";
        
        System.out.println("El bote es de 500 ml");
        System.out.print("Cuanto liquido dices que contiene?");
        cantidadAgua = input.nextInt();
        
        if(cantidadAgua >= 250){
            System.out.println("Si, tiene mas de la mitad");
            System.out.println("Te lo puedes beber!!!");
            System.out.println("No nos quedamos sin nada... hay suficiente");
        }
        
        input.nextLine();
        System.out.println("");
        
        /**/
        System.out.print("El liquido que contiene es H2O? a=si, b=no");
        respuesta = input.nextLine().charAt(0);
        if(respuesta == 'a'){
            System.out.println("Si, es agua lo que contiene");
            System.out.println("No es otra cosa, nada embriagante!!!");
        }else{
            System.out.println("""
                               Uy uy uy...
                               Que sera?...
                               """);
        }
        
        System.out.println(" \n Ese bote que contiene ");
        respuestaAmbiente = input.nextLine();
        System.out.printf("Dato de variable: %s",respuestaAmbiente);
        
        System.out.println(" ...Seguro?");
        respuestaAmbiente = input.next().toUpperCase();
        System.out.printf("Dato de variable: %s",respuestaAmbiente);

        System.out.println(" ...100% seguro?");
        respuestaAmbiente = input.next().toLowerCase();
        System.out.printf("Dato de variable: %s",respuestaAmbiente);
        
        /**/
        if(respuestaAmbiente.equals("Si")){
            System.out.println("Es amigable");
        }else{
            System.out.println("No Es nada amigable");
        }
        /**/
    }// fin de main
}// fin de class
