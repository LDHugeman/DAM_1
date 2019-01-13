
package librosal;

import java.util.*;
/**
 *
 * @author Luis David
 */
public class Visualizar {
    
    public static void verLibrosOrdenAscendenteNombre (ArrayList<Libro> libros){
      Ordenar.ordenarPorIntercambioAscendenteNombre(libros);
      Iterator it = libros.iterator();
        System.out.printf("--- Listado de libros --- %n");
      while (it.hasNext()){
          Libro libro = (Libro)it.next();
          System.out.printf("Libro: %s Precio: %.2f€ Isbn: %s %n",libro.getNombre(), libro.getPrecio(), libro.getIsbn());
      }
    }   
}
