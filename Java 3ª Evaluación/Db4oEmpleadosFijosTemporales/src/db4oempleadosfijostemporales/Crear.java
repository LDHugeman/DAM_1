
package db4oempleadosfijostemporales;

import java.io.BufferedReader;
import java.util.Date;
import objetos.Empresa;
import objetos.EmpleadoFijo;
import objetos.EmpleadoTemporal;
import objetos.Producto;
import objetos.Venta;

/**
 *
 * @author David
 */
public class Crear {
    
    public static Empresa nuevaEmpresa(BufferedReader lee) {
        String cif = obtenerCifEmpresa(lee);
        System.out.printf("Nombre: ");
        String nombre = Pedir.texto(lee);
        System.out.printf("Dirección: ");
        String direccion = Pedir.texto(lee);
        System.out.printf("Teléfono: ");
        String telefono = Pedir.texto(lee);
        return new Empresa(cif, nombre, direccion, telefono);   
    }
    
    public static EmpleadoFijo nuevoEmpleadoFijo(BufferedReader lee){
        String dni = obtenerDniEmpleado(lee);
        System.out.printf("Nombre: ");
        String nombre = Pedir.texto(lee);
        System.out.printf("Teléfono: ");
        String telefono = Pedir.texto(lee);
        float porcentajeRetencion = obtenerPorcentajeRetencionEmpleado(lee);
        int salarioBase = obtenerSalarioBaseEmpleadoFijo(lee);
        System.out.printf("Trienios: ");
        int trienios = Pedir.numeroEntero(lee);
        return new EmpleadoFijo(dni, nombre, telefono, porcentajeRetencion, salarioBase, trienios);
    }
    
    public static EmpleadoTemporal nuevoEmpleadoTemporal(BufferedReader lee){
        String dni = obtenerDniEmpleado(lee);
        System.out.printf("Nombre: ");
        String nombre = Pedir.texto(lee);
        System.out.printf("Teléfono: ");
        String telefono = Pedir.texto(lee);
        float porcentajeRetencion = obtenerPorcentajeRetencionEmpleado(lee);
        System.out.printf("Fecha de inicio(dd/MM/yyyy): ");
        Date fechaInicio = Pedir.fecha(lee);
        System.out.printf("Fecha de fin(dd/MM/yyyy): ");
        Date fechaFin = Pedir.fecha(lee);
        float pagoDia = obtenerPagoDiaEmpleadoTemporal(lee);
        return new EmpleadoTemporal(dni, nombre, telefono, porcentajeRetencion, fechaInicio, fechaFin, pagoDia);
    }
    
    public static Producto nuevoProducto(BufferedReader lee){
        String codigo = obtenerCodigoProducto(lee);
        System.out.printf("Descripción del artículo: ");
        String descripcionArticulo = Pedir.texto(lee);
        System.out.printf("Unidades en el almacén: ");
        int stockAlmacen = Pedir.numeroEntero(lee);      
        float precioUnitario = obtenerPrecioProducto(lee);
        return new Producto(codigo, descripcionArticulo, stockAlmacen, precioUnitario);
    }
    
    public static Venta nuevaVenta(Producto producto, BufferedReader lee){
        System.out.printf("Fecha de la venta(dd/MM/yyyy): ");
        Date fechaVenta = Pedir.fecha(lee);
        System.out.printf("Número de unidades vendidas: ");
        int numeroUnidades = Pedir.numeroEntero(lee);
        return new Venta(fechaVenta, numeroUnidades, producto);
    }
    
    public static String obtenerCodigoProducto(BufferedReader lee){
        System.out.printf("Código: ");
        return Pedir.texto(lee);
    }
    
    public static String obtenerDniEmpleado(BufferedReader lee){
        System.out.printf("Dni: ");
        return Pedir.texto(lee);
    }
    
    public static float obtenerPrecioProducto(BufferedReader lee){
        System.out.printf("Precio por unidad: ");
        return Pedir.numeroRealFloat(lee);
    }
    
    public static int obtenerSalarioBaseEmpleadoFijo(BufferedReader lee){
        System.out.printf("Salario base: ");
        return Pedir.numeroEntero(lee);
    }
    
    public static float obtenerPorcentajeRetencionEmpleado(BufferedReader lee){
        System.out.printf("Porcentaje de retención: ");
        return Pedir.numeroRealFloat(lee);
    }
    
    public static float obtenerPagoDiaEmpleadoTemporal(BufferedReader lee){
        System.out.printf("Pago por día: ");
        return Pedir.numeroRealFloat(lee);
    }
    
    public static String obtenerCifEmpresa(BufferedReader lee){
        System.out.printf("Cif: ");
        return Pedir.texto(lee);
    }
}
