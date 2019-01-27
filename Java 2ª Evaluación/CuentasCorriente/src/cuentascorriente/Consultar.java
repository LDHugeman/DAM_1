package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import obxetos.Cliente;
import obxetos.Cuenta;
import obxetos.CuentaCorriente;
import obxetos.Movimiento;

/**
 *
 * @author Luis David
 */
public class Consultar {

    public static boolean existeCuenta(String numeroCuenta, ArrayList<Cuenta> cuentas) {
        return encontrarCuenta(numeroCuenta, cuentas) != null;
    }

    public static boolean existeCliente(String dni, ArrayList<Cliente> clientes) {
        return encontrarCliente(clientes, dni) != null;
    }

    public static Cuenta encontrarCuenta(String numeroCuenta, ArrayList<Cuenta> cuentas) {
        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroCuenta)) {
                cuentaEncontrada = cuenta;
            }
        }
        return cuentaEncontrada;
    }

    public static Cliente encontrarCliente(ArrayList<Cliente> clientes, String dniBuscado) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDNI().equals(dniBuscado)) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    public static ArrayList<Cliente> obterClientesContaMaiordeCantidade(ArrayList<Cuenta> cuentas, double cantidade) {
        ArrayList<Cliente> clientesAtopados = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof CuentaCorriente) {
                if (((CuentaCorriente) cuenta).getSaldoActual() > cantidade) {
                    clientesAtopados.addAll(cuenta.getClientes());
                }
            }
        }
        return clientesAtopados;
    }

    public static ArrayList<Cliente> obterClientesNumerosVermellos(ArrayList<Cuenta> cuentas) {
        ArrayList<Cliente> clientesAtopados = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof CuentaCorriente) {
                if (((CuentaCorriente) cuenta).getSaldoActual() < 0) {
                    clientesAtopados.addAll(cuenta.getClientes());
                }
            }
        }
        return clientesAtopados;
    }

    public static double obterSaldoDeCliente(String dni, ArrayList<Cuenta> cuentas) {
        double saldo = 0;
        for (Cuenta cuenta : cuentas) {
            if (cuenta instanceof CuentaCorriente) {
                for (Cliente cliente : cuenta.getClientes()) {
                    if (cliente.getDNI().equals(dni)) {
                        saldo += ((CuentaCorriente) cuenta).getSaldoActual();
                    }
                }
            }

        }
        return saldo;
    }

    public static double obterSaldoMedioDeClientes(ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) {
        double saldoTotalClientes = 0;
        for (Cliente cliente : clientes) {
            saldoTotalClientes += obterSaldoDeCliente(cliente.getDNI(), cuentas);
        }
        return saldoTotalClientes / clientes.size();
    }

    public static ArrayList<Movimiento> obtenerMovimientosCuenta(BufferedReader lee, ArrayList<Cuenta> cuentas) throws IOException {
        String numeroCuenta = Crear.pedirNumeroCuenta(lee);
        Cuenta cuenta = encontrarCuenta(numeroCuenta, cuentas);
        if (cuenta != null) {
            if (cuenta instanceof CuentaCorriente) {
                return ((CuentaCorriente) cuenta).getMovimientos();
            }else{
                System.err.printf("No es una cuenta corriente.%n");
            }
        }else{
            System.err.printf("No existe esa cuenta %n");
        }
        return null;
    }
    
    public static ArrayList<Movimiento> obtenerMovimientosEntreFechas(ArrayList<Movimiento> movimientos, BufferedReader lee)throws IOException, ParseException{
        System.out.printf("Fecha inicial: ");     
        Date fechaInicial = Crear.obtenerFecha(lee.readLine());
        System.out.printf("Fecha final: ");     
        Date fechaFinal = Crear.obtenerFecha(lee.readLine());
        ArrayList<Movimiento> movimientosFiltrados = new ArrayList<>();
        for(Movimiento movimiento:movimientos){
            if(movimiento.getFechaMovimiento().getTime()>fechaInicial.getTime() && movimiento.getFechaMovimiento().getTime()<fechaFinal.getTime()){
                movimientosFiltrados.add(movimiento);
            }
        }
        return movimientosFiltrados;       
    }
}
