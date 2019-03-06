package yogurescola;

import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Validar {

    public static boolean esCodigoNuevoValido(String texto, Yogourt cabecera) {
        boolean codigoEsValido = true;
        try {
            if (texto.length() != 8) {
                codigoEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if(!texto.substring(0,2).matches("[A-Za-z]*")){
                codigoEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if(!texto.substring(2).matches("[0-9]*")){
                codigoEsValido = false;
                throw new Excepciones("Número erróneo");
            }
            if(Consultar.existeYogurPorCodigo(texto, cabecera)){
                codigoEsValido = false;
                throw new Excepciones("Ese código ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoEsValido;
    }
    
    public static boolean esCodigoExistenteValido(String texto, Yogourt cabecera) {
        boolean codigoEsValido = true;
        try {
            if (texto.length() != 8) {
                codigoEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if(!texto.substring(0,2).matches("[A-Za-z]*")){
                codigoEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if(!texto.substring(2).matches("[0-9]*")){
                codigoEsValido = false;
                throw new Excepciones("Número erróneo");
            }
            if(!Consultar.existeYogurPorCodigo(texto, cabecera)){
                codigoEsValido = false;
                throw new Excepciones("Ese código no existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoEsValido;
    }
}
