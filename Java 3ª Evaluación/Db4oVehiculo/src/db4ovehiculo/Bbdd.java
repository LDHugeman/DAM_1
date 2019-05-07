
package db4ovehiculo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author David
 */
public class Bbdd {
    
    private static ObjectContainer baseDatos; 
    private static boolean isClosed = true;
    
    /**
     * Si la bbdd está cerrada se abre y se retorna, si está abierta simplemente 
     * retornamos el objeto para su posterior uso
     * @return bbdd lista para ser usada
     */
    public static ObjectContainer abrir(){
        if(isClosed){
            baseDatos = Db4oEmbedded.openFile("BDVehiculos");
            isClosed = false;
            return baseDatos;
        }else {
            return baseDatos;
        }
           
    }
    
    public static void cerrar(){
        if(!isClosed){
            baseDatos.close();
            isClosed = true;
        }
    }
}
