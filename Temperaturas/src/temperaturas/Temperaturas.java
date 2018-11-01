package temperaturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class Temperaturas {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte[] temperaturas = new byte[7];
        final String[] diasSemana = new String[] {
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sábado",
            "Domingo"
        };
        byte opcionSeleccionada;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion();
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.cargarTemperaturas(temperaturas, diasSemana, lee);
                    break;
                case 2:
                    Buscar.obterDiasSuperiorMedia(args, temperaturas, opcionSeleccionada);
                    break;
            }
        } while (opcionSeleccionada != 4);

    }

}
