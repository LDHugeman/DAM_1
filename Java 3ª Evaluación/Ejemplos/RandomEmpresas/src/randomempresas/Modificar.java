
package randomempresas;
import java.io.*;
import Clases.*;


 // @author

public class Modificar {
    
    public static void modificar (File fichero,int numeroRegistros, BufferedReader leer) throws IOException {
        
        
        RandomAccessFile flujoArchivoRW=new RandomAccessFile(fichero,"rw");

        C_Empresa empresa;
        String cif;
        byte b=0;
        
        System.out.println("Introduzca cif a Modificar:");
        cif=leer.readLine();

        for(int i=0;i<numeroRegistros;i++)
        {
            
            flujoArchivoRW.seek(i*140);
            empresa=new C_Empresa(flujoArchivoRW.readUTF(),flujoArchivoRW.readUTF(),flujoArchivoRW.readUTF(),flujoArchivoRW.readUTF());
            
            if(empresa.getCif().compareToIgnoreCase(cif)==0)
            {
                
                b=1;
                modEmpresa(empresa,leer);
                
                if(empresa.getTamañoReal()<=empresa.getTamañoMax())
                {
                    flujoArchivoRW.seek(i*empresa.getTamañoMax());
                    flujoArchivoRW.writeUTF(empresa.getCif());
                    flujoArchivoRW.writeUTF(empresa.getRazonSocial());
                    flujoArchivoRW.writeUTF(empresa.getDireccion());
                    flujoArchivoRW.writeUTF(empresa.getTelefono());
                }
                else
                    System.out.println("Tamaño Excedido  -- Empresa NO MODIFICADA --");
            }
        } 
        
        if(b!=1)
            System.out.println("--- Empresa NO ENCONTRADA ---");
        
        
    }
    
    public static void modEmpresa (C_Empresa empresa, BufferedReader leer) throws IOException {
        
        String razonSocial,direccion,telefono;
        byte op=0;
        
        do{
            
            Visualizar.visualizar(empresa);
            
            op=Menu.menuMod(op,leer);
           
            switch(op){
                case 1:
                    System.out.println("Introducir nuevo valor:");
                    razonSocial=leer.readLine();
                    empresa.setRazonSocial(razonSocial);
                    break;
                case 2:
                    System.out.println("Introducir nuevo valor:");
                    direccion=leer.readLine();
                    empresa.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introducir nuevo valor:");
                    telefono=leer.readLine();
                    empresa.setTelefono(telefono);
                    break;
            }
        }while(op!=4);
        
    }
    
}
