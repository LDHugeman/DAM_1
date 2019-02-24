package alumnospila;

import objetos.Alumno;

/**
 *
 * @author David
 */
public class Bajas {

    public static Alumno eliminarAlumno(Alumno alumnoEncontrado, Alumno cabecera) {
        Alumno alumnoSuperior = cabecera;
        if (!alumnoEncontrado.equals(cabecera)) {
            while (alumnoSuperior.getSiguiente() != null && !alumnoSuperior.getSiguiente().equals(alumnoEncontrado)) {
                alumnoSuperior = alumnoSuperior.getSiguiente();
            }
        }else{
            cabecera = alumnoEncontrado.getSiguiente();
        }
        alumnoSuperior.setSiguiente(alumnoEncontrado.getSiguiente());
        return cabecera;
    }
}
