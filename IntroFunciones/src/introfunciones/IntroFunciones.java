/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template*/
package introfunciones;
import java.util.Scanner;
/* @author UserCP */
/*
Objetivos:
1. Definir el concepto de funciones.
2. Analizar la estructura de una funcion.
3. Implementar una funcion.

Caracteristicas
1. Reutilizable.
2. Modular.
3. Mantenimiento.

Estructura de una funcion
1. El alcance de una funcion/metodo
    a. public
    b. private
    c. protected

2. Tipo de dato de retorno
    a. int
    b. double
    c. String
    d. char
    e. boolean
    f. ArrayList
    g. void (Sin retorno)

3. Nombre de la funcion/metodo
4. Parametros de trabajo
    a. Ninguno
    b. Uno
    c. Dos
    d. Muchos
*/
public class IntroFunciones {
    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        int nota1 = 0;
        int nota2 = 0;
        int nota3 = 0;
        double promedio = 0;
        String estadoMateria = "John Doe";
        String nombreMateria = "John Doe";
        String nombreEstudiante = "John Doe";
        
        // 1ra. funcion
        //System.out.println("Boleta de Calificaciones");
        MensajeBienvenida(); // llamado de la primera funcion
        
        // 2da funcion
        System.out.print("Nombre Estudiante: ");
        //nombreEstudiante = scan.next();
        nombreEstudiante = CapitalizacionNombre(scan);
        
        System.out.print("\nNombre de la Materia: ");
        //nombreMateria = scan.next();
        nombreMateria = CapitalizacionNombre(scan);
        
        // 3ra funcion
        System.out.printf("Materia: %s\tNota1: ",nombreMateria);
        nota1 = scan.nextInt();
        System.out.printf("Materia: %s\tNota2: ",nombreMateria);
        nota2 = scan.nextInt();
        System.out.printf("Materia: %s\tNota3: ",nombreMateria);
        nota3 = scan.nextInt();
        
        promedio = (nota1+nota2+nota3)/3.0;
        
        if(promedio>=65){
            estadoMateria = "Aprobado";
        }else{
            estadoMateria = "Reprobado";
        }
        System.out.println();
        System.out.printf("Resultados de %s",nombreEstudiante);
        System.out.printf("\nMateria: %s",nombreMateria);
        System.out.printf("\nNota1: %d",nota1);
        System.out.printf("\nNota2: %d",nota2);
        System.out.printf("\nNota3: %d",nota3);
        System.out.printf("\nPromedio: %.2f",promedio);
        System.out.printf("\nEstado: %s",estadoMateria);
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
    }//Fin de Main
    
    // 1ra funcion
    public static void MensajeBienvenida(){
        System.out.println("Boleta de Calificaciones");
    }
    
    // 2da funcion
    public static String CapitalizacionNombre(Scanner sc){
        String nombreTratado = "John Doe";
        nombreTratado = sc.next().toUpperCase();
        return nombreTratado;
    }
    
    // 3ra funcion
    public static int ValidacionNota(int resultadoNota){
        int notaValida = resultadoNota;
        int LIM_INF = 0;
        int LIM_SUP = 100;
        Scanner input = new Scanner(System.in);
        do{
            if(notaValida<LIM_INF || notaValida>LIM_SUP){
                System.out.println("Nota No Valida");
                System.out.println("Tiene que estar entre 0 y 100");
                System.out.println("Ingrese nuevamente");
                notaValida = input.nextInt();
            }else{
                System.out.println("Nota Valida para el sistema");
            }
        }while(notaValida<LIM_INF || notaValida>LIM_SUP);
        return notaValida;
    }
}
