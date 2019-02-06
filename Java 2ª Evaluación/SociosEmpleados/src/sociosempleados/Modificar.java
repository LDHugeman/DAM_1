
package sociosempleados;

import java.io.BufferedReader;
import java.io.IOException;
import objetos.Empleado;

/**
 *
 * @author David
 */
public class Modificar {
    
    public static void sueldoYRetencion(Empleado empleado, BufferedReader lee)throws IOException{
        System.out.printf("Nuevo sueldo: ");       
        empleado.setSueldo(Integer.parseInt(lee.readLine()));
        System.out.printf("Nuevo porcentaje de retención: ");
        empleado.setPorcentajeRetencion(Integer.parseInt(lee.readLine()));
    }
}
