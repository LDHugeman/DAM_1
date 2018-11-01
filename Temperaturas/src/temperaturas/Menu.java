package temperaturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    private static void mostrarMenu() {
        System.out.println("");
        System.out.printf("1. Introducir %n"
                + "2. Buscar %n"
                + "3. Visualizar %n"
                + "4. Salir %n"
                + "Seleccione una opción: ");

    }

    public static byte seleccionarOpcion() throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        mostrarMenu();
        byte opcionseleccionada = Byte.parseByte(lee.readLine());
        System.out.println("");
        return opcionseleccionada;
    }
}
