
package listalinealalumnos;
import Clases.*;
import java.io.*;

// @author 

public class Insertar {
    
    
    public static  C_Alumno insertar (C_Alumno p, BufferedReader leer) throws IOException{
        
        String nombre,modulo;
        float nota;
        
        C_Alumno q;
        C_Alumno actual;
        C_Alumno anterior;
        
        
        System.out.printf("Introducir nombre de alumno, pulse fin para finalizar%n");
        nombre=leer.readLine();
        
        while(nombre.compareToIgnoreCase("fin")!=0){
            
            actual=p;
            anterior=p;

            System.out.printf("Introducir módulo:%n");
            modulo=leer.readLine();
            System.out.printf("Introducir nota del alumno%n");
            nota=Float.parseFloat(leer.readLine());
            
            if(p==null)
            {   /*Introducir primer objeto*/
                p=new C_Alumno(nombre,modulo,nota);
            }
            else
            {
                
                while(actual!=null && nombre.compareToIgnoreCase(actual.getNombre()) > 0 )
                {
                    anterior=actual;
                    actual=actual.getSiguiente();
                }
                
                if (anterior == actual)
                {   /*añadir al principio de la lista*/
                    q=new C_Alumno(nombre,modulo,nota);
                    q.setSiguiente(p);
                    p=q;
                }
                        
                else
                {   /*añadir en el medio o al final de la lista*/
                    q=new C_Alumno(nombre,modulo,nota);
                    q.setSiguiente(actual);
                    anterior.setSiguiente(q);
                }
            }

            System.out.printf("%n--ALUMNO CREADO--%n");

            System.out.printf("%nIntroducir nombre de alumno, pulse fin para finalizar%n");
            nombre=leer.readLine();
        
        }
        
        return p;
        
        
        
    }
    
    
    
}
