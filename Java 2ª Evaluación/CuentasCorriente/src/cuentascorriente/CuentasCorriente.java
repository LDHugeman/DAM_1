package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;

/**
 *
 * @author Luis David
 */
public class CuentasCorriente {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        byte opcionSeleccionada = 0;

        do {
            try {
                opcionSeleccionada = Menu.selecionarOpcionMenuPrincipal(lee);
                switch (opcionSeleccionada) {
                    case 1:
                        Menu.menuAltas(lee, clientes, cuentas);
                        break;
                    case 2:
                        Menu.menuModificacions(lee, clientes, cuentas);
                        break;
                    case 3:
                        Menu.menuBaixas(lee, clientes, cuentas);
                        break;
                    case 4:
                        Menu.menuVisualizar(lee, clientes, cuentas);
                        break;
                }
            } catch (IOException | NumberFormatException | ParseException excepcion) {
                System.err.println("Ese campo no es válido");
            }

        } while (opcionSeleccionada != 0);

    }
}
