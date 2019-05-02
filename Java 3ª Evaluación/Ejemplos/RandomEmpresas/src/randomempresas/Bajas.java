
package randomempresas;
import java.io.*;
import Clases.*;


 // @author 

public class Bajas {
    
    public static int bajas (File fDatos, int nRegs, BufferedReader leer) throws IOException {
        
       
        File temporal=new File("temporal.dat");
        RandomAccessFile rafTemp=new RandomAccessFile(temporal,"rw");
        RandomAccessFile rafDatos=new RandomAccessFile(fDatos,"r");

        C_Empresa empresa;
        String cif;
        byte b=0;
        
        System.out.println("Introduzca cif a borrar:");
        cif=leer.readLine();
        
        for(int i=0;i<nRegs;i++)
        {
            rafDatos.seek(i*140);
            empresa=new C_Empresa(rafDatos.readUTF(),rafDatos.readUTF(),rafDatos.readUTF(),rafDatos.readUTF());
            
            if(empresa.getCif().compareToIgnoreCase(cif)!=0)
            {
             
                rafTemp.seek(b*140);
                rafTemp.writeUTF(empresa.getCif());
                rafTemp.writeUTF(empresa.getRazonSocial());
                rafTemp.writeUTF(empresa.getDireccion());
                rafTemp.writeUTF(empresa.getTelefono());
                b++;
            }
            
        }
        
        rafDatos.close();
        rafTemp.close();
        
        fDatos.delete();
        temporal.renameTo(fDatos);
        

        if(b==nRegs)
        {
            System.out.println("--- Empresa NO ENCONTRADA ---");
            
        }
        else
        {
            System.out.println("---  EMPRESA BORRADA  ---");
            nRegs--;
        }
        
        return nRegs;

    }

}
