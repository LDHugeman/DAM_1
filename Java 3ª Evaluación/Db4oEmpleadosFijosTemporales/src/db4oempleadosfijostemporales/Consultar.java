
package db4oempleadosfijostemporales;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import objetos.Empleado;
import objetos.EmpleadoFijo;
import objetos.EmpleadoTemporal;
import objetos.Empresa;
import objetos.Producto;
import objetos.Venta;

/**
 *
 * @author David
 */
public class Consultar {
    
    public static Producto obtenerProductoPorCodigo(ObjectContainer baseDatos, String codigo){
        Producto producto = null;
        Producto productoABuscar = new Producto(codigo, null, 0, 0);
        ObjectSet resultado = baseDatos.queryByExample(productoABuscar);
        while (resultado.hasNext()) {
            producto = (Producto)resultado.next();
        }
        return producto;
    }
    
    public static boolean existeProductoPorCodigo(ObjectContainer baseDatos, String codigo){
        return obtenerProductoPorCodigo(baseDatos, codigo) !=null;
    }
    
    public static Empleado obtenerEmpleadoPorDni(ObjectContainer baseDatos, String dni){
        Empleado empleado = null;
        Query query = baseDatos.query();
        query.constrain(Empleado.class);
        query.descend("dni").constrain(dni);
        ObjectSet resultado = query.execute();
        while (resultado.hasNext()) {
            empleado = (Empleado)resultado.next();
        }
        return empleado;
    }
    
    public static boolean existeEmpleadoPorDni(ObjectContainer baseDatos, String dni){
        return obtenerEmpleadoPorDni(baseDatos, dni) !=null;
    }
    
    
    public static EmpleadoFijo obtenerEmpleadoFijoPorDni(ObjectContainer baseDatos, String dni){
        EmpleadoFijo empleadoFijo = null;
        EmpleadoFijo empleadoFijoABuscar = new EmpleadoFijo(dni, null, null, 0, 0, 0);
        ObjectSet resultado = baseDatos.queryByExample(empleadoFijoABuscar);
        while (resultado.hasNext()) {
            empleadoFijo = (EmpleadoFijo)resultado.next();
        }
        return empleadoFijo;
    }
    
    public static boolean existeEmpleadoFijoPorDni(ObjectContainer baseDatos, String dni){
        return obtenerEmpleadoFijoPorDni(baseDatos, dni) !=null;
    }
    
    public static EmpleadoTemporal obtenerEmpleadoTemporalPorDni(ObjectContainer baseDatos, String dni){
        EmpleadoTemporal empleadoTemporal = null;
        EmpleadoTemporal empleadoTemporalABuscar = new EmpleadoTemporal(dni, null, null, 0, null, null, 0);
        ObjectSet resultado = baseDatos.queryByExample(empleadoTemporalABuscar);
        while (resultado.hasNext()) {
            empleadoTemporal = (EmpleadoTemporal)resultado.next();
        }
        return empleadoTemporal;
    }
    
    public static boolean existeEmpleadoTemporalPorDni(ObjectContainer baseDatos, String dni){
        return obtenerEmpleadoTemporalPorDni(baseDatos, dni) !=null;
    }
    
    public static ArrayList<Empresa> obtenerEmpresas(ObjectContainer baseDatos){
        ArrayList<Empresa> empresas= new ArrayList<>();
        Query query = baseDatos.query();
        query.constrain(Empresa.class);
        ObjectSet resultado = query.execute();
        while (resultado.hasNext()) {
            empresas.add((Empresa)resultado.next());
        }
        if(empresas.isEmpty()){
            System.err.println("No hay ninguna empresa registrada");
        }
        return empresas;
    }
    
    public static Empresa obtenerEmpresaPorCif(ObjectContainer baseDatos, String cif){
        Empresa empresa = null;
        Query query = baseDatos.query();
        query.constrain(Empresa.class);
        query.descend("cif").constrain(cif);
        ObjectSet resultado = query.execute();
        while (resultado.hasNext()) {
            empresa = (Empresa)resultado.next();
        }
        return empresa;
    }
    
    public static boolean existeEmpresaPorCif(ObjectContainer baseDatos, String cif){
        return obtenerEmpresaPorCif(baseDatos, cif) !=null;
    }
    
    public static float obtenerImporteVentasEmpleadoTemporalEntreFechas(ArrayList<Venta> ventas, EmpleadoTemporal empleadoTemporal){
        ArrayList<Venta> ventasEmpleadoTemporal = new ArrayList<>();
        for(Venta venta:ventas){
            if(venta.getFechaVenta().getTime()>empleadoTemporal.getFechaInicio().getTime() && venta.getFechaVenta().getTime()<empleadoTemporal.getFechaFin().getTime()){
                ventasEmpleadoTemporal.add(venta);
            }
        }
        if(ventasEmpleadoTemporal.isEmpty()){
            System.out.println("El empleado temporal no ha realizado ninguna venta");
        }
        float importeTotal = 0;
        for(Venta venta:ventasEmpleadoTemporal){
            importeTotal += venta.getImporte();
        } 
        return importeTotal;
    }
}
