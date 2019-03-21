/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;
import java.io.*;
/**
 *
 * @author Usuario
 */
public class LeerDatos {
    public static void leerDatos(File fichero) throws FileNotFoundException, IOException{
                DataInputStream dis = null;
                String nombre;
                String direccion;
                String telefono;
                
                
    try{
                
                dis=new DataInputStream(new FileInputStream(fichero));
                
 
                do{
                    nombre=dis.readUTF();
                    direccion=dis.readUTF();
                    telefono=dis.readUTF();
                  
                    System.out.println(nombre);
                    System.out.println(direccion);
                    System.out.println(telefono);                   
                    System.out.println(); 

                }while(true);
        }catch (EOFException e){
            System.out.println("Fin de la lectura del archivo");
        }finally{
            if(dis != null)
                dis.close();
        }
    }
}