
package notasexamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author a18luisdvp
 */
public class NotasExamen {
    
    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String [] alumnos = new String [5];
        float [] notas = new float [5];
        String [] alumnosAprobados = null;
        float [] notasAprobados = null;
        String [] alumnosSuspensos = null;
        float [] notasSuspensos = null;
        float [] notasFinales = null;
        byte opcionSeleccionada;
        boolean datosCargados = false;
        do{
            opcionSeleccionada = Menu.seleccionarOpcion(lee);           
            switch(opcionSeleccionada){
                case 1:
                    alumnos = Introducir.cargarAlumnos(alumnos, lee);
                    notas = Introducir.cargarNotas(notas, alumnos, lee);
                    datosCargados = true;
                    break;
                case 2:
                    if(datosCargados){      
                        int numeroAprobados = Separar.obterNumeroAprobados(notas);
                        alumnosAprobados = new String[numeroAprobados];
                        notasAprobados = new float[numeroAprobados];
                        alumnosSuspensos = new String [alumnos.length - numeroAprobados];
                        notasSuspensos = new float[notas.length - numeroAprobados];
                        Separar.cargarAlumnosNotasAprobadas(alumnos, notas, alumnosAprobados, notasAprobados);
                        Separar.cargarAlumnosNotasSuspensas(alumnos, notas, alumnosSuspensos, notasSuspensos); 
                        System.out.printf("NOTAS SEPARADAS.");
                    }else{
                        System.err.printf("No hay datos introducidos.%n");
                    }
                    break;
                case 3:
                    if(datosCargados){
                        Modificar.subirNotasSuspensas(notas);
                        System.out.printf("NOTAS SUBIDAS.");
                    }else{
                        System.err.printf("No hay datos introducidos.%n");
                    }                 
                    break;
                case 4:
                    if(datosCargados){                        
                        Visualizar.verTodo(alumnos, notas, alumnosAprobados, notasAprobados, alumnosSuspensos, notasSuspensos, notasFinales);                       
                    }else{
                        System.err.printf("No hay datos introducidos.%n");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.err.printf("Esa opción non existe.%n");                    
            }
        }while(opcionSeleccionada!=5);
    }
    
}
