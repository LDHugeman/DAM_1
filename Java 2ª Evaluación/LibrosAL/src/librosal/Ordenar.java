package librosal;

import java.util.*;

/**
 *
 * @author Luis David
 */
public class Ordenar {

    public static void ordenarPorIntercambioAscendenteIsbn(ArrayList<Libro> libro) {
        Libro aux;
        boolean estaOrdenado = false;
        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < libro.size() - 1; i++) {
                if (libro.get(i).getIsbn().compareToIgnoreCase(libro.get(i + 1).getIsbn()) > 0) {
                    aux = libro.get(i);
                    libro.set(i, libro.get(i + 1));
                    libro.set(i + 1, aux);

                    estaOrdenado = false;
                }
            }
        }
    }
    
    public static void ordenarPorIntercambioAscendenteNombre(ArrayList<Libro> libro) {
        Libro aux;
        boolean estaOrdenado = false;
        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < libro.size() - 1; i++) {
                if (libro.get(i).getNombre().compareToIgnoreCase(libro.get(i + 1).getNombre()) > 0) {
                    aux = libro.get(i);
                    libro.set(i, libro.get(i + 1));
                    libro.set(i + 1, aux);

                    estaOrdenado = false;
                }
            }
        }
    }
}
