
package db4ovehiculo;

import com.db4o.ObjectContainer;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Bajas {
    
    public static void vehiculo(ObjectContainer baseDatos, Vehiculo vehiculo){
        baseDatos.delete(vehiculo);
        System.out.println("Vehículo con matrícula "+vehiculo.getMatricula()+" eliminado");
    }
}
