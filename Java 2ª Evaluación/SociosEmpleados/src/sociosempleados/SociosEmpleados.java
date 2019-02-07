package sociosempleados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import objetos.Empleado;

/**
 *
 * @author David
 */
public class SociosEmpleados {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Empleado> empleados = new ArrayList<>();
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Menu.menuAltas(lee, empleados);
                    break;
                case 2:
                    Empleado empleadoEncontradoPorDni = Consultar.buscarEmpleadoPorDni(Crear.pedirDni(lee), empleados);
                    if (empleadoEncontradoPorDni != null) {
                        Bajas.eliminarEmpleado(empleadoEncontradoPorDni, empleados);
                        System.out.printf("Empleado %s borrado. %n", empleadoEncontradoPorDni.getNombre());
                    }
                    break;
                case 3:
                    String nombreBusqueda = Crear.pedirNombre(lee);
                    Empleado empleadoEncontrado = Consultar.encontrarEmpleadoPorNombre(nombreBusqueda, empleados);
                    if(empleadoEncontrado!=null){
                        Modificar.sueldoYRetencion(empleadoEncontrado, lee);
                        System.out.printf("Sueldo y retención del empleado %s modificados. %n", empleadoEncontrado.getNombre());
                        System.out.printf("El nuevo sueldo es %d. %n", empleadoEncontrado.getSueldo());
                        System.out.printf("El nuevo porcentaje de retención es %d. %n",empleadoEncontrado.getPorcentajeRetencion());
                    }else{
                        System.err.printf("No se ha encontrado al empleado %s %n", nombreBusqueda);
                    }
                    break;
                case 4:
                    Visualizar.verJefes(empleados);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

}
