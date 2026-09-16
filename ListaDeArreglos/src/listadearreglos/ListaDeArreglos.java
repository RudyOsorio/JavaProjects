/*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */
package listadearreglos;
import java.util.ArrayList;

/* @author DELL */
public class ListaDeArreglos {

    /* @param args the command line arguments */
    public static void main(String[] args){
        /* array dinamicos */
        ArrayList<Integer> numeros = new ArrayList<Integer>(); // int
        ArrayList<Double> velocidad = new ArrayList<Double>(); // double
        ArrayList<Character> letras = new ArrayList<Character>(); // char
        ArrayList<String> nombres = new ArrayList<String>(); // String
        ArrayList<Boolean> estados = new ArrayList<Boolean>(); // boolean
        
        int dimension = 0;
        dimension = DimensionArrayList(numeros);
        System.out.printf("Dimension de ArrayList: %d\n",dimension);
        
        numeros.add(15);
        numeros.add(100);
        numeros.add(-200);
        dimension = DimensionArrayList(numeros);
        System.out.printf("\nDimension de ArrayList: %d\n",dimension);
        
        System.out.print("");
        VisualizarContenidoArrayList(numeros);
        System.out.println("------------------");
        
        numeros.add(400);
        VisualizarContenidoArrayList(numeros);
        System.out.println("------------------");
        
        System.out.println("Modificando elementos");
        numeros.set(1,900);
        
        System.out.println("------------------");
        VisualizarContenidoArrayList(numeros);
        
        System.out.println("----------------------------");
        System.out.println("Quitando elementos de ArrayList");
        VisualizacionDatoEliminado(numeros);
        numeros.remove(0);
        VisualizacionDatoEliminado(numeros);
        
        System.out.println("----------------------------");
        System.out.println("Eliminando contenido completo");
        numeros.clear();
        VisualizarContenidoArrayList(numeros);
        System.out.println("----------------------------");
        System.out.println("Ciclo for each");
        numeros.add(400);
        numeros.add(200);
        numeros.add(100);
        numeros.add(150);
        numeros.add(250);
        /* for each */
        for(int dato : numeros){
            System.out.printf("Valores: %d\n",dato);
        }
    }//fin main
    
    public static int DimensionArrayList(ArrayList<Integer> arreglo){
        int valorTemp = 0;
        valorTemp = arreglo.size();
        return valorTemp;
    }// fin de DimensionArrayList
    
    public static void VisualizarContenidoArrayList(ArrayList<Integer> arreglo){
        int valorTemp = 0;
        for(int i = 0; i < arreglo.size(); i++){
            System.out.printf("Posicion: %d\t",i);
            valorTemp = arreglo.get(i);
            System.out.printf("Valor: %d\n",valorTemp);
        }
    }// fin de VisualizarContenidoArrayList
    
    public static void VisualizacionDatoEliminado(ArrayList<Integer> arreglo){
        int dimensionTemp = 0;
        dimensionTemp = DimensionArrayList(arreglo);
        System.out.printf("Dimension inicial: %d\n",dimensionTemp);
        VisualizarContenidoArrayList(arreglo);
    }// fin de VisualizacionDatoEliminado
}//fin clase ListaDeArreglos
