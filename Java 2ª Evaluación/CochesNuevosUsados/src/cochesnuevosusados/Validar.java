package cochesnuevosusados;

import java.util.ArrayList;
import objetos.Coche;

/**
 *
 * @author a18luisdvp
 */
public class Validar {

    public static boolean esCodigoCocheVentaValido(String texto, ArrayList<Coche> coches) {
        boolean codigoCocheEsValido = true;
        try {
            if (texto.length() != 4) {
                codigoCocheEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 1).matches("[Vv]")) {
                codigoCocheEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if (!texto.substring(1).matches("[0-9]*")) {
                codigoCocheEsValido = false;
                throw new Excepciones("Número erróneo");
            }
            if (Consultar.existeCochePorCodigo(texto, coches)) {
                codigoCocheEsValido = false;
                throw new Excepciones("Ese código ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoCocheEsValido;
    }

    public static boolean esCodigoCocheAlquilerValido(String texto, ArrayList<Coche> coches) {
        boolean codigoCocheEsValido = true;
        try {
            if (texto.length() != 4) {
                codigoCocheEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 1).matches("[Aa]")) {
                codigoCocheEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if (!texto.substring(1).matches("[0-9]*")) {
                codigoCocheEsValido = false;
                throw new Excepciones("Número erróneo");
            }
            if (Consultar.existeCochePorCodigo(texto, coches)) {
                codigoCocheEsValido = false;
                throw new Excepciones("Ese código ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoCocheEsValido;
    }

    public static boolean esCodigoCocheExistenteValido(String texto, ArrayList<Coche> coches) {
        boolean codigoCocheEsValido = true;
        try {
            if (texto.length() != 4) {
                codigoCocheEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 1).matches("[AaVv]")) {
                codigoCocheEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if (!texto.substring(1).matches("[0-9]*")) {
                codigoCocheEsValido = false;
                throw new Excepciones("Número erróneo");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return codigoCocheEsValido;
    }
}
