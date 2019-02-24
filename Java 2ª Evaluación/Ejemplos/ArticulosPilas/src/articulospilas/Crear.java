
package articulospilas;
import clases.*;
import java.io.*;

// @author

public class Crear {
    
    public static Articulo crear (Articulo p, BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Desea eliminar la lista actual y crear una nueva?"
                + "\n1.SI"
                + "\n2.NO");
        op=Byte.parseByte(leer.readLine());
        
        if (op==1)
        {
            p=null;
        }
        
        return p;
    }
    
}
