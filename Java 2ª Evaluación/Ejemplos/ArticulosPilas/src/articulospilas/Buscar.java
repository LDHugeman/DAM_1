
package articulospilas;
import clases.*;
import java.io.*;

// @author 

public class Buscar {
    
    
    
    public static void buscar (C_Articulo p, BufferedReader leer) throws IOException {
        
        int codigo;
        
        System.out.println("Introducir código del artículo a buscar:");
        codigo=Integer.parseInt(leer.readLine());

        C_Articulo actual=p;

        
        if(p==null)
            System.out.println("LISTA VACIA!!!!");
        
        else
        
        {
            while(actual!=null && codigo!=actual.getCodigo())
            {
                actual=actual.getSiguiente();
            }
            
            if (actual==null)
            {   /*NO ENCONTRADO*/
                Visualizar.visualizar();
            }
            
            else
            {   /*ENCONTRADO*/
                Visualizar.visualizar(actual);
            }
                   
     
        }
    }
    
}
