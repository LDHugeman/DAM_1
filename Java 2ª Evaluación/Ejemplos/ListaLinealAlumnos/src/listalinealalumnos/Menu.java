
package listalinealalumnos;
import java.io.*;

// @author 

public class Menu {
    
    public static byte menu(byte op, BufferedReader leer) throws IOException {
        
        System.out.printf("%nSelecione opción:"
                + "%n1.Crear"
                + "%n2.Insertar"
                + "%n3.Borrar"
                + "%n4.Buscar por nombre"
                + "%n5.Listado aprobados"
                + "%n6.Listado completo"
                + "%n0.FIN"
                + "%n");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
}
