package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;

/**
 *
 * @author David
 */
public class Modificar {

    public static void agregarMovimiento(ArrayList<Cuenta> cuentas, File fichero, CuentaCorriente cuenta, BufferedReader lee) {
        cuenta.agregarNuevoMovimiento(lee);
        Archivo.reescribirFichero(fichero, cuentas);
    }
    
    public static void agregarCliente(ArrayList<Cuenta> cuentas, File fichero, Cuenta cuenta, BufferedReader lee){
        Cliente cliente = Consultar.obtenerCliente(lee, cuentas, cuenta);
        cuenta.getClientes().add(cliente);
        Archivo.reescribirFichero(fichero, cuentas);
    }
    
    public static void direccionCliente(File fichero, String dni, BufferedReader lee){
        ArrayList<Cuenta> cuentas = Consultar.extraerCuentas(fichero);
        Cliente clienteEncontrado = Consultar.encontrarClientePorDni(cuentas, dni);
        Visualizar.mostrarCliente(clienteEncontrado);
        System.out.println("¿Es este el cliente al que desea modificar la dirección?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        System.out.printf("Seleccione una opción: ");
        byte opcion = Pedir.numeroByte(lee);
        if(opcion == 1){
            System.out.println("--- Introduzca la nueva dirección para el cliente ---");
            System.out.printf("Dirección: ");
            String direccion = Pedir.texto(lee);
            clienteEncontrado.setDireccion(direccion);
            for (Cuenta cuenta : cuentas){
                for (Cliente cliente : cuenta.getClientes()){
                    if (cliente.getDni().equalsIgnoreCase(clienteEncontrado.getDni())){
                        cliente.setDireccion(direccion);
                    }
                }
            }
            Archivo.reescribirFichero(fichero, cuentas);            
        }       
    }
}
