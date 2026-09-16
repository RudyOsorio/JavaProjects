/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template */

package intropoo;
/* @author UserCP */
public class Persona {
    // variables - atributos
    public String nombre;
    public int edad;
    public double estatura;
    private char genero;
    
    public void ImpresionNombre(){
        System.out.println("Tu nombre es: " + nombre);
    }
    
    public void DetallesPersona(){
        System.out.println("Tu edad es: " + edad);
        System.out.printf("Con una altura de %.2f cm: ", estatura);
    }
    
    public void SetGenero(char gen){
        this.genero = gen;
    }
    
    public char GetGenero(){
        return this.genero;
    }
}
