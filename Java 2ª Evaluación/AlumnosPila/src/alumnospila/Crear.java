package alumnospila;

import java.io.BufferedReader;
import objetos.Alumno;

/**
 *
 * @author a18luisdvp
 */
public class Crear {

    public static Alumno crearNuevaPilaAlumnos(Alumno cabecera, BufferedReader lee) {
        System.out.println("¿Desea eliminar la pila actual y crear una nueva?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        System.out.printf("Seleccione una opcion: ");
        byte opcionSeleccionada = Pedir.numeroByte(lee);
        if (opcionSeleccionada == 1) {
            cabecera = null;
            System.out.printf("Nueva pila de alumnos creada %n");
        } else {
            System.out.printf("No se ha creado una nueva pila%n");
        }
        return cabecera;
    }

    public static String pedirModulo(BufferedReader lee) {
        String modulo = "";
        do {
            System.out.printf("Módulo: ");
            modulo = Pedir.texto(lee);
        } while (!Validar.esModuloValido(modulo));
        return modulo;
    }

    public static String pedirNuevoCodigo(BufferedReader lee, Alumno cabecera) {
        String codigo = "";
        do {
            System.out.printf("Código: ");
            codigo = Pedir.texto(lee);
        } while (!Validar.esCodigoNuevoValido(codigo, cabecera));
        return codigo;
    }

    public static String pedirCodigoExistente(BufferedReader lee, Alumno cabecera) {
        String codigo = "";
        do {
            System.out.printf("Código: ");
            codigo = Pedir.texto(lee);
        } while (!Validar.existeCodigo(codigo, cabecera));
        return codigo;
    }

    public static Alumno crearNuevoAlumno(Alumno cabecera, BufferedReader lee) {
        System.out.printf("Nombre: ");
        String nombre = Pedir.texto(lee);
        String codigo = pedirNuevoCodigo(lee, cabecera);
        String modulo = pedirModulo(lee);
        System.out.printf("Nota: ");
        int nota = Pedir.numeroEntero(lee);
        return new Alumno(nombre, codigo, modulo, nota);
    }
}
