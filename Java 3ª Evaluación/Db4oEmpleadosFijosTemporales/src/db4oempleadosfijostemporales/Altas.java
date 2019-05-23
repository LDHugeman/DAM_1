
package db4oempleadosfijostemporales;

import com.db4o.ObjectContainer;
import objetos.Empleado;
import objetos.EmpleadoTemporal;
import objetos.Empresa;
import objetos.Producto;
import objetos.Venta;

/**
 *
 * @author David
 */
public class Altas {
    
    public static void altaEmpresa(ObjectContainer baseDatos, Empresa empresa){
        baseDatos.store(empresa);
    }
    
    public static void empleado(ObjectContainer baseDatos, Empleado empleado, Empresa empresa){
        empresa.getEmpleados().add(empleado);
        baseDatos.store(empleado);
        altaEmpresa(baseDatos, empresa);
    }
    
    public static void producto(ObjectContainer baseDatos, Producto producto, Empresa empresa){
        empresa.getProductos().add(producto);
        baseDatos.store(producto);
        altaEmpresa(baseDatos, empresa);
    }
    
    public static void venta(ObjectContainer baseDatos, Venta venta, EmpleadoTemporal empleadoTemporal, Empresa empresa){
        empleadoTemporal.getVentas().add(venta);
        baseDatos.store(venta);
        empleado(baseDatos, empleadoTemporal, empresa);
    }
}
