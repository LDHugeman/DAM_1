package cuentascorrientefichero;

import java.util.ArrayList;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;
import objetos.CuentaPlazo;
import objetos.Movimiento;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrarCuenta(Cuenta cuenta) {
        System.out.println("-------------------------------------------");
        System.out.println("Número: " + cuenta.getNumero());
        System.out.println("Sucursal: " + cuenta.getSucursal());
        if (cuenta instanceof CuentaCorriente) {
            System.out.println("Saldo actual: " + ((CuentaCorriente) cuenta).getSaldoActual());

        } else if (cuenta instanceof CuentaPlazo) {
            System.out.println("Intereses: " + ((CuentaPlazo) cuenta).getIntereses());
            System.out.println("Fecha de vencimiento: " + ((CuentaPlazo) cuenta).getStringFechaVencimieto());
            System.out.println("Intereses: " + ((CuentaPlazo) cuenta).getIntereses());
        }
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarCuentas (ArrayList<Cuenta> cuentas){
        for(Cuenta cuenta:cuentas){
            mostrarCuenta(cuenta);
        }
    }

    public static void mostrarCliente(Cliente cliente) {
        System.out.println("-------------------------------------------");
        System.out.println("Dni: " + cliente.getDni());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarClientes (ArrayList<Cliente> clientes){
        for(Cliente cliente:clientes){
            mostrarCliente(cliente);
        }
    }

    public static void mostrarMovimiento(Movimiento movimiento) {
        System.out.println("-------------------------------------------");
        System.out.println("Número de cuenta: " + movimiento.getNumero());
        System.out.println("Fecha del movimiento: " + movimiento.getStringFechaMovimiento());
        System.out.println("Hora del movimiento: " + movimiento.getStringHora());
        System.out.println("Cantidad a ingresar o retirar: " + movimiento.getCantidad());
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarMovimientos(ArrayList<Movimiento> movimientos){
        for(Movimiento movimiento:movimientos){
            mostrarMovimiento(movimiento);
        }
    }
}
