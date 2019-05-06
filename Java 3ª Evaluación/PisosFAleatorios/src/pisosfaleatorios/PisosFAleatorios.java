
package pisosfaleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class PisosFAleatorios {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader (new InputStreamReader(System.in));
        File fichero = new File("Pisos.dat");
        byte opcionSeleccionada = 0;
        do{
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch(opcionSeleccionada){
                case 1:
                    Menu.menuAltas(lee, fichero);
                    break;
                case 2:                   
                    Bajas.piso(fichero, Crear.obtenerReferencia(lee));
                    break;
                case 3:
                    Modificar.modificar(fichero, Crear.obtenerReferencia(lee), lee);
                    break;
                case 4:
                    Menu.menuVisualizar(lee, fichero);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción");                      
            }
        }while(opcionSeleccionada!=0);
    }       
}
