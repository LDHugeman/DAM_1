package yogurescola;

import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Altas {

    public static Yogourt altaNuevoYogur(Yogourt cabecera, Yogourt nuevoYogur) {
        Yogourt actual = cabecera;
        if (cabecera == null) {
            cabecera = nuevoYogur;
        } else {
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            nuevoYogur.setSiguiente(null);
            actual.setSiguiente(nuevoYogur);
        }
        return cabecera;
    }
}
