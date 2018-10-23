package agenciaviajesjerarquizada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {

    public static Reserva novaReserva() throws IOException {
       BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
       String tipoVivienda = seleccionarVivienda(lee);
       
    }

    private static void mostrarMenuVivienda() {
        System.out.printf("Seleccione el tipo de vivienda: %n"
                + "Escriba A para Apartamento"
                + "Escriba V para Vivienda");
    }

    private static String seleccionarVivienda(BufferedReader lee) throws IOException {
        mostrarMenuVivienda();
        char opcionSeleccionada = lee.readLine().charAt(0);
        switch (opcionSeleccionada) {
            case 'A':
                return "Apartamento";
            case 'V':
                return "Vivienda";
            default:
                System.err.printf("Esa opción non existe.");
                return null;
        }
    }
}
