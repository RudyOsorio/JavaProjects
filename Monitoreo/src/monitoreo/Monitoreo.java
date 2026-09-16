/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */
package monitoreo;
import java.util.Random;
import java.util.Scanner;

/*
Desarrolla un programa en Java que simule la lectura de sensores de temperatura 
en un cuarto de servidores. El programa debe solicitar el nombre del operador
encargado y cuántas lecturas de sensores se van a simular. Debe validar que
la cantidad de lecturas sea mayor a 0 y menor o igual a 50. Por cada lectura, 
el sistema generará una temperatura aleatoria en grados Celsius. El programa 
debe convertir cada lectura a Fahrenheit, determinar si hay una alerta de 
sobrecalentamiento y, al final, mostrar un resumen estadístico.
*/

/** 1. Comprender el problema
 *      a. Que datos de entrada necesito?
 *      b. Transformaciones / Calculos necesarios
 *      c. Que resultados quiero? Que se va a mostrar?
 * 2. Disenar una posible solucion
 * 
 * 3. Traducir de manera incremental el desarrollo
 *      a. Listar las tareas.
 *          - Declaracion de variables
 *          - Tomas de desicion
 *          - Ciclos de repeticion
 *          - Formulas
 * 4. Pruebas de escritorio
 *      a. Casos
 *      b. Escenarios
 *      c. 
 * 5. Quality Assurance (Testeo)
 
 */

/* @author UserCP */
public class Monitoreo {

    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
        
        final String NOMBRE_SISTEMA = "LECTOR DE SENSORES DE TEMPERATURA";
        String operador = "Operador";
        int lecturas = 0;
        int temp = 0;
        int numMedicion = 0;
        int tempF = 0;
        
        int lecturaSensores = 0;
        final int TEMPERATURA_MIN = 0;
        final int TEMPERATURA_MAX = 50;
        
        System.out.println("=========================================");
        System.out.println("=== " + NOMBRE_SISTEMA + " ===");
        System.out.println("=========================================");
        
        System.out.println("Nombre del operador encargado: ");
        operador = input.nextLine();
        System.out.printf("Operador: %s",operador);
        System.out.println();
        System.out.println("---------------------------------------");
        
        //System.out.println("Numero de lecturas: ");
        //lecturas = input.nextInt();
        //System.out.println("---------------------------------------");
        
        //System.out.printf("Lecturas: %d", lecturas);
        //System.out.println();
        //System.out.println("---------------------------------------");
        
        //temp = rd.nextInt();
        //System.out.printf("Validacion: %d", temp);
        //System.out.println();
        
        do{
            System.out.print("Numero de Lecturas:");
            lecturas = input.nextInt();
            System.out.println("---------------------------------------");
            if(!(lecturas>0 || lecturas<=50)){
                System.out.println("Valor no valido!");
                System.out.println("Tiene que estar entre 0 y 50");
            }
        }while(!(lecturas>0 && lecturas<=50));
        
        System.out.println();
        while(numMedicion < lecturas){
            temp = rd.nextInt();
            System.out.printf("Numero de Medicion: %d \tTemp: %d",numMedicion+1, temp);
            System.out.println();
            
            tempF = (temp * 9/5)+32;
            System.out.printf("Temperatura en Farenheit: %d\n",tempF);
            System.out.println("-----------------------------------------");
            numMedicion++;
        }
    }
    
}
