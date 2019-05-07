
package db4ovehiculo;

import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class Db4oVehiculo {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ObjectContainer baseDatos = Bbdd.abrir();
        
        Bbdd.cerrar();
    }
    
}
