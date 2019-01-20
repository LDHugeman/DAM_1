/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

}
