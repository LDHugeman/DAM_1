package agenciaviajesswitch;

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
        if (tipoVivienda != null) {
            System.out.printf("Número de personas del grupo: ");
            short numeroPersonas = Short.parseShort(lee.readLine());
            if (numeroPersonas > 0) {
                System.out.printf("Número de días: ");
                short estancia = Short.parseShort(lee.readLine());
                if (estancia > 0) {
                    return new Reserva(tipoVivienda, numeroPersonas, estancia);
                }else{
                    System.err.printf("Número de días incorrecto. %n");
                }
            }else {
                System.err.printf("Número de personas incorrecto. %n");
            }
        }
        return null;

    }

    private static void mostrarMenuVivienda() {
        System.out.printf("Seleccione el tipo de vivienda: %n"
                + "Escriba A para Apartamento. %n"
                + "Escriba V para Vivienda. %n");
    }

    private static String seleccionarVivienda(BufferedReader lee) throws IOException {
        mostrarMenuVivienda();
        char opcionSeleccionada = Character.toLowerCase(lee.readLine().charAt(0));
        switch (opcionSeleccionada) {
            case 'a':
                return "Apartamento";
            case 'v':
                return "Vivienda";
            default:
                System.err.printf("Esa opción non é válida. %n");
                return null;
        }
    }

}
