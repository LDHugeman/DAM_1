
package randomempresas;
import java.io.*;
import Clases.*;


 // @author

public class Altas {
    
    public static int alta (File fDatos, int nRegs, BufferedReader leer) throws IOException {
        

        C_Empresa empresa;
        byte op;

        
        do{
            empresa=altaEmpresa(leer);           
                 
            if(empresa.getTamañoReal()<=empresa.getTamañoMax())
            {
                RandomAccessFile rafDatos=new RandomAccessFile(fDatos,"rw");

                rafDatos.seek(nRegs*empresa.getTamañoMax());
                rafDatos.writeUTF(empresa.getCif());
                rafDatos.writeUTF(empresa.getRazonSocial());
                rafDatos.writeUTF(empresa.getDireccion());
                rafDatos.writeUTF(empresa.getTelefono());
                rafDatos.close();
                nRegs++;
            }
            else
                System.out.println("Tamaño Excedido");
                System.out.println("¿Desea crear nueva Empresa?"
                    + "\n1.Nueva Empresa"
                    + "\n2.Finalizar");
             op=Byte.parseByte(leer.readLine());
        }while(op!=2);
        
        return nRegs;
        
    }
    
    public static C_Empresa altaEmpresa (BufferedReader leer) throws IOException {
        
        String cif, razonSocial, direccion, telefono;
        C_Empresa empresa;
        
        System.out.println("Introducir cif:");
        cif=leer.readLine();
        
        System.out.println("Introducir Razón Social:");
        razonSocial=leer.readLine();
        
        System.out.println("Introducir dirección:");
        direccion=leer.readLine();
        
        System.out.println("Introducir Teléfono");
        telefono=leer.readLine();
                
        
        empresa=new C_Empresa(cif,razonSocial,direccion,telefono);
        
        return empresa;
        
    }
    
}
