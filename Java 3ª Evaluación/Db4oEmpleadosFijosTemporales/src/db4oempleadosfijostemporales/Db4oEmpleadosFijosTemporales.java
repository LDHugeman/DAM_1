package db4oempleadosfijostemporales;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class Db4oEmpleadosFijosTemporales {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDEmpleados");
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Menu.menuAltas(baseDatos, lee);
                    break;
                case 2:
                    Menu.menuBajas(baseDatos, lee);
                    break;
                case 3:
                    Menu.menuModificaciones(baseDatos, lee);
                    break;
                case 4:
                    Menu.menuVisualizar(baseDatos, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
        baseDatos.close();
    }

}
