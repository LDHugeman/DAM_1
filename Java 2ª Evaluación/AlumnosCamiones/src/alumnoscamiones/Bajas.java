
package alumnoscamiones;

import interfaces.I_Nexo;
import java.util.ArrayList;
import objetos.Alumno;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Bajas {
    
    public static void eliminarAlumno(Alumno alumno, ArrayList<I_Nexo> listado){
        listado.remove(alumno);
    }
    
    public static void eliminarCamion(Camion camion, ArrayList<I_Nexo> listado){
        listado.remove(camion);
    }
    
}
