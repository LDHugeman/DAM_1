
package flujodedatos;
import java.io.*;
/**
 *
 * @author a11albacl
 */
public class BorradoFisico {
    
    public static void Borrar(File fichero,File ficheroTemp) throws FileNotFoundException, IOException{
    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos=null;
        DataInputStream dis=null;     
       
        String nombreF;
        String nombre;
        String direccion;
        String telefono;
        boolean b=true;
        
                
        try{
        System.out.print("Escribe el nombre del registro a borrar: ");
                    nombre=lee.readLine();
                dis=new DataInputStream(new FileInputStream(fichero));
                dos=new DataOutputStream(new FileOutputStream(ficheroTemp));
                do{
                    nombreF=dis.readUTF();
                    direccion=dis.readUTF();
                    telefono=dis.readUTF();
        
                    if(nombre.compareToIgnoreCase(nombreF)==0){
         System.out.println("Borrado");}
                    else
                    {
                        dos.writeUTF(nombreF);
                        dos.writeUTF(direccion);
                        dos.writeUTF(telefono);
                    }                                   
                  }while(b); // Mientras b sea verdadero significa que no llego el fin de fichero
            
        }catch(EOFException e){
                System.out.println("Fin de fichero");
        }finally{
            if(dos != null)
                dos.close();
            if(dis != null)
                dis.close();
            fichero.delete();
            ficheroTemp.renameTo(fichero);
    }
    }
}