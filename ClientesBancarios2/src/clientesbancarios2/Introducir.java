package clientesbancarios2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {

    private static String obterNombreCliente(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del cliente: ");
        return lee.readLine();
    }

    private static float obterSaldoCliente(BufferedReader lee, String nombreCliente) throws IOException {
        System.out.printf("Saldo de: %s", nombreCliente);
        return Float.parseFloat(lee.readLine());
    }

    public static String[] obterNombresClientes(BufferedReader lee, String[] clientes) throws IOException {
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = obterNombreCliente(lee);
        }
        return clientes;
    }

    public static float[] obterSaldosClientes(BufferedReader lee, float[] saldos)throws IOException{
        for(int i=0; i<saldos.length; i++){
            String nombreCliente = obterNombreCliente(lee);
            saldos[i] = obterSaldoCliente(lee, nombreCliente);
        }
        return saldos;
    }
}
