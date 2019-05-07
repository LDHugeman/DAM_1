
package funciones;

import java.io.*;

/**
 *
 * @author 
 */
public class Funciones {
    
    public static String introducirString (BufferedReader lee, String mensaje) {
        
        String atributo = "";
        try {
            System.out.println(mensaje);
            atributo = lee.readLine();    
        } catch (IOException e) {}
        
        return atributo;
    }
    
    public static int introducirId (BufferedReader lee, String mensaje, String error) {
        
        int atributo = 0;
        try {
            System.out.println(mensaje);
            atributo = Integer.parseInt(lee.readLine());
        } catch (IOException e) {}
        
        return atributo;
    }
}
