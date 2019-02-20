package cochesnuevosusados;

import java.util.ArrayList;
import objetos.Coche;

/**
 *
 * @author David
 */
public class Bajas {

    public static void eliminarCoche(Coche coche, ArrayList<Coche> coches) {
        coches.remove(coche);
    }
}
