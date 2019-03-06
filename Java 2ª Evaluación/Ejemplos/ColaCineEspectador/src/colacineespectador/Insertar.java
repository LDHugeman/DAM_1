
package colacineespectador;
import java.io.*;
import Clases.*;

// @author 

public class Insertar {
    
    public static C_Espectador insertar (C_Espectador p, BufferedReader leer) throws IOException {
        
        String nombre, pelicula;
        int asiento;
        
        C_Espectador q;
        C_Espectador actual=p;
        
        
        
        System.out.printf("%nIntroducir nombre:  ('fin' para finalizar) %n");
        nombre=leer.readLine();
        
        while(nombre.compareToIgnoreCase("fin")!=0)
        {

            System.out.println("Introducir título de la pelicula:");
            pelicula=leer.readLine();
            System.out.println("Introducir número de asiento:");
            asiento=Integer.parseInt(leer.readLine());
            
            if (p==null)
            {/*INSERTAR PRIMER ELEMENTO*/
                q = new C_Espectador(nombre, pelicula, asiento,p);
                p = q;
                actual=q;
            }
             else
            {
                while (actual.getSiguiente()!=null)
                {
                    actual=actual.getSiguiente();
                }
                
                q = new C_Espectador(nombre, pelicula, asiento,p);
                q.setSiguiente(null);
                actual.setSiguiente(q);
                
            }
            
            System.out.printf("%nIntroducir nombre:  ('fin' para finalizar) %n");
            nombre=leer.readLine();
        }
        return p;
        
    }
    
}
