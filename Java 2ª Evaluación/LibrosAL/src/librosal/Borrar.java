
package librosal;

import java.util.*;
/**
 *
 * @author Luis David
 */
public class Borrar {
    
    public static void BorrarLibroPorIsbn(ArrayList<Libro> libro, int posicionIsbnEncontrada){
        if(posicionIsbnEncontrada < 0){
            System.err.printf("Isbn inexistente %n");
        } else {
            libro.remove(posicionIsbnEncontrada);
        }
    }
}
