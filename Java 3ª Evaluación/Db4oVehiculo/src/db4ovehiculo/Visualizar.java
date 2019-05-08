
package db4ovehiculo;

import objetos.Camion;
import objetos.Coche;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Visualizar {
    
    public static void mostrarVehiculo(Vehiculo vehiculo){
        System.out.println("-------------------------------------------");
        System.out.println("Matrícula: "+vehiculo.getMatricula());
        System.out.println("Propietario: "+vehiculo.getPropietario());
        System.out.println("Precio: "+vehiculo.getPrecio());
        if(vehiculo instanceof Coche){
            System.out.println("Modelo: "+((Coche) vehiculo).getModelo()); 
            System.out.println("Impuesto: "+vehiculo.getImpuesto());
        } else if (vehiculo instanceof Camion){
            System.out.println("Potencia: "+((Camion) vehiculo).getPotencia());
            System.out.println("Fecha de alta(dd/MM/yyyy): "+((Camion) vehiculo).getStringFechaDeAlta());
            System.out.println("Impuesto: "+vehiculo.getImpuesto());
        }
        System.out.println("-------------------------------------------");
    }
}
