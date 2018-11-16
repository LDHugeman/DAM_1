package clientesbancarios2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class ClientesBancarios2 {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader (new InputStreamReader(System.in));
        String[] clientes = new String [4];
        float[] saldos = new float [4];
        String [] clientesSaldoPositivo = new String [4];
        float[] saldosPositivos = new float [4];;
        String[] clientesSaldoNegativo = new String [4];
        float[] saldosNegativos = new float [4];
        String[] clientesSaldoNulo = new String [4];
        float[] saldosNulos = new float [4];
        byte opcionSeleccionada = 0;
        do{            
           opcionSeleccionada = Menu.seleccionarOpcion(lee);
           switch(opcionSeleccionada){
               case 1:
                 Introducir.obterNombresClientes(lee, clientes);
                 Introducir.obterSaldosClientes(lee, saldos);
                 break;
           }
            
        }while(opcionSeleccionada!=6);
    }
}
