package listalinealalumnos;

import Clases.*;
import java.io.*;

// @author 
public class Insertar {

    public static C_Alumno insertar(C_Alumno cabecera, BufferedReader leer) throws IOException {

        String nombre, modulo;
        float nota;

        C_Alumno nuevoAlumno;
        C_Alumno actual;
        C_Alumno anterior;

        System.out.printf("Introducir nombre de alumno, pulse fin para finalizar%n");
        nombre = leer.readLine();

        while (nombre.compareToIgnoreCase("fin") != 0) {

            actual = cabecera;
            anterior = cabecera;

            System.out.printf("Introducir módulo:%n");
            modulo = leer.readLine();
            System.out.printf("Introducir nota del alumno%n");
            nota = Float.parseFloat(leer.readLine());
            nuevoAlumno = new C_Alumno(nombre, modulo, nota);
            if (cabecera == null) {
                /*Introducir primer objeto*/
                cabecera = nuevoAlumno;
            } else {
                cabecera = introducirAlumnoOrdenado(nuevoAlumno, cabecera, nombre);
            }

            System.out.printf("%n--ALUMNO CREADO--%n");

            System.out.printf("%nIntroducir nombre de alumno, pulse fin para finalizar%n");
            nombre = leer.readLine();

        }

        return cabecera;

    }

    private static C_Alumno introducirAlumnoOrdenado(C_Alumno nuevoAlumno, C_Alumno cabecera, String nombre) {
        C_Alumno actual = cabecera;
        C_Alumno anterior = cabecera;
        while (actual != null && nombre.compareToIgnoreCase(actual.getNombre()) > 0) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (anterior == actual) {
            /*añadir al principio de la lista*/
            nuevoAlumno.setSiguiente(cabecera);
            cabecera = nuevoAlumno;
        } else {
            /*añadir en el medio o al final de la lista*/
            nuevoAlumno.setSiguiente(actual);
            anterior.setSiguiente(nuevoAlumno);
        }
        return cabecera;
    }

}
