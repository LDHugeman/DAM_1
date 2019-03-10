
package listalinealalumnos;
import Clases.*;

// @author 




public class Visualizar {
    
    public static void visualizar(C_Alumno p) {
        
        
        System.out.printf("%n%n--Alumno:"
                + "%nNombre:%10s"
                + "%nMódulo:%-5s"
                + "%nNota:%-2.2f"
                + "%n%n",p.getNombre(),p.getModulo(),p.getNota());

    }
    
        public static void visualizarListado(C_Alumno p) {
        
        System.out.printf("--LISTA DE ALUMNOS--"
                +"%n%n    Alumno       Modulo       Nota"
                +"%n_____________________________________");
        
        while (p != null) 
        {
            System.out.printf("%n%-10s %-10s %14.2f", p.getNombre(), p.getModulo(), p.getNota());
            p=p.getSiguiente();
        }

    }
    
    public static void visualizarAprobados(C_Alumno p) {
        
        System.out.printf("--LISTA DE ALUMNOS APROBADOS--"
                +"%n%n    Alumno       Modulo       Nota"
                +"%n_____________________________________");
        
        while (p != null) 
        {
            if(p.getNota()>=5)
            {
                System.out.printf("%n%-10s %-10s %14.2f", p.getNombre(), p.getModulo(), p.getNota());
            }
            p=p.getSiguiente();
        }

    }
    
    public static void visualizar() {
        
        System.out.printf("%n--Alumno no encontrado--%n");
    }
    
}
