
package db4oempleadosfijostemporales;

import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import objetos.Empleado;
import objetos.EmpleadoFijo;
import objetos.EmpleadoTemporal;
import objetos.Empresa;
import objetos.Producto;

/**
 *
 * @author David
 */
public class Modificar {
    
    public static void precioProducto(ObjectContainer baseDatos, Empresa empresa, Producto producto, BufferedReader lee){
        System.out.println("--- Inserte el nuevo precio del producto ---");
        producto.setPrecioUnitario(Crear.obtenerPrecioProducto(lee));
        Altas.altaEmpresa(baseDatos, empresa);
        System.out.println("Precio del producto con código " + producto.getCodigo() + " modificado");
    }
    
    public static void sueldoBaseEmpleadoFijo(ObjectContainer baseDatos, Empresa empresa, EmpleadoFijo empleadoFijo, BufferedReader lee){
        System.out.println("--- Inserte el nuevo sueldo base del empleado fijo ---");
        empleadoFijo.setSalarioBase(Crear.obtenerSalarioBaseEmpleadoFijo(lee));
        Altas.altaEmpresa(baseDatos, empresa);
        System.out.println("Salario base del empleado fijo con dni " + empleadoFijo.getDni() + " modificado");
    }
    
    public static void porcentajeRetencionEmpleado(ObjectContainer baseDatos, Empresa empresa, Empleado empleado, BufferedReader lee){
        System.out.println("--- Inserte el nuevo porcentaje de retención del empleado ---");
        empleado.setPorcentajeRetencion(Crear.obtenerPorcentajeRetencionEmpleado(lee));
        Altas.altaEmpresa(baseDatos, empresa);
        System.out.println("Porcentaje de retención del empleado con dni " + empleado.getDni() + " modificado");
    }
    
    public static void pagoDiaEmpleadoTemporal(ObjectContainer baseDatos, Empresa empresa, EmpleadoTemporal empleadoTemporal, BufferedReader lee){
        System.out.println("--- Inserte el pago por día del empleado temporal ---");
        empleadoTemporal.setPagoDia(Crear.obtenerPagoDiaEmpleadoTemporal(lee));
        Altas.altaEmpresa(baseDatos, empresa);
        System.out.println("Pago por día del empleado temporal con dni " + empleadoTemporal.getDni() + " modificado");
    }
}
