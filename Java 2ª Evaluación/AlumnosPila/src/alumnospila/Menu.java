package alumnospila;

import java.io.BufferedReader;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    public static byte seleccionarOpcionMenu(BufferedReader lee) {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Crear nueva pila");
        System.out.println("[2] Insertar alumnos");
        System.out.println("[3] Borrar un alumno");
        System.out.println("[4] Modificar nota de un alumno");
        System.out.println("[5] Visualizar alumnos con nota superior a 6");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opcion: ");
        return Pedir.numeroByte(lee);
    }
}
