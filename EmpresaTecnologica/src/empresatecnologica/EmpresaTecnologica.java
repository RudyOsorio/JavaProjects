/*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template */
package empresatecnologica;
import java.util.Scanner;
/* @author UserCP */

/* Refactorización de un Sistema de Cotizaciones Tech

* Una tienda de tecnología ha escrito un programa en Java para generar cotizaciones. 
* El programa calcula el costo de los Productos Físicos (ej. Computadoras, cámaras) y 
* luego calcula el costo de los Servicios de Instalación.
* 
* Actualmente, el código es un "código espagueti" muy largo. El programador original copió y 
* pegó la lógica de validación, cálculos matemáticos y formato de impresión en diferentes partes del código.

Desarrollo
* Analizar el código base (que se te proporciona) e identifica los bloques repetidos. 
* Debes optimizar el programa creando 5 funciones genéricas que reemplacen el código duplicado. 
* Cada función debe ser llamada al menos dos veces en tu método main.

Casos a analizar y resolver (Las 5 funciones requeridas):

* Caso Visual: Hay líneas de asteriscos (*************************) que se imprimen en varios lugares 
* para separar secciones. (Solución: Crea una función sin parámetros y sin retorno).

* Caso de Ingreso de Datos: Cada vez que se pide un precio o tarifa, se hace un ciclo while para 
* evitar que el usuario ingrese números negativos. 
* (Solución: Crea una función sin parámetros que lea el teclado, valide que el número sea positivo y 
* lo retorne).

* Caso de Impuestos: El cálculo del 15% de impuesto se repite para los productos y luego para los servicios.
* (Solución: Crea una función con 1 parámetro [el monto] que calcule y retorne el impuesto).

*Caso de Descuentos: Se aplica un descuento a los productos y otro diferente a los servicios. 
* La fórmula matemática está repetida. 
* (Solución: Crea una función con 2 parámetros [monto y porcentaje] que calcule y retorne el valor 
* ya descontado).

*Caso de Reporte: Al final, la forma en que se imprime el subtotal de productos, el de servicios y 
* el total general usa el mismo formato de texto espaciado. 
* (Solución: Crea una función con parámetros [ej. concepto y monto] y sin retorno para 
* imprimir una línea de la factura de forma estandarizada). */
/**/
public class EmpresaTecnologica {
    /* @param args the command line arguments */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        double precioProducto = 0;
        double descProducto = 0;
        double valorConDescuentoProd = 0;
        double impuestoProd = 0;
        double subtotalProductos = 0;
        double tarifaServicio = 0;
        
        double descServicio = 0;
        double valorConDescuentoServ = 0;
        double impuestoServ = 0;
        double subtotalServicios = 0;
        double totalGeneral = 0;
        
        // 1. PROCESAMIENTO DE PRODUCTOS FÍSICOS
        System.out.println();
        Encabezado("MODULO DE PRODUCTOS FISICOS");
        System.out.print("Ingrese el nombre del producto: ");
        String producto = sc.nextLine();
        
        precioProducto = LeerMontoPositivo("producto");
        
        System.out.print("Ingrese el % de descuento para el producto (ej. 10): ");
        descProducto = sc.nextDouble();
        
        valorConDescuentoProd = CalculoDescuento(precioProducto, descProducto);
        impuestoProd = CalculoImpuesto(valorConDescuentoProd);
        subtotalProductos = valorConDescuentoProd + impuestoProd;
        
        
        
        // 2. PROCESAMIENTO DE SERVICIOS
        System.out.println();
        Encabezado("MODULO DE SERVICIOS DE INSTALACION");
        sc.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese el tipo de servicio: ");
        String servicio = sc.nextLine();
        
        tarifaServicio = LeerMontoPositivo("servicio tarifado");
        
        System.out.print("Ingrese el % de descuento para el servicio (ej. 5): ");
        descServicio = sc.nextDouble();
        
        valorConDescuentoServ = CalculoDescuento(tarifaServicio, descServicio);
        impuestoServ = CalculoImpuesto(valorConDescuentoServ);
        subtotalServicios = valorConDescuentoServ + impuestoServ;
         
        // 3. REPORTE FINAL
        System.out.println();
        totalGeneral = subtotalProductos + subtotalServicios;
        Encabezado("RESUMEN DE COTIZACION");
        
        ImprimirReporteFactura("Total " + producto, subtotalProductos);
        ImprimirReporteFactura("Total " + servicio, subtotalServicios);
        ImprimirLineaSeparacion();
        ImprimirReporteFactura("Total a Pagar", totalGeneral);
        
        // 1. PROCESAMIENTO DE PRODUCTOS FÍSICOS
        
        /* codigo reemplazado por la funcion Encabezado(); */
        //System.out.println("*************************************************");
        //System.out.println("       MODULO DE PRODUCTOS FISICOS");
        //System.out.println("*************************************************");
        
        //System.out.print("Ingrese el nombre del producto: ");
        //String producto = sc.nextLine();
        
        // Validación repetida 1
        /*precioProducto = -1;
        while (precioProducto < 0) {
            System.out.print("Ingrese el precio del producto (no negativo): Lps. ");
            precioProducto = sc.nextDouble();
            
            if (precioProducto < 0) {
                System.out.println("Error: El valor no puede ser negativo.");
            }
        }*/
        
        //System.out.print("Ingrese el % de descuento para el producto (ej. 10): ");
        //descProducto = sc.nextDouble();
        
        // Cálculos matemáticos mezclados
        //valorConDescuentoProd = CalculoDescuento(precioProducto, descProducto);
        
        //valorConDescuentoProd = precioProducto - (precioProducto * (descProducto / 100));
        
        //impuestoProd = valorConDescuentoProd * 0.15;
        //subtotalProductos = valorConDescuentoProd + impuestoProd;


        // 2. PROCESAMIENTO DE SERVICIOS
        
        /* codigo reemplazado por la funcion Encabezado(); */
        //ImpresionLineaAsterisco();
        //System.out.println("   MODULO DE SERVICIOS DE INSTALACION   ");
        //ImpresionLineaAsterisco();
        
        /* reemplazo de todas las lineas o renglones de asteriscos con ImpresionLineaAsterisco(); */
        //System.out.println("*************************************************");
        //System.out.println("   MODULO DE SERVICIOS DE INSTALACION   ");
        //System.out.println("*************************************************");
        
        //sc.nextLine(); // Limpiar buffer
        
        //System.out.print("Ingrese el tipo de servicio: ");
        //String servicio = sc.nextLine();
        
        // Validación repetida 2 (¡Código duplicado!)
        /*tarifaServicio = -1;
        while (tarifaServicio < 0) {
            System.out.print("Ingrese la tarifa del servicio (no negativo): Lps. ");
            tarifaServicio = sc.nextDouble();
            if (tarifaServicio < 0) {
                System.out.println("Error: El valor no puede ser negativo.");
            }
        }*/
        
        //System.out.print("Ingrese el % de descuento para el servicio (ej. 5): ");
        //descServicio = sc.nextDouble();
        
        // Cálculos matemáticos mezclados (¡Código duplicado!)
         //valorConDescuentoServ = tarifaServicio - (tarifaServicio * (descServicio / 100));
         //impuestoServ = valorConDescuentoServ * 0.15;
         //impuestoServ = CalculoImpuesto(valorConDescuentoServ);
         //subtotalServicios = valorConDescuentoServ + impuestoServ;
        
        
        // 3. REPORTE FINAL
        //totalGeneral = subtotalProductos + subtotalServicios;
        
        //ImpresionLineaAsterisco();
        //System.out.println("   RESUMEN DE COTIZACION   ");
        //ImpresionLineaAsterisco();
        
        /* reemplazo de todas las lineas o renglones de asteriscos con ImpresionLineaAsterisco();*/
        //System.out.println("*************************************************");
        //System.out.println("   RESUMEN DE COTIZACION   ");
        //System.out.println("*************************************************");
        
        
        // Formato de impresión repetido
        //System.out.printf("- %-30s : Lps. %.2f\n", "Total " + producto, subtotalProductos);
        //System.out.printf("- %-30s : Lps. %.2f\n", "Total " + servicio, subtotalServicios);
        //System.out.println("-------------------------------------------------");
        //System.out.printf("- %-30s : Lps. %.2f\n", "TOTAL A PAGAR", totalGeneral);
        //ImpresionLineaAsterisco();
        
        /* reemplazo de todas las lineas o renglones de asteriscos con ImpresionLineaAsterisco(); */
        //System.out.println("*************************************************");
        
    }
    /* creamos una funcion para crear un renglon de lineas de asteriscos */
    public static void ImpresionLineaAsterisco(){
        System.out.println("*******************************************");
    }
    
    public static void ImprimirLineaSeparacion(){
        System.out.println("-------------------------------------------------");
    }
    
    /* creamos una funcion para crear el encabezado */
    public static void Encabezado(String mensajeEncabezado){
        ImpresionLineaAsterisco();
        System.out.printf("\t%s\n",mensajeEncabezado);
        ImpresionLineaAsterisco();
    }
    
    /* creamos una funcion para los precios */
    public static double LeerMontoPositivo(String tipo){
        double montoValidado = -1;
        Scanner sc = new Scanner(System.in);
        while (montoValidado < 0) {
            System.out.printf("Ingrese el precio %s (no negativo): Lps. ", tipo);
            montoValidado = sc.nextDouble();
            if (montoValidado < 0) {
                System.out.println("Error: El valor no puede ser negativo.");
            }
        }
        return montoValidado;
    }
    
    /* creamos una funcion para el calculo del impuesto */
    public static double CalculoImpuesto(double monto){
        double impuestoCalculado = 0;
        impuestoCalculado = monto * 0.15;
        return impuestoCalculado;
    }
    
    /* creamos una funcion para el calculo del descuento */
    public static double CalculoDescuento(double monto, double descuento){
        double valorTemporal = 0;
        valorTemporal = monto - (monto * (descuento / 100));
        return valorTemporal;
    }
    
    /* creamos una funcion para el reporte final */
    public static void ImprimirReporteFactura(String concepto, double monto){
        System.out.printf("- %-30s : Lps. %.2f\n", concepto, monto);
    }
    
}
