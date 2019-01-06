
package librosal;

import java.util.*;
/**
 *
 * @author Luis David
 */
public class Visualizar {
    
    public static void verLibrosOrdenAscendenteNombre (ArrayList<Libro> libro){
      Ordenar.ordenarPorIntercambioAscendenteNombre(libro);
      Iterator it = libro.iterator();
        System.out.printf("--- Listado de libros --- %n");
      while (it.hasNext()){
          Libro libro2 = (Libro)it.next();
          System.out.printf("Libro: %s Precio: %.2f€ Isbn: %s %n",libro2.getNombre(), libro2.getPrecio(), libro2.getIsbn());
      }
    }   
}
