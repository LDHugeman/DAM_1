package librosautores;

import java.util.ArrayList;
import objetos.Autor;

/**
 *
 * @author a18luisdvp
 */
public class Validar {

    public static boolean esDniValido(String texto, ArrayList <Autor> autores) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if (!texto.substring(0, 8).matches("[0-9]*")) {
                dniEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if (!texto.substring(8).matches("[A-Za-z]")){
                dniEsValido = false;
                throw new Excepciones("Letra errónea");
            }
            if(Consultar.existeAutorPorDni(texto, autores)){
                dniEsValido= false;
                throw new Excepciones("Ese Dni ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
}
