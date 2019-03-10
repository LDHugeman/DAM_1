package ensaladaslista;

import java.io.BufferedReader;

/**
 *
 * @author David
 */
public class Menu {

    public static byte seleccionarOpcionMenu(BufferedReader lee) {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Crear nueva lista de ensaladas");
        System.out.println("[2] Insertar ensalada");
        System.out.println("[3] Comprobar si hay ensaladas caducadas");
        System.out.println("[4] Visualizar todas las ensaladas");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }
}
