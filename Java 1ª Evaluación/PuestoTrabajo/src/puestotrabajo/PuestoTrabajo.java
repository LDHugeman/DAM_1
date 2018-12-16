
package puestotrabajo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class PuestoTrabajo {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Persona persona = IntroducirDatos.obterPersona(lee);
        if(persona!=null){
            if(persona.tenAcceso()){
                System.out.printf("Puede acceder al puesto de trabajo. %n");
            }else{
                System.err.printf("No puede acceder al puesto. %n");
            }
        }
    }
    

}
