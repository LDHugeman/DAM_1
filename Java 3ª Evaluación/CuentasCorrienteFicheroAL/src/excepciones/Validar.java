package excepciones;

import cuentascorrientefichero.Consultar;
import java.io.File;
import java.util.ArrayList;
import objetos.Cuenta;

/**
 *
 * @author a18luisdvp
 */
public class Validar {
    
    public static boolean esDniValido(String texto) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepcion("Longitud errónea");
            }
            if (!texto.substring(0, 8).matches("[0-9]*")) {
                dniEsValido = false;
                throw new Excepcion("Número erróneo");
            }
            if (!texto.substring(8).matches("[A-Za-z]")) {
                dniEsValido = false;
                throw new Excepcion("Letra errónea");
            }           
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
    
    public static boolean esNuevoDniValido(ArrayList<Cuenta> cuentas, String texto) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepcion("Longitud errónea");
            }
            if (!texto.substring(0, 8).matches("[0-9]*")) {
                dniEsValido = false;
                throw new Excepcion("Número erróneo");
            }
            if (!texto.substring(8).matches("[A-Za-z]")) {
                dniEsValido = false;
                throw new Excepcion("Letra errónea");
            }
            if (Consultar.existeClientePorDni(cuentas, texto)) {
                dniEsValido = false;
                throw new Excepcion("Ya existe un cliente con ese Dni");
            }
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }

    public static boolean esDniExistenteValido(ArrayList<Cuenta> cuentas, String texto) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepcion("Longitud errónea");
            }
            if (!texto.substring(0, 8).matches("[0-9]*")) {
                dniEsValido = false;
                throw new Excepcion("Número erróneo");
            }
            if (!texto.substring(8).matches("[A-Za-z]")) {
                dniEsValido = false;
                throw new Excepcion("Letra errónea");
            }
            if (!Consultar.existeClientePorDni(cuentas, texto)) {
                dniEsValido = false;
                throw new Excepcion("No existe ningún cliente con ese Dni");
            }
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }

    public static boolean esNuevoNumeroCuentaValido(ArrayList<Cuenta> cuentas, String texto) {
        boolean numeroCuentaEsValido = true;
        try {
            if (texto.length() != 6) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Longitud errónea");
            }
            if (!texto.substring(0, 4).matches("[0-9]*")) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Número erróneo");
            }
            if (!texto.substring(5).matches("[A-Za-z]")) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Letra errónea");
            }
            if (Consultar.existeCuentaCorrientePorNumero(cuentas, texto)) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Ya existe una cuenta con ese número");
            }
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return numeroCuentaEsValido;
    }

    public static boolean esNumeroCuentaExistenteValido(ArrayList<Cuenta> cuentas, String texto) {
        boolean numeroCuentaEsValido = true;
        try {
            if (texto.length() != 6) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Longitud errónea");
            }
            if (!texto.substring(0, 4).matches("[0-9]*")) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Número erróneo");
            }
            if (!texto.substring(5).matches("[A-Za-z]")) {
                numeroCuentaEsValido = false;
                throw new Excepcion("Letra errónea");
            }
            if (!Consultar.existeCuentaPorNumero(cuentas, texto)) {
                numeroCuentaEsValido = false;
                throw new Excepcion("No existe ninguna cuenta con ese número");
            }
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return numeroCuentaEsValido;
    }
}
