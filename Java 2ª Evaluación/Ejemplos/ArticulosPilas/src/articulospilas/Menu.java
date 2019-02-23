
package articulospilas;
import java.io.*;

// @author 

public class Menu {
    
    
    public static byte menu (byte op, BufferedReader leer) throws IOException {
        
        System.out.printf("Selecione opción:"
                + "%n1.Crear"
                + "%n2.Insertar"
                + "%n3.Borrar"
                + "%n4.Buscar"
                + "%n5.Visualizar"
                + "%n0.FIN"
                + "%n");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
}
