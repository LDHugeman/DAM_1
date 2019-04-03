package librosautoresfichero;

import Excepciones.Validar;
import Objetos.Autor;
import Objetos.Libro;
import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author a18luisdvp
 */
public class Crear {

    public static Autor nuevoAutor(File fichero, BufferedReader lee) {
        String dni = pedirNuevoDni(fichero, lee);
        String nombre = pedirNombre(lee);
        System.out.printf("Ciudad: ");
        String ciudad = Pedir.texto(lee);
        return new Autor(dni, nombre, ciudad);
    }

    public static Libro nuevoLibro(BufferedReader lee) {
        System.out.printf("Isbn: ");
        String isbn = Pedir.texto(lee);
        String titulo = pedirTitulo(lee);
        Float precio = pedirPrecio(lee);
        return new Libro(isbn, titulo, precio);
    }

    public static String pedirNuevoDni(File fichero, BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esNuevoDniValido(fichero, dni));
        return dni;
    }

    public static String pedirDniExistente(File fichero, BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esDniExistenteValido(fichero, dni));
        return dni;
    }

    public static String pedirTitulo(BufferedReader lee) {
        System.out.printf("Título: ");
        return Pedir.texto(lee);
    }
    
    public static float pedirPrecio(BufferedReader lee) {
        System.out.printf("Precio: ");
        return Pedir.numeroReal(lee);
    }
    
    public static String pedirNombre(BufferedReader lee) {
        System.out.printf("Nombre: ");
        return Pedir.texto(lee);
    }
}
