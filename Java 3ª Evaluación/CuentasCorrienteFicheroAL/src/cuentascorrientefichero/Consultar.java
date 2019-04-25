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

    public static Cuenta encontrarCuentaPorNumero(ArrayList<Cuenta> cuentas, String numero) {
        Cuenta cuentaEncontrada = null;
        for(Cuenta cuenta:cuentas){
            if(cuenta.getNumero().equalsIgnoreCase(numero)){
                cuentaEncontrada = cuenta;
            }
        }
        return cuentaEncontrada;
    }
    
    public static boolean existeCuentaPorNumero(ArrayList<Cuenta> cuentas, String numero) {
        return encontrarCuentaPorNumero(cuentas, numero) != null;
    }

    public static CuentaCorriente encontrarCuentaCorrientePorNumero(ArrayList<Cuenta> cuentas, String numero) {
        CuentaCorriente cuentaCorrienteEncontrada = null;
        for(Cuenta cuenta:cuentas){
            if(cuenta instanceof CuentaCorriente){
                if(cuenta.getNumero().equalsIgnoreCase(numero)){
                    cuentaCorrienteEncontrada = (CuentaCorriente) cuenta;
                }
            }
        }           
        return cuentaCorrienteEncontrada;
    }

    public static boolean existeCuentaCorrientePorNumero(ArrayList<Cuenta> cuentas, String numero) {
        return encontrarCuentaCorrientePorNumero(cuentas, numero) != null;
    }

    public static Cliente encontrarClientePorDni(ArrayList<Cuenta> cuentas, String dni) {
        Cliente clienteEncontrado = null;
        for(Cuenta cuenta:cuentas){
            for(Cliente cliente:cuenta.getClientes()){
                if(cliente.getDni().equalsIgnoreCase(dni)){
                    clienteEncontrado = cliente;
                }
            }
        }      
        return clienteEncontrado;
    }

    public static boolean existeClientePorDni(ArrayList<Cuenta> cuentas, String dni) {
        return encontrarClientePorDni(cuentas, dni) != null;
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

    public static Cliente obtenerCliente(BufferedReader lee, ArrayList<Cuenta> cuentas, Cuenta cuenta) {
        String dni = Crear.pedirDni(lee);
        Cliente cliente;
        if (existeClientePorDni(cuentas, dni)) {
            cliente = Consultar.encontrarClientePorDni(cuentas, dni);
        } else if (existeClientePorDniMemoria(cuenta, dni)) {
            cliente = Consultar.encontrarClientePorDniMemoria(cuenta, dni);
        } else {
            cliente = Crear.nuevoCliente(lee, dni, cuentas);
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
                cuentas = (ArrayList<Cuenta>) flujoLectura.readObject();              
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
