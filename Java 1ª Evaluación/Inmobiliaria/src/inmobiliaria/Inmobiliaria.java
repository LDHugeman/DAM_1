
package inmobiliaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class Inmobiliaria {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));        
        Factura factura = Introducir.novaFactura(lee);
        Visualizar.factura(factura);      
        //Visualizar.factura(Introducir.novaFactura(lee));
    }
    
}
