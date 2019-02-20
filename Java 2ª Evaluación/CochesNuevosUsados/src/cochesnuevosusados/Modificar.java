package cochesnuevosusados;

import java.io.BufferedReader;
import java.io.IOException;
import objetos.CocheAlquiler;

/**
 *
 * @author David
 */
public class Modificar {

    public static void modificarPrecioDiaAlquiler(CocheAlquiler coche, BufferedReader lee) throws IOException {
        System.out.printf("Nuevo precio que se paga por día de alquiler: ");
        coche.setPrecioDia(Float.parseFloat(lee.readLine()));
    }
}
