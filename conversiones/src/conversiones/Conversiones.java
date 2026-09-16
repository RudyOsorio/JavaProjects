/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversiones;
import java.util.Scanner;

/**
 *
 * @author UserCP
 */
public class Conversiones {
    /*
      Desarrollar un algoritmo que permita convertir valores de longitud
      de acuerdo a la base que tenga.
      pulgadas - centimetros
      kilometros - millas
      Grados celsius a grados farenheit
    */
    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        
        /* declaramos variables */
        int pulgada = 0;
        double resultadoCM = 0;
        double kilometros = 100;
        double millas = 0;
        
        System.out.println("Tenemos 5 pulgadas");
        System.out.println("Cuanto es en centimetros?");
        
        pulgada = 5;
        
        resultadoCM = pulgada * 2.54;
        System.out.printf("%d pulgadas es equivalente a %.2f cm",pulgada,resultadoCM);
        System.out.println("");
        
        pulgada = 12;
        
        resultadoCM = pulgada * 2.54;
        System.out.printf("\n%.2f cm es equivalente a %d pulgadas",resultadoCM,pulgada);
        System.out.println("");
        
        System.out.println("\n Dime cuantos kilometros son?");
        
        kilometros = teclado.nextDouble ();
        millas = kilometros / 1.6;
        
        System.out.printf("%.2f km es igual a %.3f millas",kilometros,millas);
        System.out.println("");
        
        // °F = (°C × 1.8) + 32
    }
    
}
