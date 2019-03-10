
package listalinealalumnos;
import Clases.*;
import java.io.*;


public class Buscar {
    
    
    
    public static void buscar (C_Alumno p, BufferedReader leer) throws IOException {
        
        String nombre;
        
        System.out.println("Introducir nombre del alumno a buscar:");
        nombre=leer.readLine();

        C_Alumno actual=p;

        
        if(p==null)
            System.out.println("LISTA VACIA!!!!");
        
        else
        
        {
            while(actual!=null && nombre.compareToIgnoreCase(actual.getNombre())!=0)
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
