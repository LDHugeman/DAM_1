
package alturasjugadoresao;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {
    
    public static int obterNumeroDeJugadores(BufferedReader lee)throws IOException{
        System.out.printf("¿Cuántos jugadores desea introducir?");
        return Integer.parseInt(lee.readLine());
    }
}
