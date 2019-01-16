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
import obxetos.CuentaCorriente;
import obxetos.CuentaPlazo;


/**
 *
 * @author macbookair
 */
public class Crear {
    public static CuentaCorriente nuevaCuentaCorriente(BufferedReader lee, ArrayList<Cliente>nuevosClientes) throws IOException{
        String numeroCuenta = pedirNumeroCuenta(lee);
        String sucursal = pedirSucursal(lee);
        System.out.println("Inserte saldo actual");
        double saldo = Double.parseDouble(lee.readLine());
        return new CuentaCorriente(numeroCuenta, sucursal, nuevosClientes, saldo);
    }
    
    public static Cliente nuevoCliente(BufferedReader lee, ArrayList<Cliente> clientes) throws IOException{
        System.out.println("Inserte o dni do cliente");
        String dni = lee.readLine();
        System.out.println("Inserte o nome do cliente");
        String nombre = lee.readLine();
        System.out.println("Inserte direccion do cliente");
        String direccion = lee.readLine();
        Cliente novoCliente = new Cliente(dni, nombre, direccion);
        clientes.add(novoCliente);
        return novoCliente;
    }
    
    public static CuentaPlazo nuevaCuentaPlazo(BufferedReader lee, ArrayList<Cliente>nuevosClientes) throws IOException{
        String numeroCuenta = pedirNumeroCuenta(lee);
        String sucursal = pedirSucursal(lee);
        System.out.println("Inserte intereses");
        float intereses = Float.parseFloat(lee.readLine());
        System.out.println("Inserte fecha de vencemento");
        String fechaVencimiento = lee.readLine();
        System.out.println("Inserte deposito plazo");
        long depositoPlazo = Long.parseLong(lee.readLine());
        return new CuentaPlazo(numeroCuenta, sucursal, nuevosClientes, intereses, fechaVencimiento, depositoPlazo);
    }
    
    public static String pedirNumeroCuenta(BufferedReader lee) throws IOException{
        System.out.println("Inserte Numero de cuenta");
        return lee.readLine();
    }
    
    public static String pedirSucursal(BufferedReader lee) throws IOException{
        System.out.println("Inserte sucursal");
        return lee.readLine();
    }
    
    public static ArrayList<Cliente> crearNovosClientes (BufferedReader lee, ArrayList<Cliente> clientes) throws IOException{
        ArrayList<Cliente> novosClientes= new ArrayList<>();
        novosClientes.add(nuevoCliente(lee, clientes));
        byte opcion = 0;
        do {            
            System.out.println("Desexa insertar outro novo cliente");
            System.out.println("1 - si");
            System.out.println("0 - non");
            if(opcion == 1){
                novosClientes.add(nuevoCliente(lee, clientes));
            }
        } while (opcion != 0);
        return novosClientes;
    }
}
