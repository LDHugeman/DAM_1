
package colacineespectador;
import java.io.*;
import Clases.*;

// @author 

public class Borrar {
    
    
    public static C_Espectador borrar(C_Espectador p, BufferedReader leer) throws IOException {
        
        String nombre;
        byte confirmar;
        
        System.out.println("Introducir nombre del espectador a borrar:");
        nombre=leer.readLine();
        
        C_Espectador actual=p;
        C_Espectador anterior=p;
        
        if(p==null)
            System.out.println("----LISTA VACIA----");
        
        else
        
        {
            while(actual!=null && nombre.compareToIgnoreCase(actual.getNombre())!=0)
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
                System.out.printf("%n¿Desea eliminar al espectador "+actual.getNombre()+" de la lista?"
                        + "%n1.SI"
                        + "%n2.NO%n");
                confirmar=Byte.parseByte(leer.readLine());
                
                if(confirmar==1)
                {
                    if(actual!=anterior) 
                    {
                        anterior.setSiguiente(actual.getSiguiente()); 
                    }
                    else 
                    {   /*BORRAR PRIMERO DE LA LISTA*/
                        p=p.getSiguiente(); 
                    }

                    System.out.println("Espectador eliminado");
                }
                else
                    System.out.println("Espectador no eliminado");
            }        
     
        }
        
        return p;
    
}
}
