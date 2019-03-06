package yogurescola;

import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Bajas {

    public static Yogourt eliminarYogur(Yogourt cabecera, Yogourt yogur) {
        Yogourt actual = cabecera;
        if (cabecera.equals(yogur)) {
            cabecera = cabecera.getSiguiente();

        } else {
            while (actual != null && actual.getSiguiente() != null) {
                if (actual.getSiguiente().equals(yogur)) {
                    actual.setSiguiente(yogur.getSiguiente());
                }
                actual = actual.getSiguiente();
            }
        }
        return cabecera;
    }
}
