
package alumnoscamiones;

import java.io.BufferedReader;
import java.io.IOException;
import objetos.Alumno;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Modificar {
    
    public static Camion modificarPropietarioCamion(Camion camion, BufferedReader lee)throws IOException{
        System.out.printf("Introduzca un nuevo propietario: ");
        String propietario = lee.readLine();
        camion.setPropietario(propietario);
        return camion;
    }
    
    public static Alumno modificarCicloAlumno(Alumno alumno,BufferedReader lee)throws IOException{
        System.out.printf("Introduzca un nuevo ciclo: ");
        String ciclo = lee.readLine();
        alumno.setCiclo(ciclo);
        return alumno;
    }
}
