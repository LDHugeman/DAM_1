
package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import obxetos.CuentaPlazo;

/**
 *
 * @author Luis David
 */
public class Modificar {

    public static void modificarIntereses(CuentaPlazo cuenta, BufferedReader lee) throws IOException{
        System.out.println("Los intereses actuales de la cuenta son: "+cuenta.getIntereses());
        System.out.println("Inserte nuevo interes");
        float nuevosIntereses = Float.parseFloat(lee.readLine());
        cuenta.setIntereses(nuevosIntereses);
        System.out.println("Los intereses de la cuenta "+cuenta.getNumero()+" acaban de ser modificados");
    }
}
