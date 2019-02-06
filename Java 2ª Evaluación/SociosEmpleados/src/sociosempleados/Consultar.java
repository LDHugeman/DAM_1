
package sociosempleados;
import java.util.ArrayList;
import objetos.Empleado;

/**
 *
 * @author David
 */
public class Consultar {
    
    public static Empleado encontrarEmpleadoPorDni(String dni, ArrayList<Empleado> empleados){
        Empleado empleadoEncontrado= null;
        for(Empleado empleado:empleados){
            if(empleado.getDni().equals(dni)){
                empleadoEncontrado=empleado;
            }
        }
        return empleadoEncontrado;
    }
    
    public static boolean existeEmpleadoPorDni(String dni, ArrayList<Empleado> empleados){
        return encontrarEmpleadoPorDni(dni, empleados)!=null;
    }
    
    public static Empleado encontrarEmpleadoPorNombre(String nombre, ArrayList<Empleado> empleados){
        Empleado empleadoEncontrado= null;
        for(Empleado empleado:empleados){
            if(empleado.getNombre().equals(nombre)){
                empleadoEncontrado=empleado;
            }
        }
        return empleadoEncontrado;
    }
    
    public static boolean existeEmpleadoPorNombre(String nombre, ArrayList<Empleado> empleados){
        return encontrarEmpleadoPorNombre(nombre, empleados)!=null;
    }
    
    public static void ordenarPorBurbujaAscendente(ArrayList<Empleado> empleados){
        Empleado empleado=null;      
        for (int i = 0; i < empleados.size() - 1; i++) {
            for (int j = i + 1; j < empleados.size(); j++) {
                if (empleados.get(i).getDni().compareToIgnoreCase(empleados.get(j).getDni()) > 0) {
                    empleado = empleados.get(i);
                    empleados.set(i, empleados.get(j));
                    empleados.set(j, empleado);
                }
            }
        }
    }
    
    public static Empleado buscarEmpleadoPorDni(String dni, ArrayList<Empleado> empleados){
        ordenarPorBurbujaAscendente(empleados);
        int low = 0;
        int high = empleados.size() - 1;
        int puntoMedio = 0;
        while (low < high) {
            puntoMedio = (int) (low + high) / 2;
            if (dni.compareToIgnoreCase(empleados.get(puntoMedio).getDni()) == 0) {
                low = puntoMedio;
                high = puntoMedio;
            } else if (dni.compareToIgnoreCase(empleados.get(puntoMedio).getDni()) < 0) {
                high = puntoMedio - 1;
            } else {
                low = puntoMedio + 1;
            }
        }
        if (dni.compareToIgnoreCase(empleados.get(low).getDni()) == 0) {
            return empleados.get(low);
        } else {
            System.out.printf("No se ha encontrado el empleado con dni %s %n", dni);
        }
        return null;
    }
}
