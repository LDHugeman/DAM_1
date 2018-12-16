
package drogueria;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Menu {
    public static byte mostrarMenuVentas(BufferedReader lee)throws IOException{
        System.out.println("Escolla as ventas do producto:");
        System.out.println("1. Entre 0 e 100.");
        System.out.println("2. Entre 101 e 500.");
        System.out.println("3. Entre 501 e 1000.");
        System.out.println("4. Superiores a 1000.");     
        System.out.printf("Seleccione unha opción: ");
        return Byte.parseByte(lee.readLine());
    }
}
