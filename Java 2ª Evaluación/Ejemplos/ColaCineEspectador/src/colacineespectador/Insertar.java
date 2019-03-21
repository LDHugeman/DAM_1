
package colacineespectador;
import java.io.*;
import Clases.*;

// @author 

public class Insertar {
    
    public static C_Espectador insertar (C_Espectador cabecera, BufferedReader leer) throws IOException {
        
        String nombre, pelicula;
        int asiento;
        
        C_Espectador nuevoEspectador;
        C_Espectador actual=cabecera;
        
        
        
        System.out.printf("%nIntroducir nombre:  ('fin' para finalizar) %n");
        nombre=leer.readLine();
        
        while(nombre.compareToIgnoreCase("fin")!=0){
            System.out.println("Introducir título de la pelicula:");
            pelicula=leer.readLine();
            System.out.println("Introducir número de asiento:");
            asiento=Integer.parseInt(leer.readLine());
            
            if (cabecera==null){
                /*INSERTAR PRIMER ELEMENTO*/
                nuevoEspectador = new C_Espectador(nombre, pelicula, asiento,cabecera);
                cabecera = nuevoEspectador;
                actual=nuevoEspectador;
            } else{
                while (actual.getSiguiente()!=null){
                    actual=actual.getSiguiente();
                }
                nuevoEspectador = new C_Espectador(nombre, pelicula, asiento,cabecera);
                nuevoEspectador.setSiguiente(null);
                actual.setSiguiente(nuevoEspectador);
            }
            
            System.out.printf("%nIntroducir nombre:  ('fin' para finalizar) %n");
            nombre=leer.readLine();
        }
        return cabecera;
        
    }
    
}
