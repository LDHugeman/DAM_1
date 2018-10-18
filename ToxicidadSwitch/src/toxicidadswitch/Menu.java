
package toxicidadswitch;

import java.io.BufferedReader;
import java.io.IOException;


public class Menu {
    public static byte mostrarMenuToxicidad(BufferedReader lee)throws IOException{
        System.out.println("Escolla a toxicidade do producto:");
        System.out.println("1. Toxicidad de 0 a 10.");
        System.out.println("2. Toxicidad de 11.");
        System.out.println("3. Toxicidad de 12.");
        System.out.println("4. Toxicidad de 13.");
        System.out.println("5. Toxicidad mayor de 13.");
        System.out.printf("Seleccione unha opción: ");
        return Byte.parseByte(lee.readLine());
    }
}
