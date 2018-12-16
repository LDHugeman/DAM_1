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
        System.out.printf("Saldo de %s: ", nombreCliente);
        return Float.parseFloat(lee.readLine());
    }
    
    public static String obterNombreBusqueda(BufferedReader lee)throws IOException{
        System.out.printf("Nombre del cliente: ");
        return lee.readLine();
    }
    
    public static void obterClientes(BufferedReader lee, String[] nombreClientes, float[]saldos)throws IOException{
        for(int i=0; i<nombreClientes.length;i++) {
            String nombreCliente = obterNombreCliente(lee);
            nombreClientes[i] = nombreCliente;
            saldos[i]= obterSaldoCliente(lee, nombreCliente);
        }
    }
}
