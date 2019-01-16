
package arraybidimensionalprecios2;
import java.io.*;
/**
 *
 * @author Luis David
 */
public class Menu {
    
    public static byte seleccionarOpcion (BufferedReader lee)throws IOException{
        mostrarMenu();
        return Byte.parseByte(lee.readLine());
    }
    
    private static void mostrarMenu(){
        System.out.printf("------------------ Menu ------------------ %n"
                + "1. Introducir %n"
                + "2. Calcular precio medio por ciudades %n"
                + "3. Calcular precio medio por productos %n"
                + "4. Ordenar productos y precios medios %n"
                + "5. Buscar %n"
                + "6. Salir %n"
                + "Seleccione una opción: ");
    }
}
