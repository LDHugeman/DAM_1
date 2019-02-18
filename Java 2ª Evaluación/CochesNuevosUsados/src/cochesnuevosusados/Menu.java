package cochesnuevosusados;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import objetos.Coche;
import objetos.CocheAlquiler;
import objetos.CocheVenta;
import objetos.Uso;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    public static void menuAltas(BufferedReader lee, ArrayList<Coche> coches) throws IOException, ParseException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    CocheVenta cocheVenta = Crear.nuevoCocheVenta(lee, coches);
                    Altas.altaNuevoCoche(cocheVenta, coches);
                    break;
                case 2:
                    CocheAlquiler cocheAlquiler = Crear.nuevoCocheAlquiler(lee, coches);
                    Altas.altaNuevoCoche(cocheAlquiler, coches);
                    break;
                case 3:
                    System.out.printf("--- Introduzca el código del coche al que desea añadir usos ---");
                    String codigo = Crear.pedirCodigoExistente(lee, coches);
                    Coche coche = Consultar.encontrarCochePorCodigo(codigo, coches);
                    if (coche != null) {
                        if (coche instanceof CocheAlquiler) {
                            Uso uso = Crear.nuevoUso(lee);
                            ((CocheAlquiler) coche).addUso(uso);
                        }else{
                            System.out.printf("Ese código no corresponde a un coche de alquiler %n");
                        }
                    }else{
                        System.out.printf("No existe ningún coche con ese código.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void menuBajas(BufferedReader lee,ArrayList<Coche> coches)throws IOException{
        byte opcionSeleccionada = 0;
        do{
            opcionSeleccionada= seleccionarOpcionMenuBajas(lee);
            switch(opcionSeleccionada){
                case 1:
                    String codigoCocheVenta = Crear.pedirCodigoExistente(lee, coches);
                    CocheVenta cocheVenta = Consultar.encontrarCocheVentaPorCodigo(codigoCocheVenta, coches);
                    Bajas.eliminarCoche(cocheVenta, coches);
                    break;
                case 2:
                    String codigoCocheAlquiler = Crear.pedirCodigoExistente(lee, coches);
                    CocheAlquiler cocheAlquiler = Consultar.encontrarCocheAlquilerPorCodigo(codigoCocheAlquiler, coches);
                    Bajas.eliminarCoche(cocheAlquiler, coches);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        }while(opcionSeleccionada!=0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Altas");
        System.out.println("[2] Bajas");
        System.out.println("[3] Modificaciones");
        System.out.println("[4] Visualizar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) throws IOException {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Coche en venta");
        System.out.println("[2] Coche en alquiler");
        System.out.println("[3] Usos");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }
    
    public static byte seleccionarOpcionMenuBajas(BufferedReader lee) throws IOException {
        System.out.println("------- BAJAS -------");
        System.out.println("[1] Coche en venta");
        System.out.println("[2] Coche en alquiler");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }
}
