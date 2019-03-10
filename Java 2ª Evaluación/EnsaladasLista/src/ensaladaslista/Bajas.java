package ensaladaslista;

import objetos.Ensalada;

/**
 *
 * @author David
 */
public class Bajas {

    public static Ensalada eliminarEnsaladasCaducadas(Ensalada cabecera) {
        Ensalada actual = cabecera;
        while (actual != null) {
            if (Visualizar.estaEnsaladaCaducada(actual)) {
                cabecera = eliminarEnsaladaCaducada(cabecera, actual);
            }
            actual = actual.getSiguiente();
        }
        return cabecera;
    }

    public static Ensalada eliminarEnsaladaCaducada(Ensalada cabecera, Ensalada ensaladaCaducada) {
        Ensalada actual = cabecera;
        if (cabecera.equals(ensaladaCaducada)) {
            cabecera = cabecera.getSiguiente();

        } else {
            while (actual != null && actual.getSiguiente() != null) {
                if (actual.getSiguiente().equals(ensaladaCaducada)) {
                    actual.setSiguiente(ensaladaCaducada.getSiguiente());
                }
                actual = actual.getSiguiente();
            }
        }
        return cabecera;
    }
}
