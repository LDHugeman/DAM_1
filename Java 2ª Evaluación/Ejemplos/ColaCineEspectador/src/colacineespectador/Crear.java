
package colacineespectador;
import java.io.*;
import Clases.*;

// @author 

public class Crear {
    
    public static C_Espectador crear (C_Espectador p, BufferedReader leer) throws IOException{
        
        byte op;
        
        System.out.printf("¿Desea eliminar la lista y crear una nueva?"
                + "%n1.SI"
                + "%n2.NO"
                + "%n");
        op=Byte.parseByte(leer.readLine());
        
        if (op==1){
            
            p=null;
        }      
        
        return p;
        
    }
    
    
    
    
    
}
