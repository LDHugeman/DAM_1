
package db4oempleadosfijostemporales;

import com.db4o.ObjectContainer;
import objetos.Empleado;
import objetos.Empresa;

/**
 *
 * @author David
 */
public class Bajas {
    
    public static void empleado(ObjectContainer baseDatos, Empleado empleado, Empresa empresa){
        empresa.getEmpleados().remove(empleado);
        baseDatos.delete(empleado);
        baseDatos.store(empresa);
        System.out.println("Empleado "+empleado.getNombre()+" eliminado de la base de datos");
    }
}
