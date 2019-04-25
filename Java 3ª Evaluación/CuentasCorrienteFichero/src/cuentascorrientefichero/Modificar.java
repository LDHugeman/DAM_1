package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;

/**
 *
 * @author David
 */
public class Modificar {

    public static void agregarMovimiento(File fichero, CuentaCorriente cuenta, BufferedReader lee) {
        File temporal = Archivo.obtenerTemporal(fichero, cuenta);
        cuenta.agregarNuevoMovimiento(lee);
        Altas.cuenta(temporal, cuenta);
        fichero.delete();
        temporal.renameTo(fichero);
    }
    
    public static void agregarCliente(File fichero, Cuenta cuenta, BufferedReader lee){
        File temporal = Archivo.obtenerTemporal(fichero, cuenta);
        Cliente cliente = Consultar.obtenerCliente(lee, fichero, cuenta);
        cuenta.getClientes().add(cliente);
        cliente.getCuentas().add(cuenta);
        Altas.cuenta(temporal, cuenta);
        fichero.delete();
        temporal.renameTo(fichero);
    }
    
    public static void direccionCliente(File fichero, String dni, BufferedReader lee){
        ArrayList<Cuenta> cuentas = Consultar.extraerCuentas(fichero);
        Cliente clienteEncontrado = Consultar.encontrarClientePorDni(fichero, dni);
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
            ObjectOutputStream flujoEscritura = Archivo.crearFichero(fichero);        
            for(Cuenta cuenta : cuentas){ //Estase a sobreescribir o archivo con todas as cuentas modificadas
                try {
                    for(Cliente cliente:cuenta.getClientes()){
                        if(cliente.getDni().equalsIgnoreCase(dni)){
                            cliente.setDireccion(direccion);
                        }
                    }
                    flujoEscritura.writeObject(cuenta);
                } catch (IOException excepcion) {
                    System.out.println("Error en reescritura");
                }
            }
            Archivo.cerrarFlujo(flujoEscritura);
        }       
    }
}
