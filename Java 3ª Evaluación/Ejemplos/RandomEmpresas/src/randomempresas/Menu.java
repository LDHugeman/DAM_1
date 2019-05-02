
package randomempresas;
import java.io.*;

 // @author 

public class Menu {
    
    public static byte menup(byte op, BufferedReader leer)  {
        
        do{
            try{
                System.out.println("\n\nSeleccione opción:"
                        + "\n1.Altas"
                        + "\n2.Bajas"
                        + "\n3.Modificaciones"
                        + "\n4.Busqueda"
                        + "\n5.Visualizar"
                        + "\n6.Salir");
                op=Byte.parseByte(leer.readLine());

            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }while(op<1 || op>6);
        return op;
        
    } 
    
    public static byte menuMod(byte op, BufferedReader leer) throws IOException {
        
        System.out.println("\n\n¿Qué desea modificar?"
                    + "\n1.Razón Social"
                    + "\n2.Dirección"
                    + "\n3.Teléfono"
                    + "\n4.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
            
            
    }
    
}
