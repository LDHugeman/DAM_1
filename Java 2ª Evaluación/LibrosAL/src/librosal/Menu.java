
package librosal;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Menu {
    
    public static byte seleccionarOpcion(BufferedReader lee)throws IOException{
        mostrarMenu();
        return  Byte.parseByte(lee.readLine());
    }
    
    public static void mostrarMenu(){
        System.out.printf("1. Añadir libros %n"
                + "2. Insertar un libro %n"
                + "3. Borrado de un determinado libro %n"
                + "4. Modificar precio de un libro %n"
                + "5. Ordenar libros %n"
                + "6. Visualizar libros ordenados %n"
                + "Seleccione una opción: ");
    }
}
