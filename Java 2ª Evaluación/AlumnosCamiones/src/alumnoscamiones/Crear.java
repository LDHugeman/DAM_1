
package alumnoscamiones;

import interfaces.I_Nexo;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Alumno;
import objetos.Asignatura;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Crear {
    
    public static Alumno crearNuevoAlumno(Asignatura primerAsignatura, ArrayList<I_Nexo> listado, BufferedReader lee)throws IOException{
        String dni= pedirNuevoDni(lee, listado);
        System.out.printf("Nombre: ");
        String nombre = lee.readLine();
        System.out.printf("Ciclo: ");
        String ciclo = lee.readLine();
        return new Alumno(dni, nombre, ciclo, primerAsignatura);
    }
    
    public static Camion crearNuevoCamion(BufferedReader lee)throws IOException{
        System.out.printf("Propietario: ");
        String propietario = lee.readLine();      
        String matricula = pedirMatricula(lee);
        System.out.printf("Estado del cuentakilómetros la penúltima vez que se repostó: ");
        Float kmInicio = Float.parseFloat(lee.readLine());
        System.out.printf("Estado del cuentakilómetros la última vez que se repostó: ");
        Float kmFin = Float.parseFloat(lee.readLine());
        System.out.printf("Litros repostados: ");
        Float litros = Float.parseFloat(lee.readLine());
        return new Camion(propietario, matricula, kmInicio, kmFin, litros);
    }
    
    public static String pedirMatricula(BufferedReader lee)throws IOException{
        System.out.printf("Matrícula: ");
        return lee.readLine();
    }
    
    public static Asignatura crearNuevaAsignatura(BufferedReader lee) throws IOException{
        System.out.printf("Nombre: ");
        String nombre = lee.readLine();
        System.out.printf("Nota: ");
        Float nota = Float.parseFloat(lee.readLine());
        return new Asignatura(nombre, nota);
    }
    public static String pedirNuevoDni(BufferedReader lee, ArrayList<I_Nexo> listado) throws IOException {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = lee.readLine();
        } while (!Validar.esDniValido(dni, listado));
        return dni;
    }
    
    public static String pedirDniExistente(BufferedReader lee, ArrayList<I_Nexo> listado) throws IOException {
        String dni = "";
        do {
            System.out.printf("Dni: ");
            dni = lee.readLine();
        } while (!Validar.esDniValidoExistente(dni, listado));
        return dni;
    }
}
