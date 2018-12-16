
package alturasjugadores2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {
    
    public static String obterNombre(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del jugador: ");
        return lee.readLine();
    }

    private static String obterPais(BufferedReader lee) throws IOException {
        System.out.printf("País: ");
        return lee.readLine();
    }

    private static float obterAltura(BufferedReader lee, String nombreJugador) throws IOException {
        System.out.printf("Altura de %s: ", nombreJugador);
        return Float.parseFloat(lee.readLine());
        
        
}
