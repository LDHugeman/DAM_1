package clientesbancarios;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Introducir {
    
    public static Cliente[] obterClientes(BufferedReader lee) throws IOException {
        int numeroClientes = obterNumeroClientesACargar(lee);
        Cliente[] clientes = new Cliente[numeroClientes];
        for (int i = 0; i < clientes.length; i++) {
            String nombreCliente = obterNombreCliente(lee);
            clientes[i] = new Cliente(nombreCliente, obterSaldoCliente(lee, nombreCliente));
        }
        return clientes;
    }

    private static int obterNumeroClientesACargar(BufferedReader lee) throws IOException {
        System.out.printf("¿Cuántos clientes desea introducir?%n");
        return Integer.parseInt(lee.readLine());
    }

    private static String obterNombreCliente(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del cliente: ");
        return lee.readLine();
    }

    private static float obterSaldoCliente(BufferedReader lee, String nombreCliente) throws IOException {
        System.out.printf("Saldo de %s: ", nombreCliente);
        return Float.parseFloat(lee.readLine());
    }
}
