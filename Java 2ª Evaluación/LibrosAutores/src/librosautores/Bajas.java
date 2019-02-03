package librosautores;

import java.util.ArrayList;
import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author a18luisdvp
 */
public class Bajas {

    public static void eliminarLibro(ArrayList<Autor> autores, ArrayList<Libro> libros, Libro libro) {
        for (Autor autor : autores) {
            autor.getLibros().remove(libro);
        }
        libros.remove(libro);
    }
}
