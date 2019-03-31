package librosautoresfichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class LibrosAutoresFichero {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        File fichero = new File("autores.dat");
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Archivo.nuevoFichero(fichero, lee);
                    break;
                case 2:
                    Menu.menuAltas(fichero, lee);
                    break;
                case 3:
                    Menu.menuBajas(fichero, lee);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Esa opción no existe");
            }
        } while (opcionSeleccionada != 0);
    }

}
