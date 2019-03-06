
package colacineespectador;
import Clases.*;
import java.io.*;

// @author Miguel

public class Modificar {
    
    
    
    public static void buscar (C_Espectador p, BufferedReader leer) throws IOException {
        
        String nombre;
        
        System.out.println("Introducir nombre del espectador a buscar:");
        nombre=leer.readLine();

        C_Espectador actual=p;

        
        if(p==null)
            System.out.println("----LISTA VACIA----");
        
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
                modificar(actual, leer);
            }
                   
     
        }
    }
    
    public static void modificar (C_Espectador espectador, BufferedReader leer) throws IOException {
        
        byte op;
        String peliculaN;
        int asientoN;
        
        Visualizar.visualizar(espectador);
        
        do{
        System.out.printf("¿Qué campo desea modificar?"
                + "%n1.Película"
                + "%n2.Asiento"
                + "%n3.Salir");
        op=Byte.parseByte(leer.readLine());
        
        switch (op){
            case 1:
                System.out.println("Introducir nueva película:");
                peliculaN=leer.readLine();
                espectador.setPelicula(peliculaN);
                System.out.println("--PELICULA MODIFICADA--");
                break;
            case 2:
                System.out.println("Introducir nuevo asiento:");
                asientoN=Integer.parseInt(leer.readLine());
                espectador.setAsiento(asientoN);
                System.out.println("--ASIENTO MODIFICADO--");
                break;
            case 3:
                System.out.println("Operación cancelada");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        }while(op!=1&&op!=2&&op!=3);
        
        
        
    }
    
    
    
    
}
