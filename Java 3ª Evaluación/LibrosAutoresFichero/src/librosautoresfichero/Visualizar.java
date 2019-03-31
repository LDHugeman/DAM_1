package librosautoresfichero;

import Objetos.Autor;
import Objetos.Libro;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrar(Autor autor) {
        System.out.println("-------------------------------------------");
        System.out.println("Dni: " + autor.getDni());
        System.out.println("Nombre: " + autor.getNombre());
        System.out.println("Ciudad: " + autor.getCiudad());
        System.out.println("-------------------------------------------");
    }

    public static void mostrar(Libro libro) {
        System.out.println("-------------------------------------------");
        System.out.println("Isbn: " + libro.getIsbn());
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Precio: " + libro.getPrecio());
        System.out.println("-------------------------------------------");
    }
}
