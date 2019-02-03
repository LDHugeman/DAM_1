package librosautores;

import java.util.ArrayList;
import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author David
 */
public class Consultar {

    public static boolean existeLibro(String isbn, ArrayList<Libro> libros) {
        return encontrarLibro(isbn, libros) != null;
    }

    public static Libro encontrarLibro(String isbn, ArrayList<Libro> libros) {
        Libro libroEncontrado = null;
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libroEncontrado = libro;
            }
        }
        return libroEncontrado;
    }

    public static boolean existeLibroPorNombre(String nombre, ArrayList<Libro> libros) {
        return encontrarLibroPorNombre(nombre, libros) != null;
    }

    public static Libro encontrarLibroPorNombre(String nombreLibro, ArrayList<Libro> libros) {
        Libro libroEncontrado = null;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(nombreLibro)) {
                libroEncontrado = libro;
            }
        }
        return libroEncontrado;
    }

    public static Autor encontrarAutorPorNombre(String nombreAutor, ArrayList<Autor> autores) {
        Autor autorEncontrado = null;
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                autorEncontrado = autor;
            }
        }
        return autorEncontrado;
    }

    public static Autor encontrarAutorPorDni(String dni, ArrayList<Autor> autores) {
        Autor autorEncontrado = null;       
            for (Autor autor : autores) {
                if (autor.getDni().equalsIgnoreCase(dni)) {
                    autorEncontrado = autor;
                }
            }      
        return autorEncontrado;
    }

    public static boolean existeAutorPorDni(String dni, ArrayList<Autor> autores) {
        return encontrarAutorPorDni(dni, autores) != null;
    }
}

