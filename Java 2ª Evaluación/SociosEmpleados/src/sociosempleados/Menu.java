package sociosempleados;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Empleado;
import objetos.Jefe;
import objetos.Socio;

/**
 *
 * @author David
 */
public class Menu {

    public static void menuAltas(BufferedReader lee, ArrayList<Empleado> empleados)throws IOException{
        byte opcionSeleccionada =0;
        do{
                opcionSeleccionada = seleccionarOpcionMenuAltas(lee);
            switch(opcionSeleccionada){
                    case 1:
                        Jefe jefe = Crear.crearNuevoJefe(lee, empleados);
                        Altas.altaNuevoEmpleado(lee, jefe, empleados);
                        break;
                    case 2:
                        Socio socio = Crear.crearNuevoSocio(lee, empleados);
                        Altas.altaNuevoEmpleado(lee, socio, empleados);
                        break;
                    case 0:
                        break;
                    default:
                        System.err.printf("Esa opción no existe %n");
                }
        }while(opcionSeleccionada!=0);

    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Altas");
        System.out.println("[2] Bajas");
        System.out.println("[3] Modificar sueldo y retención");
        System.out.println("[4] Visualizar Jefes");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) throws IOException {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Jefe");
        System.out.println("[2] Socio");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }
}
