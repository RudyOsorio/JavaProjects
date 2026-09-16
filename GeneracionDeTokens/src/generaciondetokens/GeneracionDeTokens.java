/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 * Objetivos
 * 1. Utilizar el ciclo de repeticion DO - WHILE
 * 2. Uso de nuevas librerias.
 *      a. Random
 * 3. Uso de otras funciones de String
 */
package generaciondetokens;
import java.util.Random;
import java.util.Scanner;

/* @author UserCP */
/**
 * Desarrollar un algoritmo que me permita registrar un dispositivo y generar un
 * token para su secion de validacion mientras se esta navegando con dicho
 * dispositivo.
 */

/* Desarrollar un algoritmo que me permita registrar 
     * un dispositivo y generar un token para su sesion
     * de validacion mientras se esta navegando con dicho dispositivo.
     * 
     * Contexto del problema:
       Un sistema de gestión de red necesita registrar 
      nuevos enrutadores (routers) y asignarles una clave 
        de sesión única generada aleatoriamente. 
        
       Sin embargo, el canal de comunicación tiene "ruido",
       por lo que la generación de la clave no siempre 
       es constante.
*/

/*
    Parte 1: Registro de Nombre de Equipo
    a. Longitud de 8 caracteres
    b. Comenzar con RT o SW
*/
public class GeneracionDeTokens {
    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here
        /* Declarando Variables */
        Random RD = new Random();
        String Werty = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del equipo: ");
        Werty = input.nextLine().toUpperCase();
        
        /* Declarando Variables */
        boolean longitudCorrecta = true;
        boolean prefijoCorrecto = true;
        boolean isValido = true;
        String token = "";
        int tipoCaracter = 0;
        
        //longitudCorrecta = Werty.length()==8;
        
        if(Werty.length()==8){
            longitudCorrecta = true;
        }else{
            longitudCorrecta = false;
        }
        
        prefijoCorrecto = (Werty.startsWith("RT")) || Werty.startsWith("SW");
        //System.out.println(longitudCorrecta);
        //System.out.println(prefijoCorrecto);
        
        isValido = longitudCorrecta && prefijoCorrecto;
        
        while(){
        
        }
        
        do{
           System.out.println("Ingrese el nombre del equipo: ");
           Werty = input.nextLine().toUpperCase();
           
        }while(!isValido);
        System.out.println("Registro correcto ");
        
        while(token.length()<12){
            tipoCaracter = RD.nextInt(2);
        }
    }

}
