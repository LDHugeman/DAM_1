package db4ovehiculo;

import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Modificar {

    public static void precioVehiculo(ObjectContainer baseDatos, Vehiculo vehiculo, BufferedReader lee) {
        System.out.println("--- Inserte el nuevo precio del vehículo ---");
        vehiculo.setPrecio(Crear.obtenerPrecio(lee));
        baseDatos.store(vehiculo);
        System.out.println("Precio del vehículo con matrícula " + vehiculo.getMatricula() + " modificado");
    }
}
