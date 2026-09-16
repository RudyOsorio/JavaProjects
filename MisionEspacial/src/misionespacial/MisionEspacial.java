/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package misionespacial;
import java.util.Random;
import java.util.Scanner;
//package libreriamath;

/*
    1. Entrada de datos: Solicitar al usuario que ingrese el nombre del piloto de la nave.

    2. Cuenta regresiva: Antes de iniciar la misión, el programa debe imprimir una cuenta 
        regresiva del 3 al 1 simulando el despegue.

    3. Cálculos matemáticos: La nave tiene un tanque de combustible inicial que se calcula 
        multiplicando la raíz cuadrada de 10000 (100) por 5 (usando los métodos de la clase Math).

    4. Menú de destinos (do-while y switch): Mostrar un menú cíclico para elegir el planeta destino. 
        El menú debe repetirse si el usuario ingresa una opción inválida.

        Opción 1: Marte (Distancia = 500)
        Opción 2: Júpiter (Distancia = 1200)
        Opción 3: Saturno (Distancia = 2000)

    5. Viaje espacial: Una vez en el espacio, la nave debe avanzar cíclicamente mientras la 
        distancia al planeta sea mayor a 0 y el combustible sea mayor a 0.

        * En cada iteración (turno) del viaje, la nave avanza 50 unidades de distancia por defecto.
        * En cada turno, se debe generar un "evento espacial" aleatorio usando la clase Random 
            (un número entre 1 y 2).

        * Si el evento es 1, la nave choca con un asteroide y pierde 50 unidades de combustible.
        * Si el evento es 2, la nave encuentra un viento solar a favor y la distancia se reduce 100 unidades extra.

    6. Resultados finales: Al finalizar el bucle del viaje, determinar si la misión fue un éxito 
        (la distancia llegó a 0 o menos) o un fracaso (se acabó el combustible antes de llegar).
    
*/

public class MisionEspacial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String piloto = "";
        double combustible = Math.sqrt(10000) * 5; // 100 * 5 = 500
        int opcion = 0;
        int distancia = 0;

        System.out.println("Ingrese el nombre del piloto:");
        piloto = sc.nextLine();

        System.out.println("Iniciando secuencia de despegue...");
        for (int i = 3; i >= 1; i--) {
            System.out.println(i);
        }

        // Selección de destino
        do {
            System.out.println("\nSeleccione destino:");
            System.out.println("1. Marte (Distancia = 500)");
            System.out.println("2. Jupiter (Distancia = 1200)");
            System.out.println("3. Saturno (Distancia = 2000)");
            
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        distancia = 500;
                        break;
                    case 2:
                        distancia = 1200;
                        break;
                    case 3:
                        distancia = 2000;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                sc.next();
            }
        } while (opcion < 1 || opcion > 3);

        // Bucle del viaje espacial
        while (distancia > 0 && combustible > 0) {
            System.out.println("\nDistancia restante: " + distancia + " | Combustible: " + combustible);
            
            // Avance por defecto en cada turno
            distancia -= 50;

            // Generar evento espacial (1 o 2)
            int evento = rand.nextInt(2) + 1;

            if (evento == 1) {
                System.out.println("- Impacto de asteroide! Pierdes 50 de combustible.");
                combustible -= 50;
            } else if (evento == 2) {
                System.out.println("- Viento solar a favor! Reduces 100 unidades extra de distancia.");
                distancia -= 100;
            }else{
                System.out.println("Camino que nunca se dara!!!");
            }
            combustible -= 100;
            distancia = distancia -50;
        }

        // Evaluación final
        System.out.println("\n--- RESULTADO DE LA MISION ---");
        if (distancia <= 0) {
            System.out.println("- Mision completada con exito, " + piloto + "! Has llegado a tu destino.");
        } else {
            System.out.println("- Mision fallida. Te quedaste sin combustible a " + distancia + " unidades del destino.");
        }

        sc.close();
    }
}