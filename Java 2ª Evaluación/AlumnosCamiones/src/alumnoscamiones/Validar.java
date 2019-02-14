
package alumnoscamiones;

import interfaces.I_Nexo;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Validar {
    
    public static boolean esDniValido(String texto, ArrayList<I_Nexo> listado) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 8).matches("[0-9]*")) {
                dniEsValido = false;
                throw new Excepciones("Número erróneo");
            }
            if (!texto.substring(8).matches("[A-Za-z]")) {
                dniEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if(Consultar.existeAlumnoPorDni(texto, listado)){
                dniEsValido=false;
                throw new Excepciones("Ese dni ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
    
    public static boolean esDniValidoExistente(String texto, ArrayList<I_Nexo> listado) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 8).matches("[0-9]*")) {
                dniEsValido = false;
                throw new Excepciones("Número erróneo");
            }
            if (!texto.substring(8).matches("[A-Za-z]")) {
                dniEsValido = false;
                throw new Excepciones("Letra errónea");
            }          
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
}
