package librosal;

import java.util.*;

/**
 *
 * @author Luis David
 */
public class Buscar {

    public static int buscarLibroPorIsbn(ArrayList<Libro> libros, String isbnBusqueda) {
        Ordenar.ordenarPorIntercambioAscendenteIsbn(libros);
        int low = 0;
        int high = libros.size() - 1;

        while (low < high) {
            int puntoMedio = (low + high) / 2;
            if (isbnBusqueda.compareToIgnoreCase(libros.get(puntoMedio).getIsbn()) == 0) {
                low = puntoMedio;
                high = puntoMedio;
            }else if(isbnBusqueda.compareToIgnoreCase(libros.get(puntoMedio).getIsbn()) < 0){
                high = puntoMedio -1;
            }else{
                low = puntoMedio + 1;
            }
        }
        
        if(isbnBusqueda.compareToIgnoreCase(libros.get(low).getIsbn()) == 0){
            return low;
        } else {
            System.err.printf("No se encuentra ese isbn. %n");
            return low = -1;
        }
    }
    
    public static int buscarLibroPorNombre(ArrayList<Libro> libros, String libroBusqueda) {
        Ordenar.ordenarPorIntercambioAscendenteNombre(libros);
        int low = 0;
        int high = libros.size() - 1;

        while (low < high) {
            int puntoMedio = (low + high) / 2;
            if (libroBusqueda.compareToIgnoreCase(libros.get(puntoMedio).getNombre()) == 0) {
                low = puntoMedio;
                high = puntoMedio;
            }else if(libroBusqueda.compareToIgnoreCase(libros.get(puntoMedio).getNombre()) < 0){
                high = puntoMedio -1;
            }else{
                low = puntoMedio + 1;
            }
        }
        
        if(libroBusqueda.compareToIgnoreCase(libros.get(low).getNombre()) == 0){
            return low;
        } else {
            System.err.printf("No se encuentra ese libro. %n");
            return low = -1;
        }
    }
}
