
package sociosempleados;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Empleado;

/**
 *
 * @author David
 */
public class Altas {
    
    public static void altaNuevoEmpleado(BufferedReader lee, Empleado empleado, ArrayList<Empleado> empleados)throws IOException{
        empleados.add(empleado);
    }
    
    
}
