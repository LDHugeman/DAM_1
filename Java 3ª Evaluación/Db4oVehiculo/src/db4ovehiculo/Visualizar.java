package db4ovehiculo;

import java.util.ArrayList;
import objetos.Camion;
import objetos.Coche;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrarVehiculo(Vehiculo vehiculo) {
        System.out.println("-------------------------------------------");
        System.out.println("Matrícula: " + vehiculo.getMatricula());
        System.out.println("Propietario: " + vehiculo.getPropietario());
        System.out.println("Precio: " + vehiculo.getPrecio());
        if (vehiculo instanceof Coche) {
            System.out.println("Modelo: " + ((Coche) vehiculo).getModelo());
            System.out.println("Impuesto: " + vehiculo.getImpuesto());
        } else if (vehiculo instanceof Camion) {
            System.out.println("Potencia: " + ((Camion) vehiculo).getPotencia());
            System.out.println("Número de años: " + ((Camion) vehiculo).getNumeroDeAnos());
            System.out.println("Fecha de alta: " + ((Camion) vehiculo).getStringFechaDeAlta());
            System.out.println("Impuesto: " + vehiculo.getImpuesto());
        }
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarVehiculos(ArrayList<Vehiculo> vehiculos){
        for(Vehiculo vehiculo:vehiculos){
            mostrarVehiculo(vehiculo);
        }
    }

    public static void mostrarCamiones(ArrayList<Camion> camiones) {
        for (Camion camion : camiones) {
            System.out.println("-------------------------------------------");
            System.out.println("Matrícula: " + camion.getMatricula());
            System.out.println("Propietario: " + camion.getPropietario());
            System.out.println("Precio: " + camion.getPrecio());
            System.out.println("Potencia: " + camion.getPotencia());
            System.out.println("Número de años: " + camion.getNumeroDeAnos());
            System.out.println("Fecha de alta: " + camion.getStringFechaDeAlta());
            System.out.println("Impuesto: " + camion.getImpuesto());
            System.out.println("-------------------------------------------");
        }
    }
}
