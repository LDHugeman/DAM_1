
package sociosempleados;

import java.util.ArrayList;
import objetos.Empleado;
import objetos.Jefe;

/**
 *
 * @author David
 */
public class Visualizar {
    
    public static void verJefes(ArrayList<Empleado> empleados){
        System.out.printf("%-15s %-25s %-35s %n","DNI","NOMBRE","SUELDO");
        for(Empleado empleado:empleados){
            if(empleado instanceof Jefe){
                System.out.printf("%-15s %-25s %-35d %n",empleado.getDni(),empleado.getNombre(),empleado.getSueldo());
            }
        }
    }
}
