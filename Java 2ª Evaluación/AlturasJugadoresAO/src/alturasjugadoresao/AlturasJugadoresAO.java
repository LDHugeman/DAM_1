
package alturasjugadoresao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class AlturasJugadoresAO {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int numeroJugadores = Introducir.obterNumeroDeJugadores(lee);
        Jugador [] jugador = new Jugador [numeroJugadores];
    }
    
}
