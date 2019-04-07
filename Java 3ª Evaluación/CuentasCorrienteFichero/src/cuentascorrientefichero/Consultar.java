package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;

/**
 *
 * @author David
 */
public class Consultar {
    
    public static Cuenta encontrarCuentaPorNumero(File fichero, String numero) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        Cuenta cuentaEncontrada = null;
        try {
            do {
                Cuenta cuenta = (Cuenta) flujoLectura.readObject();
                if (cuenta.getNumero().equalsIgnoreCase(numero)) {
                        cuentaEncontrada = cuenta;
                    }
            } while (true);
        } catch (EOFException excepcion) {
        } catch (ClassNotFoundException excepcion) {
            System.out.println("Clase no encontrada");
        } catch (IOException excepcion) {
            System.out.println("Error al leer el fichero");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return cuentaEncontrada;
    }

    public static CuentaCorriente encontrarCuentaCorrientePorNumero(File fichero, String numero) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        CuentaCorriente cuentaCorrienteEncontrada = null;
        try {
            do {
                Cuenta cuenta = (Cuenta) flujoLectura.readObject();
                if (cuenta instanceof CuentaCorriente) {
                    if (cuenta.getNumero().equalsIgnoreCase(numero)) {
                        cuentaCorrienteEncontrada = (CuentaCorriente) cuenta;
                    }
                }
            } while (true);
        } catch (EOFException excepcion) {
        } catch (ClassNotFoundException excepcion) {
            System.out.println("Clase no encontrada");
        } catch (IOException excepcion) {
            System.out.println("Error al leer el fichero");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return cuentaCorrienteEncontrada;
    }

    public static boolean existeCuentaCorrientePorNumero(File fichero, String numero) {
        return encontrarCuentaCorrientePorNumero(fichero, numero) != null;
    }

    public static Cliente encontrarClientePorDni(File fichero, String dni) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        Cliente clienteEncontrado = null;
        try {
            do {
                Cuenta cuenta = (Cuenta) flujoLectura.readObject();
                for (Cliente cliente : cuenta.getClientes()) {
                    if (cliente.getDni().equalsIgnoreCase(dni)) {
                        clienteEncontrado = cliente;
                    }
                }
            } while (true);
        } catch (EOFException excepcion) {
        } catch (ClassNotFoundException excepcion) {
            System.out.println("Clase no encontrada");
        } catch (IOException excepcion) {
            System.out.println("Error al leer el archivo");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return clienteEncontrado;
    }

    public static boolean existeClientePorDni(File fichero, String dni) {
        return encontrarClientePorDni(fichero, dni) != null;
    }
    
    public static Cliente obtenerCliente(BufferedReader lee, File fichero) {
        String dni = Crear.pedirDni(lee);
        Cliente cliente;
        if (existeClientePorDni(fichero, dni)){
            cliente = Consultar.encontrarClientePorDni(fichero, dni);
        } else {
            cliente = Crear.nuevoCliente(lee, dni, fichero);
        }
        return cliente;    
    }
    
    public static float obtenerCantidadMovimiento(BufferedReader lee, byte tipoMovimiento) {
        System.out.printf("Cantidad: ");
        float cantidad = Pedir.numeroRealFloat(lee);
        if (tipoMovimiento == 1) {
            return cantidad;
        } else {
            return cantidad - cantidad * 2;
        }
    }
}
