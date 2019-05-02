
package randomempresas;
import java.io.*;
import Clases.*;

 // @author 

public class Visualizar {
    
    public static void visualizar(File fDatos,int nRegs) throws IOException {
        
        RandomAccessFile rafDatos=new RandomAccessFile(fDatos,"r");
        
        System.out.println("LISTA DE EMPRESAS:");
        System.out.println("---   CIF       RAZONSOCIAL       DIRECCIÓN       TELÉFONO   ---");
        
        for(int i=0;i<nRegs;i++)
        {
            rafDatos.seek(i*140);
            System.out.printf("%n%9s %16s %12s %18s",rafDatos.readUTF(),rafDatos.readUTF(),rafDatos.readUTF(),rafDatos.readUTF());
        }
        
        rafDatos.close();
        
    }
    
    public static void visualizar (C_Empresa empresa) throws IOException {
        
        
        
        System.out.println("---   CIF       RAZONSOCIAL       DIRECCIÓN       TELÉFONO   ---");
        System.out.printf("%n%9s %16s %12s %18s", empresa.getCif(), empresa.getRazonSocial(), empresa.getDireccion(), empresa.getTelefono());
        

    }
    
}
