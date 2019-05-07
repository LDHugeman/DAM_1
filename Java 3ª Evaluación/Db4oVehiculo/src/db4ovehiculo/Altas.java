
package db4ovehiculo;

import com.db4o.ObjectContainer;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Altas {
    
    public static void vehiculo(ObjectContainer baseDatos, Vehiculo vehiculo){
        baseDatos.store(vehiculo);
    }
    
    
}
