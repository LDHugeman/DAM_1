package cuentascorriente;

/**
 *
 * @author David
 */
public class Validar {

    public static boolean validarDNI(String texto) {
        boolean dniEsValido = true;
        try {
            if (texto.length() != 9) {
                dniEsValido = false;
                throw new Excepciones("Longitud errónea");
            }
            if(texto.substring(0,8).matches("[0-9]*")){
                dniEsValido = true;
            }else{
                dniEsValido=false;
                throw new Excepciones("Número erróneo");
            }
            if(texto.substring(8).matches("[A-Za-z]")){
                dniEsValido = true;
            }else{
                dniEsValido=false;
                throw new Excepciones("Letra errónea");
            }
        }catch(Excepciones excepcion){
            System.out.println(excepcion.getError());
        }
        return dniEsValido;
    }
}
