package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Cuenta;

/**
 *
 * @author David
 */
public class Bajas {

    public static void cuenta(ArrayList<Cuenta> cuentas, File fichero, Cuenta cuentaEncontrada) {
        cuentas.remove(cuentaEncontrada);
        Archivo.reescribirFichero(fichero, cuentas);
    }

    public static void cliente(ArrayList<Cuenta> cuentas, File fichero, String dni, BufferedReader lee) {
        Cuenta cuentaEncontrada = Consultar.encontrarCuentaPorNumero(cuentas, Crear.pedirNumeroCuentaExistente(cuentas, lee));
        Cliente clienteEncontrado = null;
        for (Cliente cliente : cuentaEncontrada.getClientes()) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                clienteEncontrado = cliente;
            }
        }
        if (clienteEncontrado != null) {
            Visualizar.mostrarCliente(clienteEncontrado);
            System.out.println("¿Es este el cliente que desea eliminar?");
            System.out.println("[1] Si");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            byte opcion = Pedir.numeroByte(lee);
            if (opcion == 1) {
                cuentaEncontrada.getClientes().remove(clienteEncontrado);                             
                Archivo.reescribirFichero(fichero, cuentas);
                System.out.println("Cliente eliminado");
            } else {
                System.out.println("Operación cancelada");
            }
        }
    }
}
