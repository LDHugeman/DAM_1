
package agenciaviajesjerarquizada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {
    public static Reserva novaReserva()throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Tipo de vivienda: %n"
                + "A para Apartamento");
        String tipoVivienda = lee.readLine();
        
    }
}
