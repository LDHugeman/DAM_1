
package coleccionnumeros;

import java.io.*;

/**
 *
 * @author David
 */
public class Menu {
    
    public static byte seleccionarOpcion(BufferedReader lee)throws IOException{
        mostrarMenu();
        return Byte.parseByte(lee.readLine());
    }
    private static void mostrarMenu(){
        System.out.printf("1. Introducir %n"
                + "2. Visualizar números introducidos %n"
                + "3. Separar %n"
                + "4. Visualizar positivos, negativos y nulos %n"
                + "5. Salir %n"
                + "Seleccione una opción: ");
    }
}
