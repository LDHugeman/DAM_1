package librosal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author a18luisdvp
 */
public class LibrosAL {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Libro> libro = new ArrayList<Libro>();
        byte opcionSeleccionada = 0;
        String isbnBusqueda = null;
        int posicionIsbnEncontrada = 0;
        String libroBusqueda = null;
        int posicionLibroEncontrada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.asignarLibros(libro, lee);
                    break;
                case 2:
                    Introducir.Insertar(libro, lee);
                    break;
                case 3:
                    isbnBusqueda = Introducir.obtenerIsbnBusqueda(lee);
                    posicionIsbnEncontrada = Buscar.buscarLibroPorIsbn(libro, isbnBusqueda);
                    System.out.printf("Libro %s borrado. %n", libro.get(posicionIsbnEncontrada).getNombre());
                    Borrar.borrarLibroPorIsbn(libro, posicionIsbnEncontrada);             
                    break;
                case 4:
                    libroBusqueda = Introducir.obternerLibroBusqueda(lee);
                    posicionLibroEncontrada = Buscar.buscarLibroPorNombre(libro, libroBusqueda);
                    Modificar.modificarPrecioDeUnLibro(libro, lee, posicionLibroEncontrada);
                    System.out.printf("Libro modificado. %n");
                    break;
                case 5:
                    Ordenar.ordenarPorIntercambioAscendenteNombre(libro);
                    System.out.printf("Libros ordenados de forma ascendente. %n %n");
                    break;
                case 6:
                    Visualizar.verLibrosOrdenAscendenteNombre(libro);
                    break;
                case 7:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 7);
    }
}
