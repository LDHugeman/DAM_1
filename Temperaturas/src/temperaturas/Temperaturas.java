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
        int temperaturaMedia = 0;
        byte[] temperaturas = new byte[7];
        final String[] diasSemana = new String[]{
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
                    temperaturaMedia = Introducir.cargarTemperaturas(temperaturas, diasSemana, lee);
                    break;
                case 2:
                    Visualizar.visualizarDiasSuperiorMedia(Buscar.obterDiasSuperiorMedia(diasSemana, temperaturas, temperaturaMedia));
                    break;
                case 3:
                    Visualizar.visualizarTemperaturasDias(temperaturas, diasSemana);
                    Visualizar.visualizarDiasSuperiorMedia(Buscar.obterDiasSuperiorMedia(diasSemana, temperaturas, temperaturaMedia));
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Esa opción no existe");
            }
        } while (opcionSeleccionada != 4);

    }

}
