
package librosautores;

import java.io.BufferedReader;
import java.io.IOException;
import objetos.Libro;

/**
 *
 * @author a18luisdvp
 */
public class Modificar {
    
    public static Libro modificarPrecioLibro(Libro libro, BufferedReader lee){
        System.out.println("El precio actual es " + libro.getPrecio());
        System.out.printf("Introduzca un nuevo precio: ");
        try {
            float precio = Float.parseFloat(lee.readLine());
            libro.setPrecio(precio);
            return libro;
        } catch (IOException ex) {
            System.err.printf("Número inválido. %n");
            return null;
        }
    }
    
    
}
