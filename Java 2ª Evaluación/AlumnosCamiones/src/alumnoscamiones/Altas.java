package alumnoscamiones;

import interfaces.I_Nexo;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Alumno;
import objetos.Asignatura;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Altas {

    public static void altaNuevoAlumno(ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            System.out.println("Necesita añadir una asignatura del alumno que va a introducir.");
            Asignatura primerAsignatura = Crear.crearNuevaAsignatura(lee);
            Alumno alumno = Crear.crearNuevoAlumno(primerAsignatura, listado, lee);
            añadirAsignaturasAlumno(alumno, listado, lee);
            listado.add(alumno);
            System.out.println("¿Desea dar de alta un nuevo alumno?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            opcionSeleccionada = Byte.parseByte(lee.readLine());
        } while (opcionSeleccionada == 1);
    }

    public static void añadirAsignaturasAlumno(Alumno alumno, ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 1;
        while (opcionSeleccionada == 1) {
            System.out.println("¿Desea añadir más asignaturas al alumno " + alumno.getNombre() + "?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            opcionSeleccionada = Byte.parseByte(lee.readLine());
            if (opcionSeleccionada == 1) {
                Asignatura asignatura = Crear.crearNuevaAsignatura(lee);
                alumno.getAsignaturas().add(asignatura);
            }
        }
    }

    public static void altaNuevoCamion(ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            Camion camion = Crear.crearNuevoCamion(lee);
            listado.add(camion);
            System.out.println("¿Desea dar de alta un nuevo camión?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            opcionSeleccionada = Byte.parseByte(lee.readLine());
        } while (opcionSeleccionada == 1);
    }
}
