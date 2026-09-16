/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template 
*/

/* @author UserCP | Rudy | Rafael */

package restauratemicasita;
import java.util.Scanner;
import java.util.ArrayList;

public class RestaurateMiCasita{
    /* constantes */
    private static int MESAS_RESERVADAS = 8; /* ocho mesas */
    private static int MESERO_ASIGNADO = 8; /* ocho meseros */
    
    /* Listas acumuladoras para el pedido y sus costos */
    private static ArrayList<String> productosSeleccionados = new ArrayList<>(); /* tipo String para guardar nombre del producto*/
    private static ArrayList<Double> preciosSeleccionados = new ArrayList<>(); /* tipo doble para guardar precio del producto */
    
    /* control de reservacion de mesas */
    private static boolean[] mesasReservadas = new boolean[MESAS_RESERVADAS]; /* para mostrar si mesa esta reservada o disponible */
    
    /* Arreglo para almacenar el nombre del mesero asignado a cada mesa */
    private static String[] meserosAsignados = new String[MESERO_ASIGNADO];
    
    /* @param args the command line arguments */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        /* Constantes y Variables */
        final String NOMBRE_SISTEMA = "RESTAURANTE MI CASITA";
        int opcionPrincipal = 0;
        
        /* menu principal */
        while(opcionPrincipal != 5){
            /* array para el primer menu o menu principal */
            String[] menuPrincipal = {"1. Ver Menu", "2. Reservar Mesa", "3. Asignar Mesero", "4. Imprimir Factura", "5. Salir"};

            /* creación de la interfaz de primera pantalla  */
            System.out.println("===========================================");
            System.out.println("====       " + NOMBRE_SISTEMA + "       ====");
            System.out.println("===========================================");
            System.out.println("...........................................");
            System.out.println(".  Seleccione una opcion                  .");
            System.out.println(".  ----------------------                 .");
            /* for each para primera opcion de menu principal */
            for(String menu : menuPrincipal){
                System.out.println(".  "+menu);
            }
            /* impresiones linea por linea como segunda opcion de menu principal */
            /*System.out.println(".  1. Ver Menu                            .");
            System.out.println(".  2. Reservar Mesa                       .");
            System.out.println(".  3. Asignar Mesero                      .");
            System.out.println(".  4. Imprimir Factura                    .");
            System.out.println(".  5. Salir                               .");*/
            System.out.println("...........................................");
            
            /* mostrando las demas opciones de cada item del menu principal */
            if(scan.hasNextInt()){ /* comprobamos si la entrada es un numero entero o int para cada case del switch */
                opcionPrincipal = scan.nextInt();
                switch(opcionPrincipal){
                    case 1:
                        mostrarSubmenuMenu(scan);
                    break;
                    case 2:
                        reservarMesa(scan);
                    break;
                    case 3:
                        asignarMesero(scan);
                    break;
                    case 4:
                        imprimirFactura(scan);
                    break;
                    case 5:
                        System.out.println(".  Gracias por preferirnos!               .");
                        System.out.println(".  Esperamos que vuelva pronto!           .");
                        System.out.println("...........................................");
                        System.out.println("");
                    break;
                    default:
                        System.out.println(".  Opcion no valida. Intente de nuevo.    .");
                }
            }else{
                System.out.println(".  Entrada invalida. Seleccione un numero .");
                scan.next();
            }
        }
        scan.close();
    }// fin main
    
    /* mostra el sub menu de comidas */
    private static void mostrarSubmenuMenu(Scanner scanner){
        /* variable categorias */
        int opcionCategoria = 0;
        
        /* pantalla con categorias del menu comidas */
        while(opcionCategoria != 4){
            final String MENU_ENTRADAS = "1. Ver Menu | Seleccione una opcion";
            System.out.println(".....................................................");
            System.out.println(".     "+MENU_ENTRADAS+"           .");
            System.out.println(".        ---------------------------------          .");
            System.out.println(".        1. Entradas:                               .");
            System.out.println(".        2. Platillos fuertes:                      .");
            System.out.println(".        3. Especialidad de la casa:                .");
            System.out.println(".        4. Volver al menu principal                .");
            System.out.println(".....................................................");
            
            /**/
            if(scanner.hasNextInt()){ /* comprobamos si la entrada es un numero entero o int para cada case del switch */
                opcionCategoria = scanner.nextInt();
                switch(opcionCategoria){
                    case 1:
                        mostrarEntradas(scanner);
                        break;
                    case 2:
                        mostrarPlatillosFuertes(scanner);
                        break;
                    case 3:
                        mostrarEspecialidades(scanner);
                        break;
                    case 4:
                        System.out.println();
                        System.out.println(".  <<< Regresando...");
                        System.out.println();
                        break;
                    default:
                        System.out.println(".  Opción no valida.                      .");
                }
            }else{
                System.out.println(".  Entrada invalida. Seleccione un numero .");
                scanner.next();
            }
        }
    }//fin sub menu
    
    /**/
    private static void mostrarEntradas(Scanner scanner){
        /* variable para encabezado del sub menu entradas */
        String entradaCabecera = "1. Entradas | Seleccione una opcion";
        /* variables del sub menu entradas | [submenu_entradas => | entradas_menu | entradas_precio |] */
        String entradaSopa = "Sopa de Tomate Rustica:";
        String entradaBrucheta = "Bruschetta Clasica de Queso y Tomate:";
        String entradaCalamares = "Calamares Crujientes con Salsa Tartara:";
        String entradaEmbutidos = "Tabla de Embutidos y Quesos:";
        String entradaCesar = "Ensalada Cesar Individual:";
        String entradaSalir = "Volver al menu";

        /* variables para precios del sub menu entradas */
        double precioSopa = 70.00;
        double precioBrucheta = 90.00;
        double precioCalamares = 190.00;
        double precioEmbutidos = 210.00;
        double precioCesar = 150.00;
        /* divisa */
        char divisa = 'L';
        
        /* array sub menu estradas */
        /*String[] entradasMenu = {entradaSopa,entradaBrucheta,entradaCalamares,entradaEmbutidos,entradaCesar};
        double[] preciosEntradas = {precioSopa,precioBrucheta,precioCalamares,precioEmbutidos,precioCesar};
        int n = 1;
        for(int i = 0; i < entradasMenu.length; i++){
            System.out.println(".             "+ n++ +"   " + entradasMenu[i] +" " + divisa + preciosEntradas[i]);
        }*/
        
        /* pantalla con el sub menu de entradas del menu comidas */
        System.out.println("..................................................................");
        System.out.println(".          "+entradaCabecera+"                   .");
        System.out.println(".             ---------------------------------                  .");
        System.out.println(".             1. "+entradaSopa+"                 "+divisa+"  "+precioSopa+" .");
        System.out.println(".             2. "+entradaBrucheta+"   "+divisa+"  "+precioBrucheta+" .");
        System.out.println(".             3. "+entradaCalamares+" "+divisa+" "+precioCalamares+" .");
        System.out.println(".             4. "+entradaEmbutidos+"            "+divisa+" "+precioEmbutidos+" .");
        System.out.println(".             5. "+entradaCesar+"              "+divisa+" "+precioCesar+" .");
        System.out.println(".             6. "+entradaSalir+"                                  .");
        System.out.println("..................................................................");
        
        /**/
        if(scanner.hasNextInt()){ /* comprobamos si la entrada es un numero entero o int para cada case del switch */
            int entradaSeleccionada = scanner.nextInt();
            switch(entradaSeleccionada){
                case 1:
                    agregarProducto(entradaSopa, precioSopa); /* reemplazo precio por variable */
                break;
                case 2:
                    agregarProducto(entradaBrucheta, precioBrucheta); /* reemplazo precio por variable */
                break;
                case 3:
                    agregarProducto(entradaCalamares, precioCalamares); /* reemplazo precio por variable */
                break;
                case 4:
                    agregarProducto(entradaEmbutidos, precioEmbutidos); /* reemplazo precio por variable */
                break;
                case 5:
                    agregarProducto(entradaCesar, 150.00); /* no se ha reemplazado para ejemplo */
                break;
                case 6:
                    System.out.println();
                    System.out.println(".  <<< Regresando...");
                    System.out.println();
                break;
                default:
                    System.out.println(".  Opcion de entrada fuera de rango.      .");
            }
        }else{
            System.out.println(".  Entrada invalida.                      .");
            scanner.next();
        }
    }// fin mostrar entradas
    
    /**/
    private static void mostrarPlatillosFuertes(Scanner scanner){
        System.out.println(".................................................................");
        System.out.println(".          2 Platillos Fuertes | Seleccione una opcion          .");
        System.out.println(".            ------------------------------------------         .");
        System.out.println(".            1. Filete Mignon:                          L240.00 .");
        System.out.println(".            2. Salmon a la Plancha:                    L350.00 .");
        System.out.println(".            3. Lasagna:                                L220.00 .");
        System.out.println(".            4. Risoto:                                 L180.00 .");
        System.out.println(".            5. Tacos gourmet:                          L140.00 .");
        System.out.println(".            6. Volver al menu                                  .");
        System.out.println(".................................................................");
        
        /**/
        if(scanner.hasNextInt()){ /* comprobamos si la entrada es un numero entero o int para cada case del switch */
            int entradaSeleccionada = scanner.nextInt();
            switch(entradaSeleccionada){
                case 1:
                    agregarProducto("Filete Mignon", 240.00);
                break;
                case 2:
                    agregarProducto("Salmon a la Plancha", 350.00);
                break;
                case 3:
                    agregarProducto("Lasagna", 220.00);
                break;
                case 4:
                    agregarProducto("Risoto", 180.00);
                break;
                case 5:
                    agregarProducto("Tacos gourmet", 140.00);
                break;
                case 6:
                    System.out.println();
                    System.out.println(".  <<< Regresando...");
                    System.out.println();
                break;
                default:
                    System.out.println(".  Opcion de entrada fuera de rango.      .");
            }
        }else{
            System.out.println(".  Entrada invalida.                      .");
            scanner.next();
        }
    }// fin mostrar platillos fuertes
    
    /**/
    private static void mostrarEspecialidades(Scanner scanner){
        System.out.println(".................................................................");
        System.out.println(".          3 Especialidad de la casa | Seleccione una opcion    .");
        System.out.println(".            ------------------------------------------------   .");
        System.out.println(".            1. Parrillada al carbon:                   L900.00 .");
        System.out.println(".            2. Sopa de caracol:                        L170.00 .");
        System.out.println(".            3. Plato tipico combinado:                 L220.00 .");
        System.out.println(".            4. Costilla de cerdo en salsa BBQ:         L180.00 .");
        System.out.println(".            5. Frijoles, chismol y carne en anafre:    L180.00 .");
        System.out.println(".            6. Volver al menu                                  .");
        System.out.println(".................................................................");
        
        /**/
        if(scanner.hasNextInt()){ /* comprobamos si la entrada es un numero entero o int para cada case del switch */
            int entradaSeleccionada = scanner.nextInt();
            switch(entradaSeleccionada){
                case 1:
                    agregarProducto("Parrillada al carbon", 900.00);
                break;
                case 2:
                    agregarProducto("Sopa de caracol", 170.00);
                break;
                case 3:
                    agregarProducto("Plato tipico combinado", 220.00);
                break;
                case 4:
                    agregarProducto("Costilla de cerdo en salsa BBQ", 180.00);
                break;
                case 5:
                    agregarProducto("Frijoles, chismol y carne en anafre", 180.00);
                break;
                case 6:
                    System.out.println();
                    System.out.println(".  <<< Regresando...");
                    System.out.println();
                break;
                default:
                    System.out.println(".  Opcion de entrada fuera de rango.      .");
            }
        }else{
            System.out.println(".  Entrada invalida.                      .");
            scanner.next();
        }
    }// fin mostrar especialidades
    
    /* proceso de agregar productos del menu */
    private static void agregarProducto(String nombre, double precio){
        productosSeleccionados.add(nombre);
        preciosSeleccionados.add(precio);
        System.out.println(".  -> " + nombre + " agregado a la orden.");
        System.out.println();
    }
    
    /* reservacion de mesas */
    private static void reservarMesa(Scanner scanner){
        System.out.println(".................................................");
        System.out.println(".     2  Reservacion de mesa                    .");
        System.out.println(".        --------------------                   .");
        System.out.println(".        Estado actual de las mesas:            .");
        
        // Formato para desplegar cada mesa con su área correspondiente
        for(int i = 0; i < mesasReservadas.length; i++){
            int numeroMesa = i + 1; // para lectura humana | que no comience en cero
            String area = obtenerAreaMesa(numeroMesa);
            String estado = mesasReservadas[i] ? "Reservada" : "Disponible";
            System.out.printf(".        Mesa %d (%-10s): %-11s       .\n", numeroMesa, area, estado);
        }
        System.out.println(".................................................");
        System.out.println(".        0. Volver al menu principal            .");
        System.out.println(".        Seleccione un numero de mesa:          .");
        System.out.println(".................................................");
        
        /**/
        if(scanner.hasNextInt()){
            int mesaElegida = scanner.nextInt();
            if(mesaElegida == 0){
                System.out.println(".  Regresando al menu principal...         .");
            }else if(mesaElegida >= 1 && mesaElegida <= 8){
                int indice = mesaElegida - 1;
                if(mesasReservadas[indice]) {
                    System.out.println(".  Mesa " + mesaElegida + " Reservada. Seleccione otra.   .");
                }else{
                    mesasReservadas[indice] = true;
                    System.out.println(">>  Mesa " + mesaElegida + " (" + obtenerAreaMesa(mesaElegida) + ") reservada exitosamente ");
                }
            }else{
                System.out.println(".  Numero de mesa fuera de rango (1-8).   .");
            }
        }else{
            System.out.println(".  Entrada invalida. Ingrese un numero.   .");
            scanner.next();
        }
        System.out.println(".................................................");
        System.out.println();
    }// fin de reservacion de mesas
    
    /* mapa de posicion de las mesas */
    private static String obtenerAreaMesa(int numeroMesa){
        /* variables de areas de mesas */
        String comedor = "Comedor";
        String barra = "Barra";
        String terraza = "Terraza";
        /* casos para seleccion de areas de mesas | total 8 mesas = 8 casos */
        switch(numeroMesa){
            case 1: case 2:
                return comedor;
            case 3: case 4:
                return barra;
            case 5: case 6:
                return terraza;
            case 7: case 8:
                return "VIP";
            default:
                return "Desconocida";
        }
    }// fin de mapa de mesas
    
    /* asignacion de mesero */
    private static void asignarMesero(Scanner scanner){
        System.out.println(".................................................");
        System.out.println(".     3. Asignacion de mesero exclusivo         .");
        System.out.println(".        -------------------------------        .");
        
        /* Verificar si existe al menos una mesa reservada */
        boolean hayReservas = false;
        for(boolean estado : mesasReservadas){
            if(estado){
                hayReservas = true;
                break;
            }
        }
        
        /**/
        if(!hayReservas){
            System.out.println(".        No hay mesas reservadas actualmente.   .");
            System.out.println(".        Primero debe reservar una mesa.        .");
            System.out.println(".................................................");
            System.out.println();
            return;
        }
        
        /**/
        System.out.println(".        Mesas reservadas actualmente:           .");
        for(int i = 0; i < mesasReservadas.length; i++){
            if(mesasReservadas[i]){
                int numeroMesa = i + 1;
                String area = obtenerAreaMesa(numeroMesa);
                String mesero = (meserosAsignados[i] != null) ? meserosAsignados[i] : "Sin asignar";
                System.out.printf(".        Mesa %d (%-8s) -> Mesero: %-15s.\n", numeroMesa, area, mesero);
            }
        }
        
        /**/
        System.out.println("...................................................");
        System.out.println(".        0. Volver al menu principal              .");
        System.out.println("...................................................");
        System.out.print(".        Ingrese el numero de mesa reservada:     .");
        
        /**/
        if(scanner.hasNextInt()){
            int mesaElegida = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            if(mesaElegida == 0){
                System.out.println(".        Regresando al menu principal...         .");
            }else if(mesaElegida >= 1 && mesaElegida <= 8){
                int indice = mesaElegida - 1;
                if(!mesasReservadas[indice]){
                    System.out.println(".        La Mesa " + mesaElegida + " no esta reservada.             .");
                    System.out.println(".        Solo se pueden asignar meseros a mesas reservadas. ");
                }else{
                    System.out.print(".        Ingrese el nombre del mesero asignado: ");
                    String nombreMesero = scanner.nextLine().trim();

                    if(!nombreMesero.isEmpty()){
                        meserosAsignados[indice] = nombreMesero;
                        System.out.println(".        Mesero '" + nombreMesero + "' asignado exitosamente a la Mesa " + mesaElegida + ". .");
                    }else{
                        System.out.println(".        El nombre del mesero no puede estar vacio. .");
                    }
                }
            }else{
                System.out.println(".        Numero de mesa fuera de rango (0-8).   .");
            }
        }else{
            System.out.println(".        Entrada invalida. Ingrese un numero.   .");
            scanner.next();
        }
        System.out.println("...................................................");
        System.out.println();
    }
    
    /* proceso de facturacion */
    private static void imprimirFactura(Scanner scanner){
        System.out.println("");
        System.out.println("========================================================");
        System.out.println("====              FACTURA DE CONSUMO                ====");
        System.out.println("========================================================");
        
        /* productos seleccionados */
        if(productosSeleccionados.isEmpty()) {
            System.out.println(".   No hay productos consumidos aun.                   .");
            System.out.println("========================================================");
            System.out.println();
            return;
        }
        
        /* mensaje para imprmir factura */
        System.out.println("   Ingrese el numero de mesa para generar la factura.  .");
        System.out.println(".  0. Volver al menu principal                         .");
        System.out.println("........................................................");
        
        /* seleccion de mesas */
        if(scanner.hasNextInt()){
            int mesaElegida = scanner.nextInt();
            
            /* si no se selecciona una mesa, regresamos al menu principal */
            if(mesaElegida == 0){
                System.out.println(".  Regresando al menu principal...         .");
                System.out.println("===========================================\n");
                return;
            }
            
            /* mesas a elegir entre la 1 y la 8 */
            if(mesaElegida >= 1 && mesaElegida <= 8){
                int indice = mesaElegida - 1;
                String areaMesa = obtenerAreaMesa(mesaElegida);
                String nombreMesero = (meserosAsignados[indice] != null) ? meserosAsignados[indice] : "Sin asignar";
                String estadoMesa = mesasReservadas[indice] ? "Reservada" : "Sin reservar";
                
                /* factura de consumo */
                System.out.println("");
                System.out.println("========================================================");
                System.out.println("====              FACTURA DE CONSUMO                ====");
                System.out.println("========================================================");
                System.out.printf(". Mesa N: %-2d (%-8s)                                  \n", mesaElegida, areaMesa);
                System.out.printf(". Estado: %-12s                                        \n", estadoMesa);
                System.out.printf(". Atendido por: %-25s                                  \n", nombreMesero);
                System.out.println("........................................................");
                System.out.println(". CONSUMO REALIZADO:                                   .");
                
                /* sub total */
                double subtotal = 0.0;
                for (int i = 0; i < productosSeleccionados.size(); i++) {
                    String nombre = productosSeleccionados.get(i);
                    double precio = preciosSeleccionados.get(i);
                    System.out.printf(". %-35s L%7.2f  .\n", nombre, precio);
                    subtotal += precio;
                }

                /* Cálculos de ISV y Propina */
                double isv = subtotal * 0.15;
                double propinaSugerida = subtotal * 0.10;
                double totalGeneral = subtotal + isv + propinaSugerida;
                
                /* subtotal impreso, ISV, propina y total */
                System.out.println("........................................................");
                System.out.printf(". SUBTOTAL:                           L%7.2f \n", subtotal);
                System.out.printf(". ISV (15%%):                          L%7.2f \n", isv);
                System.out.printf(". PROPINA SUGERIDA (10%%):             L%7.2f \n", propinaSugerida);
                System.out.println("........................................................");
                System.out.printf(". TOTAL A PAGAR:                      L%7.2f \n", totalGeneral);
            }else{
                System.out.println(".  Numero de mesa fuera de rango (0-8).   .");
            }
        }else{
            System.out.println(".  Entrada invalida. Ingrese un numero.   .");
            scanner.next();
        }
        System.out.println("........................................................");
        System.out.println();
    }
}//fin restaurante