package alumnospila;

import java.io.BufferedReader;
import objetos.Alumno;

/**
 *
 * @author a18luisdvp
 */
public class Altas {

    public static Alumno altaNuevoAlumno(Alumno nuevoAlumno, Alumno cabecera, BufferedReader lee) {
        nuevoAlumno.setSiguiente(cabecera);
        return nuevoAlumno;
    }
}
