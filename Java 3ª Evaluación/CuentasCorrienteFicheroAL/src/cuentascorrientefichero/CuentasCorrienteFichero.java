package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import objetos.Cuenta;

/**
 *
 * @author a18luisdvp
 */
public class CuentasCorrienteFichero {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        File fichero = new File("cuentas.dat");
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Archivo.nuevoFichero(cuentas, fichero, lee);
                    break;
                case 2:
                    cuentas = Consultar.extraerCuentas(fichero);
                    Menu.menuAltas(cuentas, fichero, lee);
                    break;
                case 3:
                    cuentas = Consultar.extraerCuentas(fichero);
                    Menu.menuBajas(cuentas, fichero, lee);
                    break;
                case 4:
                    cuentas = Consultar.extraerCuentas(fichero);
                    Modificar.direccionCliente(fichero, Crear.pedirDniExistente(cuentas, lee), lee);
                    System.out.println("Dirección modificada correctamente");
                    break;
                case 5:
                    cuentas = Consultar.extraerCuentas(fichero);
                    Menu.menuConsultas(cuentas, fichero, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }     
}
