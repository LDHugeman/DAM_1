package cuentascorrientefichero;

import excepciones.Validar;
import java.io.BufferedReader;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import objetos.Cliente;
import objetos.CuentaCorriente;
import objetos.CuentaPlazo;
import objetos.Movimiento;

/**
 *
 * @author David
 */
public class Crear {

    public static CuentaCorriente nuevaCuentaCorriente(File fichero, BufferedReader lee) {
        String numero = pedirNuevoNumeroCuenta(fichero, lee);
        System.out.printf("Sucursal: ");
        String sucursal = Pedir.texto(lee);
        System.out.printf("Saldo actual: ");
        double saldoActual = Pedir.numeroRealDouble(lee);
        return new CuentaCorriente(numero, sucursal, saldoActual);
    }

    public static CuentaPlazo nuevaCuentaPlazo(File fichero, BufferedReader lee) {
        String numero = pedirNuevoNumeroCuenta(fichero, lee);
        System.out.printf("Sucursal: ");
        String sucursal = Pedir.texto(lee);
        System.out.printf("Intereses");
        float intereses = Pedir.numeroRealFloat(lee);
        System.out.printf("Fecha de vencimiento (dd/MM/yyyy): ");
        Date fechaVencimiento = obtenerFecha(Pedir.texto(lee));
        System.out.printf("Deposito a plazo: ");
        long depositoPlazo = Pedir.numeroLong(lee);
        return new CuentaPlazo(numero, sucursal, intereses, fechaVencimiento, depositoPlazo);
    }
    
    public static Cliente nuevoCliente(BufferedReader lee, String dni, File fichero){
        if (dni == null){
            dni = pedirNuevoDni(fichero, lee);
        }
        System.out.printf("Nombre: ");
        String nombre = Pedir.texto(lee);
        System.out.printf("Dirección: ");
        String direccion = Pedir.texto(lee);
        return new Cliente(dni, nombre, direccion);
    }
    
    public static Movimiento nuevoMovimiento(String numeroCuenta, double saldoActualCuenta, BufferedReader lee){
        String numero = numeroCuenta;
        System.out.printf("Cantidad: ");
        float cantidad = Consultar.obtenerCantidadMovimiento(lee, Menu.seleccionarTipoMovimiento(lee));
        double saldoActual = saldoActualCuenta;
        return new Movimiento(numero, cantidad, saldoActual);
    }

    public static Date obtenerFecha(String texto) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        boolean fechaEsValida = true;
        try {
            do {
                fecha = formatoFecha.parse(texto);
            } while (!fechaEsValida);
        } catch (ParseException excepcion) {
            System.out.println("Fecha incorrecta");
            fechaEsValida = false;
        }
        return fecha;
    }

    public static String pedirNuevoNumeroCuenta(File fichero, BufferedReader lee) {
        String numero = "";
        do {
            System.out.printf("Número: ");
            numero = Pedir.texto(lee);
        } while (!Validar.esNuevoNumeroCuentaValido(fichero, numero));
        return numero;
    }
    
    public static String pedirNumeroCuentaExistente(File fichero, BufferedReader lee) {
        String numero = "";
        do {
            System.out.printf("Número: ");
            numero = Pedir.texto(lee);
        } while (!Validar.esNumeroCuentaExistenteValido(fichero, numero));
        return numero;
    }
    
    public static String pedirDni(BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esDniValido(dni));
        return dni;
    }
    
    public static String pedirNuevoDni(File fichero, BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esNuevoDniValido(fichero, dni));
        return dni;
    }
    
    public static String pedirDniExistente(File fichero, BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esDniExistenteValido(fichero, dni));
        return dni;
    }
}
