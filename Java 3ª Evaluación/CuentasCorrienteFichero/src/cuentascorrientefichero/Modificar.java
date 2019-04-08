package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
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
}
