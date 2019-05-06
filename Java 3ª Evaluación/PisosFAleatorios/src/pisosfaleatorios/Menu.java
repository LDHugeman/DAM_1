package pisosfaleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import objetos.Atico;
import objetos.Duplex;
import objetos.Piso;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    public static void menuAltas(BufferedReader lee, File fichero) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    byte opcionAtico = 0;
                    do {
                        Atico atico = Crear.nuevoAtico(lee);
                        Altas.piso(atico, fichero);
                        System.out.println("¿Desea dar de alta más áticos?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcionAtico = Pedir.numeroByte(lee);
                    } while (opcionAtico ==1);
                    break;
                case 2:
                    byte opcionDuplex = 0;
                    do {
                        Duplex duplex = Crear.nuevoDuplex(lee);
                        Altas.piso(duplex, fichero);
                        System.out.println("¿Desea dar de alta más dúplex?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcionDuplex = Pedir.numeroByte(lee);
                    } while (opcionDuplex ==1);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void menuVisualizar(BufferedReader lee, File fichero) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuVisualizar(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Visualizar.pisos(fichero);
                    break;
                case 2:
                    Visualizar.recibos(fichero);
                    break;
                case 3:                   
                    ArrayList<Piso> pisosPropietario = Consultar.buscarPisosPorPropietario(fichero, Crear.obtenerNombrePropietario(lee));
                    Visualizar.pisosDeUnPropietario(pisosPropietario);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Altas");
        System.out.println("[2] Baja de un piso");
        System.out.println("[3] Modificaciones");
        System.out.println("[4] Visualizar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Ático");
        System.out.println("[2] Dúplex");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }
    
    public static byte seleccionarOpcionMenuVisualizar(BufferedReader lee) {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("[1] Pisos");
        System.out.println("[2] Recibos");
        System.out.println("[3] Pisos de un propietario");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

}
