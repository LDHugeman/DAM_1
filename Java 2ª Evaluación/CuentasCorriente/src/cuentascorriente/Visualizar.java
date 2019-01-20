
package cuentascorriente;

import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;
import obxetos.CuentaCorriente;
import obxetos.CuentaPlazo;

/**
 *
 * @author Luis David
 */
public class Visualizar {

    public static void mostrarCliente(Cliente cliente) {
        System.out.println("-------------------------------------------");
        System.out.println("DNI: " + cliente.getDNI());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Direccion: " + cliente.getDireccion());
        System.out.println("-------------------------------------------");
    }

    public static void mostrarClientes(ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            mostrarCliente(cliente);
        }
    }
    
    public static void mostrarCuentas(ArrayList<Cuenta>cuentas){
        for(Cuenta cuenta : cuentas){
            mostrarCuenta(cuenta);
        }
    }

    public static void mostrarCuenta(Cuenta cuenta) {
        System.out.println("----------------------------------------");
        System.out.println("Numero de cuenta: " + cuenta.getNumero());
        System.out.println("Sucursal: " + cuenta.getSucursal());
        if (cuenta instanceof CuentaCorriente) {
            System.out.println("Saldo Actual: " + ((CuentaCorriente) cuenta).getSaldoActual());
        } else if (cuenta instanceof CuentaPlazo) {
            System.out.println("Deposito Plazo: " + ((CuentaPlazo) cuenta).getDepositoPlazo());
            System.out.println("Fecha de vencimiento: " + ((CuentaPlazo) cuenta).getFechaVencimiento());
            System.out.println("Intereses: " + ((CuentaPlazo) cuenta).getIntereses());
        }
        System.out.println("---------------------------------------");

    }
}
