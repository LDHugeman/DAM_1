package sociosempleados;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Empleado;
import objetos.Jefe;
import objetos.Socio;

/**
 *
 * @author David
 */
public class Crear {

    public static Socio crearNuevoSocio(BufferedReader lee, ArrayList<Empleado> empleados) throws IOException {
        String nombre = pedirNombre(lee);
        String dni = pedirNuevoDni(lee, empleados);
        System.out.printf("Sueldo: ");
        int sueldo = Integer.parseInt(lee.readLine());
        System.out.printf("Participaciones: ");
        int participaciones = Integer.parseInt(lee.readLine());
        return new Socio(nombre, dni, sueldo, participaciones);
    }

    public static Jefe crearNuevoJefe(BufferedReader lee, ArrayList<Empleado> empleados) throws IOException {
        String nombre = pedirNombre(lee);
        String dni = pedirNuevoDni(lee, empleados);
        System.out.printf("Sueldo: ");
        int sueldo = Integer.parseInt(lee.readLine());
        System.out.printf("Plus: ");
        int plus = Integer.parseInt(lee.readLine());
        return new Jefe(nombre, dni, sueldo, plus);
    }

    public static String pedirNombre(BufferedReader lee) throws IOException {
        String nombre = "";
        do {
            System.out.printf("Nombre: ");
            nombre = lee.readLine();
        } while (!Validar.esNombreValido(nombre));
        return nombre;
    }

    public static String pedirNuevoDni(BufferedReader lee, ArrayList<Empleado> empleados) throws IOException {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = lee.readLine();
        } while (!Validar.esDniValido(dni, empleados));
        return dni;
    }

    public static String pedirDni(BufferedReader lee) throws IOException {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = lee.readLine();
        } while (!Validar.esDniExistenteValido(dni));
        return dni;
    }
}


