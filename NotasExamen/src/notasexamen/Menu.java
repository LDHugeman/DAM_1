
package notasexamen;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Menu {
    
    private static void mostrarMenu(){
        System.out.printf("%n%n1. Introducir %n"
                + "2. Separar %n"
                + "3. Subir nota a suspensos. %n"
                + "4. Visualizar %n"
                + "5. Salir %n"
                + "Seleccione una opción: ");        
    }
    
    public static byte seleccionarOpcion(BufferedReader lee)throws IOException{
        mostrarMenu();
        byte opcionSeleccionada = Byte.parseByte(lee.readLine());
        return opcionSeleccionada;
    }
}
