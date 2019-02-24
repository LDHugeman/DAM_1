package alumnospila;

import objetos.Alumno;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrarAlumno(Alumno alumno) {
        System.out.println("-------------------------------------------");
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Código: " + alumno.getCodigo());
        System.out.println("Módulo: " + alumno.getModulo());
        System.out.println("Nota: " + alumno.getNota());
        System.out.println("-------------------------------------------");
    }

    public static void mostrarAlumnosSuperioresNota(int nota, Alumno cabecera) {
        Alumno actual = cabecera;
        while (actual != null) {
            if (actual.getNota() > nota) {
                mostrarAlumno(actual);
            }
            actual = actual.getSiguiente();
        }
    }
}