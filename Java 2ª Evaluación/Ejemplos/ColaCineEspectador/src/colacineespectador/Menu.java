
package colacineespectador;
import java.io.*;

// @author 

public class Menu {
    
    
    public static byte menu (byte op, BufferedReader leer) throws IOException {
        
        
        System.out.printf("%nSeleccione opción:"
                + "%n1.Crear"
                + "%n2.Insertar"
                + "%n3.Borrar"
                + "%n4.Buscar"
                + "%n5.Modificar"
                + "%n6.Visualizar"
                + "%n0.FIN"
                + "%n"
                + "");
        
        op=Byte.parseByte(leer.readLine());
        
        
        return op;
    }
    
    
    
    
    
    
}
