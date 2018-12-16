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
        boolean datosCargados = false;
        byte opcionSeleccionada;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion();
            switch (opcionSeleccionada) {
                case 1:
                    temperaturaMedia = Introducir.cargarTemperaturas(temperaturas, diasSemana, lee);
                    datosCargados = true;
                    break;
                case 2:
                    if (datosCargados) {
                        Visualizar.visualizarDiasSuperiorMedia(Buscar.obterDiasSuperiorMedia(diasSemana, temperaturas, temperaturaMedia));
                        Visualizar.visualizarTemperaturaMedia(Introducir.obterTemperaturaMedia(temperaturas));
                    }else{
                        System.err.println("No hay datos introducidos.");
                    }
                    break;
                case 3:
                    if (datosCargados) {
                        Visualizar.visualizarTemperaturasDias(temperaturas, diasSemana);
                        Visualizar.visualizarTemperaturaMedia(Introducir.obterTemperaturaMedia(temperaturas));
                        Visualizar.visualizarDiasSuperiorMedia(Buscar.obterDiasSuperiorMedia(diasSemana, temperaturas, temperaturaMedia));
                    }else{
                        System.err.println("No hay datos introducidos.");                     
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("");
                    System.err.println("Esa opción no existe");
                    System.out.println("");

            }
        } while (opcionSeleccionada != 4);

    }

}
