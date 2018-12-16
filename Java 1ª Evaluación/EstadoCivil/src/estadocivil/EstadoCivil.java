package estadocivil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class EstadoCivil {

    public static void main(String[] args) throws IOException {
        boolean repetir = true;
        int numeroSolteros = 0;
        int numeroCasados = 0;
        int numeroSeparados = 0;
        int numeroDivorciados = 0;
        int numeroViudos = 0;
        while (repetir) {
            String estadoCivil = obterEstadoCivil();
            if (estadoCivil != null) {
                switch (estadoCivil) {
                    case "Soltero":
                        numeroSolteros++;
                        break;
                    case "Casado":
                        numeroCasados++;
                        break;
                    case "Separado":
                        numeroSeparados++;
                        break;
                    case "Divorciado":
                        numeroDivorciados++;
                        break;
                    case "Viudo":
                        numeroViudos++;
                        break;
                }
            } else {
                repetir = false;
                visualizarEstadoCivil(numeroSolteros, numeroCasados, numeroSeparados, numeroDivorciados, numeroViudos);
            }

        }
    }

    public static String obterEstadoCivil() throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String estadoCivil = null;
        boolean repetir;
        do {
            repetir = false;
            mostrarMenuEstadoCivil();
            byte opcionSeleccionada = Byte.parseByte(lee.readLine());
            switch (opcionSeleccionada) {
                case 0:
                    repetir = false;
                    break;
                case 1:
                    estadoCivil = "Soltero";
                    break;
                case 2:
                    estadoCivil = "Casado";
                    break;
                case 3:
                    estadoCivil = "Separado";
                    break;
                case 4:
                    estadoCivil = "Divorciado";
                    break;
                case 5:
                    estadoCivil = "Viudo";
                    break;
                default:
                    System.out.println("");
                    System.err.println("Esa opción no es válida, inserte una nueva.");
                    System.out.println("");
                    repetir = true;
            }

        } while (repetir);
        return estadoCivil;
    }

    public static void mostrarMenuEstadoCivil() {
        System.out.printf("1. Soltero %n"
                + "2. Casado %n"
                + "3. Separado %n"
                + "4. Divorciado %n"
                + "5. Viudo %n"
                + "0. Fin %n"
                + "Seleccione una opción: ");
    }

    public static void visualizarEstadoCivil(int numeroSolteros, int numeroCasados, int numeroSeparados, int numeroDivorciados, int numeroViudos) {
        System.out.println("-------------Estadísticas-------------");
        System.out.printf("Solteros: %d %n", numeroSolteros);
        System.out.printf("Casados: %d %n", numeroCasados);
        System.out.printf("Separados: %d %n", numeroSeparados);
        System.out.printf("Divorciados: %d %n", numeroDivorciados);
        System.out.printf("Viudos: %d %n", numeroViudos);
    }
}
