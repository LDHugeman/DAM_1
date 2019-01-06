
package librosal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Luis David
 */
public class Modificar {
    
    public static void modificarPrecioDeUnLibro (ArrayList<Libro> libro, BufferedReader lee, int posicionLibroEncontrada)throws IOException{
        if(posicionLibroEncontrada >= 0){
            System.out.printf("Introduzca el nuevo precio del libro %s: ",libro.get(posicionLibroEncontrada).getNombre());
            libro.get(posicionLibroEncontrada).setPrecio(Float.parseFloat(lee.readLine()));
        } else {
            System.err.printf("Ese libro no existe.");
        }
    }
}
