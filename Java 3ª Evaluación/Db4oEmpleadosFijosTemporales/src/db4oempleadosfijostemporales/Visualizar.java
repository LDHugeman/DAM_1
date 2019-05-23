
package db4oempleadosfijostemporales;

import java.util.ArrayList;
import objetos.Empleado;
import objetos.EmpleadoFijo;
import objetos.EmpleadoTemporal;
import objetos.Empresa;
import objetos.Producto;

/**
 *
 * @author David
 */
public class Visualizar {
    
    public static void mostrarEmpleado(Empleado empleado){
        if(empleado instanceof EmpleadoFijo){
            System.out.println("---------------------- EMPLEADO FIJO ----------------------");
        } else if(empleado instanceof EmpleadoTemporal){
            System.out.println("---------------------- EMPLEADO TEMPORAL ----------------------");
        }   
        System.out.println("Dni: "+empleado.getDni());
        System.out.println("Nombre: "+empleado.getNombre());
        System.out.println("Teléfono: "+empleado.getTelefono());
        System.out.println("Porcentaje de retención: "+empleado.getPorcentajeRetencion());
        if(empleado instanceof EmpleadoFijo){
            System.out.println("Salario base: "+((EmpleadoFijo) empleado).getSalarioBase());
            System.out.println("Trienios: "+((EmpleadoFijo) empleado).getTrienios());
        } else if (empleado instanceof EmpleadoTemporal){
            System.out.println("Fecha de inicio(dd/MM/yyyy): "+((EmpleadoTemporal) empleado).getStringFechaInicio());
            System.out.println("Fecha de fin(dd/MM/yyyy): "+((EmpleadoTemporal) empleado).getStringFechaFin());
            System.out.println("Pago por día: "+((EmpleadoTemporal) empleado).getPagoDia());
        }
        System.out.println("--------------------------------------------");
    }
    
    public static void mostrarEmpleados(ArrayList<Empleado> empleados){
        for(Empleado empleado:empleados){
            mostrarEmpleado(empleado);
        }
    }
    
    public static void mostrarEmpresa(Empresa empresa){
        System.out.println("---------------------- EMPRESA ----------------------");
        System.out.println("Cif: "+empresa.getCif());
        System.out.println("Nombre: "+empresa.getNombre());
        System.out.println("Dirección: "+empresa.getDireccion());
        System.out.println("Teléfono: "+empresa.getTelefono());
        System.out.println("--------------------------------------------");
        mostrarEmpleados(empresa.getEmpleados());
    }
    
    public static void mostrarEmpresas(ArrayList<Empresa> empresas){
        for(Empresa empresa:empresas){
            mostrarEmpresa(empresa);
        }
    }
    
    public static void mostrarProducto(Producto producto){
        System.out.println("---------------------- PRODUCTO ----------------------");
        System.out.println("Código: "+producto.getCodigo());
        System.out.println("Descripción del artículo: "+producto.getDescripcionArticulo());
        System.out.println("Unidades en el almacén: "+producto.getStockAlmacen());
        System.out.println("Precio por unidad: "+producto.getPrecioUnitario());
        System.out.println("--------------------------------------------");
    }
    
    public static void mostrarProductos(Empresa empresa){
        for(Producto producto:empresa.getProductos()){
            mostrarProducto(producto);
        }
    }
}
