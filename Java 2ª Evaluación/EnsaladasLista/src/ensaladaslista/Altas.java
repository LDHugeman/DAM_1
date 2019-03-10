package ensaladaslista;

import objetos.Ensalada;

/**
 *
 * @author David
 */
public class Altas {

    public static Ensalada nuevaEnsalada(Ensalada cabecera, Ensalada nuevaEnsalada) {
        if (cabecera == null) {
            cabecera = nuevaEnsalada;
        } else {
            cabecera = insertarEnsaladaOrdernadaPorFecha(cabecera, nuevaEnsalada);
        }
        return cabecera;
    }

    private static Ensalada insertarEnsaladaOrdernadaPorFecha(Ensalada cabecera, Ensalada nuevaEnsalada) {
        Ensalada actual = cabecera;
        Ensalada anterior = cabecera;
        while (actual != null && nuevaEnsalada.getFecha().getTime() > actual.getFecha().getTime()) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (anterior == actual) {
            if (actual != null && nuevaEnsalada.getFecha().getTime() == actual.getFecha().getTime()) {
                cabecera = insertarEnsaladaOrdernadaPorCodigo(actual, nuevaEnsalada);
            } else {
                nuevaEnsalada.setSiguiente(cabecera);
                cabecera = nuevaEnsalada;
            }
        } else {
            if (actual != null && nuevaEnsalada.getFecha().getTime() == actual.getFecha().getTime()) {
                anterior.setSiguiente(insertarEnsaladaOrdernadaPorCodigo(actual, nuevaEnsalada));
            } else {
                nuevaEnsalada.setSiguiente(actual);
                anterior.setSiguiente(nuevaEnsalada);
            }

        }
        return cabecera;
    }

    private static Ensalada insertarEnsaladaOrdernadaPorCodigo(Ensalada cabecera, Ensalada nuevaEnsalada) {
        Ensalada actual = cabecera;
        Ensalada anterior = cabecera;
        while (actual != null
                && nuevaEnsalada.getCodigo().compareToIgnoreCase(actual.getCodigo()) > 0
                && nuevaEnsalada.getFecha().getTime() == actual.getFecha().getTime()) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (anterior == actual) {
            nuevaEnsalada.setSiguiente(cabecera);
            cabecera = nuevaEnsalada;
        } else {
            nuevaEnsalada.setSiguiente(actual);
            anterior.setSiguiente(nuevaEnsalada);
        }
        return cabecera;
    }
}
