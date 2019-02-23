
package articulospilas;
import clases.*;
import java.io.*;

// @author 

public class Insertar {
    
    
    public static  C_Articulo insertar (C_Articulo p, BufferedReader leer) throws IOException{
        
        int codigo,unidades;
        float precio;
        C_Articulo q;
        
        System.out.printf("Introducir código de artículo, pulse 0 para finalizar%n");
        codigo=Integer.parseInt(leer.readLine());
        
        while(codigo!=0){
            
        System.out.printf("Introducir número de unidades%n");
        unidades=Integer.parseInt(leer.readLine());
        System.out.printf("Introducir precio del artículo%n");
        precio=Float.parseFloat(leer.readLine());
        
        q=new C_Articulo(codigo,unidades,precio);
        q.setSiguiente(p);
        
        p=q;
        
        System.out.printf("%n--ARTICULO CREADO--%n");
        
        System.out.printf("%nIntroducir código de artículo, pulse 0 para finalizar%n");
        codigo=Integer.parseInt(leer.readLine());
        
        }
        
        return p;
        
        
        
    }
    
    
    
}
