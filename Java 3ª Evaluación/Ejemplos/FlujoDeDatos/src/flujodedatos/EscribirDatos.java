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
public class EscribirDatos {
     public static void escribirDatos(File fichero) throws IOException{
     BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
     char resp;
     //Los campos todos tienenen que ser Srting,luego
     //si se necesita se transforman a numéricos
        DataOutputStream dos=null;
        String nombre;
        String direccion;
        int telefono;
        
    try{
            dos=new DataOutputStream(new FileOutputStream(fichero,true));
            do{
                    System.out.print("Escribe el nombre: ");
                       nombre = lee.readLine();
                    System.out.print("Escribe la direccion: ");
                        direccion=lee.readLine();
                    System.out.print("Escribe el telefono: ");
                        telefono=Integer.parseInt(lee.readLine());
                            String TF=String.valueOf(telefono);
                           dos.writeUTF( nombre);
                           dos.writeUTF(direccion);
                           dos.writeUTF(TF);
                
                    System.out.print("Quiere escribir otro registro? (s/n): ");
                        resp=lee.readLine().charAt(0);
                }while(resp == 's');
            
        }catch(IOException e){
                System.out.println("Error: "+ e.getMessage());
        }finally{
            if(dos != null)
                dos.close();
        }
        }

}