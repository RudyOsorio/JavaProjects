/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */
package introarreglos;
import java.util.Scanner;
/* @author UserCP */

/* Creamos la clase personas fuera del main */
class Persona{
    /* variables */
    private String nombre;
    private int edad;
    private char genero;
    private double peso;
    private double estatura;
    
    /* creamos nuestro constructor */
    public Persona(String nombre, int edad, char genero, double peso, double estatura){
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
    }
    
    /* creamos el metodo para mostrar los datos */
    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre + " | Edad: " + edad + " | Genero: " +genero+ " | Peso: " + peso + " | Estatura: " + estatura);
    }
}

/* Proyecto Introduccion a Arreglos */
public class IntroArreglos{
    
    /* @param args the command line arguments */
    public static void main(String[] args){
        /* Scanner */
        Scanner sc = new Scanner(System.in);
        
        /* Creamos el arreglo para cinco personas */
        Persona[] personas = new Persona[5];
        
        /* Capturamoms los datos */
        System.out.println("=== Registro de Personas ===");
        for(int i = 0; i < personas.length; i++){
            System.out.println("\n--- Persona " + (i + 1) + " ---");
            
            System.out.println(". 1.  Ingresa un nombre:         .");
            String nombre = sc.nextLine();
            System.out.println();
            
            System.out.println(". 2.  Ingresa la edad:           .");
            int edad = sc.nextInt();
            System.out.println();
            
            System.out.println(". 3.  Ingresa el genero (M - F): .");
            char genero = sc.next().charAt(0);
            System.out.println();
            
            System.out.println(". 4.  Ingresa el peso (Lb):      .");
            double peso = sc.nextDouble();
            System.out.println();
            
            System.out.println(". 5.  Ingresa la estatura (cm):  .");
            double estatura = sc.nextDouble();
            System.out.println();
            /* limpiamos buffer */
            sc.nextLine();
            
            personas[i] = new Persona(nombre, edad, genero, peso, estatura);
        }
        
        System.out.println();
        
        /* imprimimos lista */
        System.out.print("\n=== Lista de Personas Registradas ===\n");
        for(int i = 0; i < personas.length; i++){
            System.out.print((i + 1) + ". ");
            
            /* traemos el metodo que esta en la clase Persona */
            personas[i].mostrarInformacion();
        }
        System.out.println();
        
        /* cerramos el Scanner */
        sc.close();
    }
    
}
