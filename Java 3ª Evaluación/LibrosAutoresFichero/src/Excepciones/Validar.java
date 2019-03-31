package Excepciones;

import java.io.File;
import librosautoresfichero.Consultar;

/**
 *
 * @author a18luisdvp
 */
public class Validar {

    public static boolean esNuevoDniValido(File fichero, String texto) {
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
            if (Consultar.existeAutorPorDni(fichero, texto)) {
                dniEsValido = false;
                throw new Excepcion("Ese Dni ya existe");
            }
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }

    public static boolean esDniExistenteValido(File fichero, String texto) {
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
            if (!Consultar.existeAutorPorDni(fichero, texto)) {
                dniEsValido = false;
                throw new Excepcion("Ese Dni no existe");
            }
        } catch (Excepcion excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
}
