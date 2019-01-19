/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;

/**
 *
 * @author macbookair
 */
public class Altas {

    public static void altaCuentaCorriente(ArrayList<Cuenta>cuentasGuardadas, ArrayList<Cliente> clientesGardados, BufferedReader lee) throws IOException {
        Cliente primerCliente = obtenerPrimerCliente(clientesGardados, lee);
        String numeroCuenta = Crear.pedirNuevoNumeroCuenta(cuentasGuardadas, lee);
        Cuenta nuevaCuenta = Crear.nuevaCuentaCorriente(numeroCuenta, lee, primerCliente);
        cuentasGuardadas.add(nuevaCuenta);
    }

    public static void altaCuentaPlazo(ArrayList<Cuenta> cuentasGuardadas ,ArrayList<Cliente> clientesGuardados, BufferedReader lee) throws IOException{
        Cliente primerCliente = obtenerPrimerCliente(clientesGuardados, lee);
        String nuevoNumeroCuenta = Crear.pedirNuevoNumeroCuenta(cuentasGuardadas, lee);
        Cuenta nuevaCuenta = Crear.nuevaCuentaPlazo(nuevoNumeroCuenta, lee, primerCliente);
        cuentasGuardadas.add(nuevaCuenta);
    }

    public static Cliente obtenerPrimerCliente(ArrayList<Cliente> clientes, BufferedReader lee) throws IOException {
        Cliente clienteAsociado;
        if (clientes.size() > 0) {
            clienteAsociado = escojerCliente(clientes, lee);
        } else {
            System.out.println("Necesita crear polo menos un cliente para engadilo a nova conta");
            clienteAsociado = Crear.crearNuevoCliente(Crear.pedirNuevoDNI(clientes, lee), lee, clientes);
        }
        return clienteAsociado;
    }

    public static Cliente escojerCliente(ArrayList<Cliente> clientes, BufferedReader lee) throws IOException {
        Cliente clienteEscogido;
        System.out.println("Escolla un dni dun dos clientes para engadilo a nova conta, ou pulse 0 para crear un novo");
        String opcion = lee.readLine();
        if (!opcion.equals("0")) {
            clienteEscogido = Consultar.encontrarCliente(clientes, opcion);
        } else {
            clienteEscogido = Crear.crearNuevoCliente(Crear.pedirNuevoDNI(clientes, lee), lee, clientes);
        }
        return clienteEscogido;
    }

}
