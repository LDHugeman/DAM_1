
package alumnoscamiones;

import interfaces.I_Nexo;
import java.util.ArrayList;
import objetos.Alumno;
import objetos.Asignatura;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Visualizar {
    
    public static void mostrarAlumno(Alumno alumno){
        System.out.println("-------------------------------------------");
        System.out.println("Nombre: "+alumno.getNombre());
        System.out.println("Dni: "+alumno.getDni());
        System.out.println("Ciclo: "+alumno.getCiclo());
        System.out.println("Nota media: "+alumno.calcular());
        System.out.println("--- Asignaturas ---");
        mostrarAsignaturas(alumno.getAsignaturas());
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarAsignatura(Asignatura asignatura){
        System.out.println("---------------------");
        System.out.println("Nombre: "+asignatura.getNombre());
        System.out.println("Nota: "+asignatura.getNota());
        System.out.println("---------------------");
    }
    
    public static void mostrarAsignaturas(ArrayList<Asignatura> asignaturas){
        for(Asignatura asignatura:asignaturas){
            mostrarAsignatura(asignatura);
        }
    }
    
    public static void mostrarAlumnos(ArrayList<Alumno> alumnos){       
        for(Alumno alumno:alumnos){
            mostrarAlumno(alumno);
        }
    }
    
    public static void mostrarCamion(Camion camion){
        System.out.println("-------------------------------------------");
        System.out.println("Propietario: " + camion.getPropietario());
        System.out.println("Matrícula: "+camion.getMatricula());
        System.out.println("Cuentakilómetros inicio: "+camion.getKmInicio());
        System.out.println("Cuentakilómetros fin: "+camion.getKmFin());
        System.out.println("Litros repostados: "+ camion.getLitros());
        System.out.println("Consumo: "+ camion.getConsumo());
        System.out.println("-------------------------------------------");
    }
    
    public static void mostrarCamiones(ArrayList<Camion> camiones){
        for(Camion camion:camiones){
            mostrarCamion(camion);
        }
    }
}
