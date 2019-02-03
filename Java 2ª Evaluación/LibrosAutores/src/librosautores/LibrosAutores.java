package librosautores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import objetos.Autor;
import objetos.Libro;
/**
 *
 * @author a18luisdvp
 */
public class LibrosAutores {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;       
        ArrayList<Autor> autores=null;
        ArrayList<Libro> libros= new ArrayList<>();
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch(opcionSeleccionada){
                case 1:
                    autores = Menu.menuAltas(autores, libros, lee);
                    break;
                case 2:
                    Menu.menuModificaciones(libros, lee);
                    break;
                case 3:
                    Menu.menuBajas(autores, libros, lee);
                    break;
                case 4:
                    Menu.menuConsultas(autores, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe");
            }
        } while (opcionSeleccionada != 0);
    }
}
