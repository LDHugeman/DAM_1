package sociosempleados;

import java.util.ArrayList;
import objetos.Empleado;

/**
 *
 * @author David
 */
public class Validar {

    public static boolean esDniValido(String texto, ArrayList<Empleado> empleados) {
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
            if(Consultar.existeEmpleadoPorDni(texto, empleados)){
                dniEsValido=false;
                throw new Excepciones("Ese Dni ya existe");
            }
        } catch (Excepciones excepcion) {
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
    
    public static boolean esNombreValido(String texto){
        boolean nombreEsValido=true;
        try{
            if(texto.length()>20){
                nombreEsValido = false;
                throw new Excepciones("Nombre demasiado largo");
            }
            if(!texto.matches("[A-Za-z]*")){
                nombreEsValido = false;
                throw new Excepciones("Letra errónea");
            }
        }catch(Excepciones excepcion){
            System.out.println(excepcion.getError());
        }
        return nombreEsValido;
    }
    
    public static boolean esDniExistenteValido(String texto) {
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
