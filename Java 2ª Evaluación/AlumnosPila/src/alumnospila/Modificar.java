package alumnospila;

import java.io.BufferedReader;
import objetos.Alumno;

/**
 *
 * @author David
 */
public class Modificar {

    public static void notaAlumno(Alumno alumnoEncontrado, BufferedReader lee) {
        System.out.printf("Introduzca la nueva nota del alumno:  ");
        int nuevaNota = Pedir.numeroEntero(lee);
        alumnoEncontrado.setNota(nuevaNota);
    }
}
