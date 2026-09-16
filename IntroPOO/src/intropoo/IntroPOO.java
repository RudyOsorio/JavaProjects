/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */

package intropoo;
/* @author UserCP */
public class IntroPOO {
    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here
           Persona Jesus = new Persona();
           Persona Alejandra = new Persona();
           
           Jesus.nombre = "Eduardo";
           Jesus.edad = 33;
           Jesus.estatura = 1.9;
           Jesus.SetGenero('M');
           
           Alejandra.nombre = "Patricia";
           Alejandra.edad = 20;
           Alejandra.estatura = 1.6;
           Alejandra.SetGenero('F');
           
           Jesus.ImpresionNombre();
           Jesus.DetallesPersona();
           System.out.println();
           System.out.printf("Genero de %s es: %c\n",Jesus.nombre,Jesus.GetGenero());
           
           System.out.println();
           System.out.println();
           
           Alejandra.ImpresionNombre();
           Alejandra.DetallesPersona();
           System.out.println();
           System.out.printf("Genero de %s es: %c\n",Alejandra.nombre,Alejandra.GetGenero());
           
           VentanaPrincipal VP = new VentanaPrincipal(Jesus.nombre, Jesus.edad, Jesus.estatura);
           VP.setVisible(true);
           VP.setLocationRelativeTo(null);
           
           System.out.println();
    }
    
}
