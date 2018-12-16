
package alturasjugadoresao;

import java.io.BufferedReader;
import java.io.IOException;

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
        System.out.printf("---------------------------- Menú ----------------------------%n"
                + "1. Introducir %n"
                + "2. Calcular altura media de cada selección %n"
                + "3. Calcular la altura media de todos los jugadores %n"
                + "4. Calcular la altura máxima %n"
                + "5. Buscar jugadores %n"
                + "6. Mostrar jugadores ordenados por país %n"
                + "7. Salir %n"
                + "Seleccione una opción: ");
    }
}
