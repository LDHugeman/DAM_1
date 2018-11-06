
package notasexamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class NotasExamen {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String [] alumnos = new String [5];
        float [] notas = new float [5];
        byte opcionSeleccionada;
        do{
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch(opcionSeleccionada){
                case 1:
                    Introducir.cargarAlumnos(alumnos, lee);
                    Introducir.cargarNotas(notas, alumnos, lee);                   
            }
        }while(opcionSeleccionada!=5);
    }
    
}
