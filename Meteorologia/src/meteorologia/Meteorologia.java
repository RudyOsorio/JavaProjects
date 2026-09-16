/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package meteorologia;
import java.util.Scanner;

/* @author UserCP */
/**
 * Estructuras de repeticion
 * 1. Conocer las diferentes estructuras de repeticion
 * 2. Analizar los componentes de todo ciclo de repeticion
 * 3. Construir un algoritmo o ciclo de repeticion
 */

public class Meteorologia {
    /**Desarrollar un algoritmo que permita simular una estacion
     * meteorologica, que va registrando las temperaturas a lo largo de una semana:
     * 1. Registrar el dia en general
     * 2. Registrar en dos jornadas (dia y noche)
     * 
     * Mostrar el promedio general y un mensaje de caliente o frio para cada jornada
     */
    /* @param args the command line arguments */
    /**Ciclos de repeticion
     * 1. While
     * 2. Do While
     * 3. For
     *
     * Componentes de los ciclos de repeticion:
     * 1. Valor de inicio                       -> Variable de control
     * 2. Condicion                             -> Establece el limite (superior, inferior, de igualdad)
     * 3. Modifique el estado de la condicion   -> Incrementa/Decrementa el valor de inicio
     * 
     * El ciclo de repeticion se ejecuta y repite siempre 
     * y cuando la condicion se mantenga VERDADERO.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        /* Declaramos variables */
        int temperatura = 0;
        int dia = 1; // Variable de control iniciando en cero
        int tempAcum = 0;
        double promedioTemp = 0;
        
        while(dia <= 7){ // En la condicional se usa 7 porque son siete dias de la semana
            // Instrucciones que se repiten
            System.out.print("Ingrese la temperatura es: ");
            temperatura = sc.nextInt();
            
            System.out.printf("Dia %d: \tTemperatura: %d\t tempAcum %d: ", dia, temperatura, tempAcum);
            //temperatura = sc.nextLine();
            
            tempAcum += temperatura;
            System.out.println("");
            //Modificacion
            //Opcion 1
            //dia +=1;
            //Opcion 2
            dia++; //Aumento de 1 en 1 -> POST Incremento
        }
        dia--;
        System.out.printf("Dia Final: %d", dia);
        promedioTemp = tempAcum / dia;
        
    }
    
}
