package cuentascorrientefichero;

import excepciones.Validar;
import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;
import objetos.CuentaPlazo;
import objetos.Movimiento;

/**
 *
 * @author David
 */
public class Crear {

    public static CuentaCorriente nuevaCuentaCorriente(ArrayList<Cuenta> cuentas, BufferedReader lee) {
        String numero = pedirNuevoNumeroCuenta(cuentas, lee);
        System.out.printf("Sucursal: ");
        String sucursal = Pedir.texto(lee);
        System.out.printf("Saldo actual: ");
        double saldoActual = Pedir.numeroRealDouble(lee);
        return new CuentaCorriente(numero, sucursal, saldoActual);
    }

    public static CuentaPlazo nuevaCuentaPlazo(ArrayList<Cuenta> cuentas, BufferedReader lee) {
        String numero = pedirNuevoNumeroCuenta(cuentas, lee);
        System.out.printf("Sucursal: ");
        String sucursal = Pedir.texto(lee);
        System.out.printf("Intereses: ");
        float intereses = Pedir.numeroRealFloat(lee);
        System.out.printf("Fecha de vencimiento (dd/MM/yyyy): ");
        Date fechaVencimiento = obtenerFecha(lee);
        System.out.printf("Deposito a plazo: ");
        long depositoPlazo = Pedir.numeroLong(lee);
        return new CuentaPlazo(numero, sucursal, intereses, fechaVencimiento, depositoPlazo);
    }

    public static Cliente nuevoCliente(BufferedReader lee, String dni, ArrayList<Cuenta> cuentas) {
        if (dni == null) {
            dni = pedirNuevoDni(cuentas, lee);
        }
        System.out.printf("Nombre: ");
        String nombre = Pedir.texto(lee);
        System.out.printf("Dirección: ");
        String direccion = Pedir.texto(lee);
        return new Cliente(dni, nombre, direccion);
    }

    public static Movimiento nuevoMovimiento(String numeroCuenta, double saldoActualCuenta, BufferedReader lee) {
        String numero = numeroCuenta;
        System.out.printf("Cantidad: ");
        float cantidad = Consultar.obtenerCantidadMovimiento(lee, Menu.seleccionarTipoMovimiento(lee));
        double saldoActual = saldoActualCuenta;
        return new Movimiento(numero, cantidad, saldoActual);
    }

    public static Date obtenerFecha(BufferedReader lee) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        boolean esFechaValida;
        do {
            try {
                esFechaValida = true;
                String texto = Pedir.texto(lee);
                fecha = formatoFecha.parse(texto);               
            } catch (ParseException excepcion) {
                System.out.println("Fecha incorrecta");
                System.out.printf("Vuelva a introducirla: ");
                esFechaValida = false;
            }
        } while (!esFechaValida);
        return fecha;
    }

    public static String pedirNuevoNumeroCuenta(ArrayList<Cuenta> cuentas, BufferedReader lee) {
        String numero = "";
        do {
            System.out.printf("Número: ");
            numero = Pedir.texto(lee);
        } while (!Validar.esNuevoNumeroCuentaValido(cuentas, numero));
        return numero;
    }

    public static String pedirNumeroCuentaExistente(ArrayList<Cuenta> cuentas, BufferedReader lee) {
        String numero = "";
        do {
            System.out.printf("Número: ");
            numero = Pedir.texto(lee);
        } while (!Validar.esNumeroCuentaExistenteValido(cuentas, numero));
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

    public static String pedirNuevoDni(ArrayList<Cuenta> cuentas, BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esNuevoDniValido(cuentas, dni));
        return dni;
    }

    public static String pedirDniExistente(ArrayList<Cuenta> cuentas, BufferedReader lee) {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = Pedir.texto(lee);
        } while (!Validar.esDniExistenteValido(cuentas, dni));
        return dni;
    }
}
