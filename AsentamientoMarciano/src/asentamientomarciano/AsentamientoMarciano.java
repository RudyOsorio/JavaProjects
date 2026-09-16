/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */
 
/* El año es 2045, Eres el Ingeniero en Jefe de Software de la colonia marciana
 * "Ares V". Una reciente tormenta de arena ha dañado los sistemas principales
 * y el comandante te ha encomendado escribir un programa de emergencia en Java 
 *  para estabilizar la base. 
 * 
 * Tu misión se divide en dos fases críticas que determinarán la supervivencia
 * de la tripulación.
 * 
 * Fase 1: El Sistema de Energía
 * Los paneles solares principales están funcionando de manera irregular. 
 * Tienes que analizar la energía generada durante los últimos 7 días.
 * 
 * Tu tarea:
 * Crea un arreglo unidimensional que almacene la energía generada (en Megavatios)
 * durante los últimos 7 días. 
 * 
 * El sistema debe calcular y mostrar en pantalla:
 *  El total de energía generada en la semana.
 *  El promedio diario de energía.
 *  El día en el que se generó la menor cantidad de energía, 
 *  para emitir una alerta de revisión de ese panel.
 * 
 *  Fase 2: El Invernadero Hidropónico
 * 
 * El suministro de comida depende del invernadero central, el 
 * cual está dividido en una cuadrícula (matriz) de 3x3 sectores. 
 * Los sensores han enviado las lecturas de humedad de cada sector, 
 * pero algunas tuberías se rompieron durante la tormenta.
 * 
 * Tu tarea:
 * Crear un arreglo bidimensional de 3x3 que represente los niveles de humedad 
 * (en porcentaje) de cada sector del invernadero. 

* El programa debe escanear toda la matriz y:
* Mostrar el mapa actual de humedad en formato de cuadrícula.
* Identificar qué sectores tienen un nivel de humedad crítico (menor al 50%) 
* y mostrar sus coordenadas para enviar a los drones de reparación automáticamente.*/

/* */
package asentamientomarciano;
import java.util.Scanner;

/* @author DELL */
public class AsentamientoMarciano {

    /* @param args the command line arguments */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        final int DIAS = 7;
        final int FILA = 3;
        final int COLUMNA = 3;
        int energiaTotal = 0;
        double promedioEnergiaSemanal = 0;
        int menosEnergia = 0;
        
        /**/
        int[] energiaAlmacenada = new int [DIAS];
        double[][] humedadSectorial = new double[FILA][COLUMNA];
        
        for(int i = 0; i < DIAS; i++){
            System.out.printf("Ingrese el valor energetico #%d\n",i+1);
            energiaAlmacenada[i] = ValidacionNumeroPositivo(scan);
        }
        
        energiaTotal = TotalEnergiaSemana(energiaAlmacenada);
        promedioEnergiaSemanal = CalcularPromedio(energiaTotal, DIAS);
        menosEnergia = DiaMasBajoEnergia(energiaAlmacenada);
        
        System.out.println("-------------------------------");
        System.out.println("----      Resultados       ----");
        System.out.println("-------------------------------");
        System.out.printf("Total Energia: %d\n",energiaTotal);
        System.out.printf("Promedio: %.2f\n",promedioEnergiaSemanal);
        System.out.printf("Dia con menos energia: %d\n",menosEnergia+1);
        System.out.printf("La cantidad de energia para el dia %d es: %d\n",menosEnergia+1,energiaAlmacenada[menosEnergia]);
        
        System.out.println("-------------------------------");
        System.out.println("FASE DOS");
        humedadSectorial = IngresoMedicionesSensorHumedad(scan, FILA, COLUMNA);
        MostrarMapaSectorial(humedadSectorial);
        System.out.println("");
        SectoresCriticos(humedadSectorial);
    }// fin main
    
    /* Arreglo unidimensional para 7 dias */
    public static int ValidacionNumeroPositivo(Scanner sc){
        int numeroTemp = 0;
        do{
            System.out.println("Ingrese el dato de la lectura echa");
            System.out.print("Lectura: ");
            numeroTemp = sc.nextInt();
            if(numeroTemp<0){
                System.out.println("Lectura erronea");
                System.out.println("No puede ser negativo");
                System.out.println("Ingresarlo nuevamente");
                System.out.println("\n");
            }
        }while(numeroTemp<0);
        return numeroTemp;
    }// fin de ValidacionNumeroPositivo
    
    public static int TotalEnergiaSemana(int[] arreglo){
        int energiaAcumulada = 0;
        for(int i =0; i < arreglo.length; i++){
            energiaAcumulada += arreglo[i];
        }
        return energiaAcumulada;
    }// fin de TotalEnergiaSemana
    
    public static double CalcularPromedio(int total, int dias){
        double promedio = 0;
        promedio = total / dias;
        return promedio;
    }// fin de CalcularPromedio
    
    public static int DiaMasBajoEnergia(int[] arreglo){
        int energiaTemp = arreglo[0];
        int indice = 0;
        for(int i = 1; i < arreglo.length; i++){
            if(energiaTemp > arreglo[i]){
                energiaTemp = arreglo[i];
                indice = i;
            }
        }
        return indice;
    }// fin de DiaMasBajoEnergia
    
    public static double[][] IngresoMedicionesSensorHumedad(Scanner sc, int fila, int columna){
        double[][] arregloTemp = new double[fila][columna];
        System.out.println("Ingresa los datos de cada sector");
        for(int i = 0; i < fila; i++){
            for (int j = 0; j < columna; j++){
                System.out.printf("Sector %d , %d: ",i+1,j+1);
                arregloTemp[i][j] = sc.nextDouble();
            }//fin ciclo for columna
        }//fin ciclo for fila
        return arregloTemp;
    }//fin de IngresoMedicionesSensorHumedad
    
    public static void MostrarMapaSectorial(double[][] arreglo){
        System.out.println("\n-------------------------");
        for(int i = 0; i < arreglo.length; i++){
            for (int j = 0; j < arreglo[i].length; j++){
                System.out.print(arreglo[i][j] + "\t");
            }//fin ciclo for columna
            System.out.println("\n-------------------------");
        }//fin ciclo for fila
    }//fin de MostrarMapaSectorial
    
    public static void SectoresCriticos(double[][] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            for (int j = 0; j < arreglo[i].length; j++){
                if(arreglo[i][j]<50){
                    System.out.printf("\nValor critico en sector: %d,%d\n",i,j);
                    System.out.printf("Registro: %.2f",arreglo[i][j]);
                    System.out.println("");
                    System.out.println("------------------------------");
                }// fin de if
            }//fin ciclo for columna
        }//fin ciclo for fila
    }// fin de SectoresCriticos
}// fin class
