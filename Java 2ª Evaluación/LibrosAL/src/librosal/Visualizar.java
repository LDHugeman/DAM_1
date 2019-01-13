
package librosal;

import java.util.*;
/**
 *
 * @author Luis David
 */
public class Visualizar {
    
    public static void verLibrosOrdenAscendenteNombre (ArrayList<Libro> libro){
      Ordenar.ordenarPorIntercambioAscendenteNombre(libro);
      System.out.printf("--- Listado de libros --- %n");
      for(Libro libro : libros){
        System.out.printf("Libro: %s Precio: %.2f€ Isbn: %s %n",libro.getNombre(), libro.getPrecio(), libro.getIsbn());
      }
    }   
}
