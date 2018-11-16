package clientesbancarios2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    public static byte seleccionarOpcion(BufferedReader lee) throws IOException {
        mostrarMenu();
        return Byte.parseByte(lee.readLine());
    }

    private static void mostrarMenu() {
        System.out.printf("-------------------------------- Menú --------------------------------%n"
                + "1. Introducir clientes.%n"
                + "2. Obtener clientes con saldo positivo, números rojos y saldo nulo.%n"
                + "3. Clasificar.%n"
                + "4. Buscar. %n"
                + "5. Visualizar.%n"
                + "6. Salir.%n"
                + "Seleccione una opción: ");
    }
}
