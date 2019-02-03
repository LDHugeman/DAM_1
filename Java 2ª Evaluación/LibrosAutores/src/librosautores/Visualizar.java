
package librosautores;

import java.util.ArrayList;
import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author a18luisdvp
 */
public class Visualizar {
    
    public static void mostrarLibro(Libro libro){
        System.out.println("-------------------------------------------");
        System.out.println("Título: "+ libro.getTitulo());
        System.out.println("Isbn: " + libro.getIsbn());
        System.out.println("Precio: "+ libro.getPrecio());
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarLibros(ArrayList<Libro> libros){
        for(Libro libro:libros){
            mostrarLibro(libro);
        }
    }
    
    public static void mostrarAutor(Autor autor){
        System.out.println("-------------------------------------------");
        System.out.println("Nombre: " + autor.getNombre());
        System.out.println("Dni: " + autor.getDni());
        System.out.println("Ciudad: " + autor.getCiudad());
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarAutores(ArrayList<Autor> autores){
        for(Autor autor:autores){
            mostrarAutor(autor);
        }
    }
    
}
