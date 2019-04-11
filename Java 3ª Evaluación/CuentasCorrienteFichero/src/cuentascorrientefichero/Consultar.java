package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;
import objetos.Movimiento;

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
    
    public static boolean existeCuentaPorNumero(File fichero, String numero) {
        return encontrarCuentaPorNumero(fichero, numero) != null;
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

    public static Cliente encontrarClientePorDniMemoria(Cuenta cuenta, String dni) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : cuenta.getClientes()) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    public static boolean existeClientePorDniMemoria(Cuenta cuenta, String dni) {
        return encontrarClientePorDniMemoria(cuenta, dni) != null;
    }

    public static Cliente obtenerCliente(BufferedReader lee, File fichero, Cuenta cuenta) {
        String dni = Crear.pedirDni(lee);
        Cliente cliente;
        if (existeClientePorDni(fichero, dni)) {
            cliente = Consultar.encontrarClientePorDni(fichero, dni);
        } else if (existeClientePorDniMemoria(cuenta, dni)) {
            cliente = Consultar.encontrarClientePorDniMemoria(cuenta, dni);
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

    public static ArrayList<Cuenta> extraerCuentas(File fichero) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        try {
            while (true) {
                Cuenta actual = (Cuenta) flujoLectura.readObject();
                cuentas.add(actual);
            }
        } catch (EOFException exception) {
        } catch (IOException exception) {
            System.out.println("Error en lectura (EC)");
        } catch (ClassNotFoundException exception) {
            System.out.println("Clase no encontrada (EC)");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return cuentas;
    }

    public static ArrayList<Cuenta> encontrarCuentasDeCliente(File fichero, Cliente clienteEncontrado) {
        ArrayList<Cuenta> cuentas = extraerCuentas(fichero);
        ArrayList<Cuenta> cuentasEncontradas = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            for (Cliente cliente : cuenta.getClientes()) {
                if (cliente.getDni().equalsIgnoreCase(clienteEncontrado.getDni())) {
                    cuentasEncontradas.add(cuenta);
                }
            }
        }
        return cuentasEncontradas;
    }

    public static ArrayList<Movimiento> obtenerMovimientosEntreFechas(ArrayList<Movimiento> movimientos, BufferedReader lee) {
        System.out.printf("Fecha inicial (dd/MM/yyyy): ");
        Date fechaInicial = Crear.obtenerFecha(lee);
        System.out.printf("Fecha final (dd/MM/yyyy): ");
        Date fechaFinal = Crear.obtenerFecha(lee);
        ArrayList<Movimiento> movimientosFiltrados = new ArrayList<>();
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getFechaMovimiento().getTime() > fechaInicial.getTime() && movimiento.getFechaMovimiento().getTime() < fechaFinal.getTime()) {
                movimientosFiltrados.add(movimiento);
            }
        }
        return movimientosFiltrados;
    }
}
