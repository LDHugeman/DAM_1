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
 * @author Luis David
 */
public class Crear {
    public static CuentaCorriente nuevaCuentaCorriente(String numeroCuenta, BufferedReader lee, Cliente nuevoCliente) throws IOException{
        String sucursal = pedirSucursal(lee);
        System.out.println("Inserte saldo actual");
        double saldo = Double.parseDouble(lee.readLine());
        return new CuentaCorriente(numeroCuenta, sucursal, nuevoCliente, saldo);
    }
    
    public static Cliente crearNuevoCliente(String dni, BufferedReader lee, ArrayList<Cliente> clientes) throws IOException{
        System.out.println("Inserte o nome do cliente");
        String nombre = lee.readLine();
        System.out.println("Inserte direccion do cliente");
        String direccion = lee.readLine();
        Cliente nuevoCliente = new Cliente(dni, nombre, direccion);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }
    
    public static CuentaPlazo nuevaCuentaPlazo(String numeroCuenta, BufferedReader lee, Cliente primerCliente) throws IOException{
        String sucursal = pedirSucursal(lee);
        System.out.println("Inserte intereses");
        float intereses = Float.parseFloat(lee.readLine());
        System.out.println("Inserte fecha de vencemento");
        String fechaVencimiento = lee.readLine();
        System.out.println("Inserte deposito plazo");
        long depositoPlazo = Long.parseLong(lee.readLine());
        return new CuentaPlazo(numeroCuenta, sucursal, primerCliente, intereses, fechaVencimiento, depositoPlazo);
    }
    
    public static String pedirNuevoNumeroCuenta(ArrayList<Cuenta> cuentas, BufferedReader lee) throws IOException{
        String nuevoNumero;
        boolean estaCuentaRepetida = false;
        do {            
            nuevoNumero = pedirNumeroCuenta(lee);
            if(Consultar.existeCuenta(nuevoNumero, cuentas)){
                estaCuentaRepetida = true;
                System.out.println("Ya existe una cuenta con ese numero");
            }
        } while (estaCuentaRepetida);
        return nuevoNumero;
    }
    
        public static String pedirNuevoDNI(ArrayList<Cliente> clientes, BufferedReader lee) throws IOException{
        String nuevoNumero;
        boolean estaClienteRepetido = false;
        do {            
            nuevoNumero = pedirDni(lee);
            if(Consultar.existeCliente(nuevoNumero, clientes)){
                estaClienteRepetido = true;
                System.out.println("Ya existe un cliente con ese dni");
            }
        } while (estaClienteRepetido);
        return nuevoNumero;
    }
    
    public static String pedirNumeroCuenta(BufferedReader lee) throws IOException{
        System.out.println("Inserte Numero de cuenta");
        return lee.readLine();
    }
    
    public static String pedirSucursal(BufferedReader lee) throws IOException{
        System.out.println("Inserte sucursal");
        return lee.readLine();
    }
    
    public static String pedirDni(BufferedReader lee)throws IOException{
        System.out.println("Inserte o dni do cliente");
        return lee.readLine();
    }
    
    public static ArrayList<Cliente> crearNovosClientes (BufferedReader lee, ArrayList<Cliente> clientes) throws IOException{
        ArrayList<Cliente> novosClientes= new ArrayList<>();
        String nuevoDni = Crear.pedirNuevoDNI(clientes, lee);
        novosClientes.add(crearNuevoCliente(nuevoDni, lee, clientes));
        byte opcion = 0;
        do {            
            System.out.println("Desexa insertar outro novo cliente");
            System.out.println("1 - si");
            System.out.println("0 - non");
            if(opcion == 1){
                nuevoDni = Crear.pedirNuevoDNI(clientes, lee);
                novosClientes.add(crearNuevoCliente(nuevoDni, lee, clientes));
            }
        } while (opcion != 0);
        return novosClientes;
    }
}
