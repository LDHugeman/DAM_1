
package listalinealalumnos;
import Clases.*;
import java.io.*;

// @author

public class Borrar {
    
    
    public static C_Alumno borrar(C_Alumno p, BufferedReader leer)  throws IOException {
        
        String nombre;
        byte confirmar;
        
        System.out.println("Introducir nombre del alumno a borrar");
        nombre=leer.readLine();
        
        C_Alumno actual=p;
        C_Alumno anterior=p;
        
        if(p==null)
            System.out.println("LISTA VACIA!!!!");
        
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
                System.out.printf("%n¿Desea eliminar a "+actual.getNombre()+" de la lista?"
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

                    System.out.println("Alumno eliminado");
                }
                else
                    System.out.println("Alumno no eliminado");
            }        
     
        }
        
        return p;
        
        
        
    }
    
}
