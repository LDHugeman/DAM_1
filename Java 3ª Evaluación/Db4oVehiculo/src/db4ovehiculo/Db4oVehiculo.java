
package db4ovehiculo;

import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Db4oVehiculo {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ObjectContainer baseDatos = Bbdd.abrir();
        byte opcionSeleccionada = 0;
        do {            
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch(opcionSeleccionada){
                case 1:
                    Menu.menuAltas(baseDatos, lee);
                    break;
                case 2:
                    byte opcion = 0;
                    Vehiculo vehiculo = Consultar.obtenerVehiculoPorMatricula(baseDatos, Crear.obtenerMatricula(lee));
                    if(vehiculo!=null){
                        Visualizar.mostrarVehiculo(vehiculo);
                        System.out.println("¿Es este el vehículo que desea eliminar?");                        
                        System.out.println("[1] Si");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcion = Pedir.numeroByte(lee);
                        if(opcion==1){
                            Bajas.vehiculo(baseDatos, vehiculo);                            
                        } else {
                            System.out.println("Operación cancelada");
                        }
                    } else {
                        System.err.println("No existe ningún vehículo con esa matrícula");
                    }
                    break;
                case 3:
                    Vehiculo vehiculoAModificar = Consultar.obtenerVehiculoPorMatricula(baseDatos, Crear.obtenerMatricula(lee));
                    if(vehiculoAModificar!=null){
                        Visualizar.mostrarVehiculo(vehiculoAModificar);
                        System.out.println("¿Es este el vehículo que desea modificar?");                        
                        System.out.println("[1] Si");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcion = Pedir.numeroByte(lee);
                        if(opcion==1){
                            Modificar.precioVehiculo(baseDatos, vehiculoAModificar, lee);                            
                        } else {
                            System.out.println("Operación cancelada");
                        }
                    } else {
                        System.err.println("No existe ningún vehículo con esa matrícula");
                    }
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada!=0);
        Bbdd.cerrar();
    }
    
}
