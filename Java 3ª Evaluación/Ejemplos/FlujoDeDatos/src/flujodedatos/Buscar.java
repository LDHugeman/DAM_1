/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;
import java.io.*;
/**
 *
 * @author a11albacl
 */
public class Buscar {
    public static void Buscar(File fichero) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis=null;
        String nombreF;
        String nombre;
        String direccion;
        String telefono;
        boolean b=true;
         int c=1; 
        try{
        System.out.print("Escribe el nombre del registro a buscar: ");
                    nombre=lee.readLine();
                dis=new DataInputStream(new FileInputStream(fichero));
              
                do{
                    nombreF=dis.readUTF();
                    direccion=dis.readUTF();
                    telefono=dis.readUTF();
        
                    if(nombre.compareToIgnoreCase(nombreF)==0 && c==1){
        
                        System.out.println(nombreF);
                        System.out.println(direccion);
                        System.out.println(telefono);
                        b=false;c=0;
                    }
                    
                }while(b); // Mientras b sea verdadero significa que no llego el fin de fichero
               
                }catch(EOFException e){
                     if (c==1) System.out.println("Elemnto inexistente"); 
                System.out.println("Fin de fichero");
        }finally{
            if(dis != null)
                dis.close();           
    }
    }
}
    

