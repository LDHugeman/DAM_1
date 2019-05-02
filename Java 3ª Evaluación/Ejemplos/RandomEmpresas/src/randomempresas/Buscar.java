
package randomempresas;
import java.io.*;
import Clases.*;

 // @author 

public class Buscar {
    
    public static void buscar (File fDatos, int nRegs, BufferedReader leer) throws IOException {
        
        
        RandomAccessFile rafDatos=new RandomAccessFile(fDatos,"r");
        C_Empresa empresa;
        String cif;
        byte b=0;
        
        
        System.out.println("Introduzca cif a buscar:");
        cif=leer.readLine();
        
        
        for(int i=0;i<nRegs;i++)
        {
            rafDatos.seek(i*140);
            empresa=new C_Empresa(rafDatos.readUTF(),rafDatos.readUTF(),rafDatos.readUTF(),rafDatos.readUTF());
            
            if(empresa.getCif().compareToIgnoreCase(cif)==0)
            {
                b=1;
                Visualizar.visualizar(empresa);
            }
            
        }

        if(b!=1)
            System.out.println("--- Empresa NO ENCONTRADA ---");

    }
    
}
