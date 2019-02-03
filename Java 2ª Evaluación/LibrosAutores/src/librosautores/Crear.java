package librosautores;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author a18luisdvp
 */
public class Crear {

    public static Autor crearNuevoAutor(BufferedReader lee, Libro primerLibro, ArrayList <Autor> autores) throws IOException {
        String dni = pedirDni(lee, autores);       
        String nombre = pedirNombreAutor(lee);
        System.out.printf("Ciudad: ");
        String ciudad = lee.readLine();
        return new Autor(dni, nombre, ciudad, primerLibro);
    }

    public static String pedirDni(BufferedReader lee, ArrayList <Autor> autores ) throws IOException {
        String dni = "";
        do {
            System.out.printf("Inserte el Dni del autor: ");
            dni= lee.readLine();
        } while (!Validar.esDniValido(dni, autores));
        return dni;
    }

    public static Libro crearNuevoLibro(ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        String isbn;
        do {
            isbn = pedirNuevoIsbn(libros, lee);
        } while (isbn == null);

        String titulo = pedirTitulo(lee);
        System.out.printf("Precio: ");
        float precio = Float.parseFloat(lee.readLine());
        Libro nuevoLibro = new Libro(isbn, titulo, precio);
        libros.add(nuevoLibro);
        return nuevoLibro;
    }
    
    public static String pedirNombreAutor(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del autor: ");
        return lee.readLine();
    }

    public static String pedirIsbn(BufferedReader lee) throws IOException {
        System.out.printf("Isbn: ");
        return lee.readLine();
    }

    public static String pedirNuevoIsbn(ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        String isbn = pedirIsbn(lee);
        if (Consultar.existeLibro(isbn, libros)) {
            System.err.printf("Ya existe un libro con ese isbn%n");
            return null;
        } else {
            return isbn;
        }
    }

    public static String pedirIsbnExistente(ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        String isbn = pedirIsbn(lee);
        if (Consultar.existeLibro(isbn, libros)) {
            return isbn;
        } else {
            System.err.printf("No existe ningún libro con ese isbn %n");
            return null;
        }

    }

    public static String pedirTitulo(BufferedReader lee) throws IOException {
        System.out.printf("Título: ");
        return lee.readLine();
    }

    public static String pedirTituloExistente(ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        String nombre = pedirTitulo(lee);
        if (Consultar.existeLibroPorNombre(nombre, libros)) {
            return nombre;
        } else {
            System.err.printf("No existe ningún libro con ese nombre %n");
            return null;
        }
    }
}
