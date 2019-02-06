
package sociosempleados;

import java.util.ArrayList;
import objetos.Empleado;

/**
 *
 * @author David
 */
public class Bajas {
    
    public static void eliminarEmpleado(Empleado empleado, ArrayList<Empleado> empleados){
        empleados.remove(empleado);
    }
}
