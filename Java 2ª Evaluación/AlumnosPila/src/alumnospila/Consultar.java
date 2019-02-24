package alumnospila;

import objetos.Alumno;

/**
 *
 * @author David
 */
public class Consultar {

    public static Alumno obtenerAlumnoPorCodigo(String codigo, Alumno cabecera) {
        Alumno actual = cabecera;
        while (actual != null && !codigo.equalsIgnoreCase(actual.getCodigo())) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public static boolean existeAlumnoPorCodigo(String codigo, Alumno cabecera) {
        return obtenerAlumnoPorCodigo(codigo, cabecera) != null;
    }
}
