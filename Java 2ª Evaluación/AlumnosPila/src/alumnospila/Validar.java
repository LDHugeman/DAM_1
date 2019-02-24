package alumnospila;

import objetos.Alumno;

/**
 *
 * @author a18luisdvp
 */
public class Validar {

    public static boolean esModuloValido(String texto) {
        boolean moduloEsValido = true;
        try {
            if (texto.length() != 20) {
                moduloEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 18).matches("[A-Z]*")) {
                moduloEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if (!texto.substring(18).matches("[0-9]*")) {
                moduloEsValido = false;
                throw new Excepciones("Número erróneo");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return moduloEsValido;
    }

    public static boolean esCodigoNuevoValido(String texto, Alumno cabecera) {
        boolean codigoEsValido = true;
        try {
            if (Consultar.existeAlumnoPorCodigo(texto, cabecera)) {
                codigoEsValido = false;
                throw new Excepciones("Ese alumno ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoEsValido;
    }

    public static boolean existeCodigo(String texto, Alumno cabecera) {
        boolean codigoEsValido = true;
        try {
            if (!Consultar.existeAlumnoPorCodigo(texto, cabecera)) {
                codigoEsValido = false;
                throw new Excepciones("Ese alumno no existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoEsValido;
    }
}
