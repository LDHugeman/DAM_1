
package alumnoempresalistalineal;
import java.io.*;
/**
 *
 * @author 
 */
public class Fichero {
    
    public static void crear (File fDatos) throws IOException {
        
        int op;
        
        ObjectOutputStream oos = null;
        
        try {
            if (!fDatos.exists()) {
                oos = new ObjectOutputStream (new FileOutputStream (fDatos));
                System.out.println("Fichero creado");
            }
            else 
                System.out.println("El fichero ya existe");
            
        } catch (IOException e) {}
        
        finally {
                if (oos != null)
                    oos.close();
            }
    }
    
    public static void sobrescribirFichero (File fDatos) throws IOException {
        
        int op;
        
        ObjectOutputStream oos = null;
        
        try {
            if (fDatos.exists()) {
                oos = new ObjectOutputStream (new FileOutputStream (fDatos));
                System.out.println("Fichero sobrescrito");
            }
            
        } catch (IOException e) {}
        
        finally {
                if (oos != null)
                    oos.close();
            }
    }
    
    public static void borrarFichero (BufferedReader lee, File fDatos) {

        if (fDatos.exists()) {
            char conf = Menu.confirmacion(lee, "Esta seguro de que desea borrar el fichero?");
            if (conf == 'S') {
                fDatos.delete();
                System.out.println("Fichero borrado");
            }
        }
        else 
            System.out.println("No existe ningun fichero");
    }
}
    

