
package arraybidimensionalprecios;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Menu {
    
    public static byte seleccionarOpcion(BufferedReader lee)throws IOException{
        mostrarMenu();
        return Byte.parseByte(lee.readLine());
    }
    
    public static void mostrarMenu(){
        System.out.printf("------------------ Menu ------------------ %n"
                + "1. Introducir %n");
    }
}
