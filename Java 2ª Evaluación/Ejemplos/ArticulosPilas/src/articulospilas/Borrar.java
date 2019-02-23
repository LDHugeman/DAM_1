
package articulospilas;
import clases.*;
import java.io.*;

// @author 

public class Borrar {
    
    
    public static C_Articulo borrar(C_Articulo p, BufferedReader leer)  throws IOException {
        
        int codigo;
        
        System.out.println("Introducir código a borrar");
        codigo=Integer.parseInt(leer.readLine());
        
        C_Articulo actual=p;
        C_Articulo anterior=p;
        
        if(p==null)
            System.out.println("LISTA VACIA!!!!");
        
        else
        
        {
            while(actual!=null && codigo!=actual.getCodigo())
            {
                anterior=actual;
                actual=actual.getSiguiente();
            }
            
            if (actual==null)
            {   /*NO ENCONTRADO*/
                Visualizar.visualizar();
            }
            
            else
            {   /*ENCONTRADO*/
                if(actual!=anterior) 
                {
                    anterior.setSiguiente(actual.getSiguiente()); 
                }
                else 
                {   /*BORRAR PRIMERO DE LA LISTA*/
                    p=p.getSiguiente(); 
                }
                
                System.out.println("Articulo eliminado");
            }        
     
        }
        
        return p;
        
        
        
    }
    
}
