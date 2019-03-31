package librosautoresfichero;

import Objetos.Autor;
import Objetos.Libro;
import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author David
 */
public class Bajas {

    public static void bajaAutor(File fichero, Autor autorEncontrado) {
        File temporal = Archivo.obtenerTemporal(fichero, autorEncontrado);
        fichero.delete();
        temporal.renameTo(fichero);
    }

    public static void bajaLibro(File fichero, String titulo, BufferedReader lee) {
        Autor autorEncontrado = Consultar.encontrarAutorPorTituloLibro(fichero, titulo);
        if (autorEncontrado != null) {
            Visualizar.mostrar(autorEncontrado);
            Libro libroEncontrado = null;
            for (Libro libro : autorEncontrado.getLibros()) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    libroEncontrado = libro;
                }
            }
            Visualizar.mostrar(libroEncontrado);
            System.out.println("¿Es este el libro que desea borrar?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opcion: ");
            byte opcion = Pedir.numeroByte(lee);
            if (opcion == 1) {
                autorEncontrado.getLibros().remove(libroEncontrado);
                File temporal = Archivo.obtenerTemporal(fichero, autorEncontrado);
                Altas.autor(temporal, autorEncontrado);
                fichero.delete();
                temporal.renameTo(fichero);
                System.out.println("El libro " + libroEncontrado.getTitulo() + " ha sido eliminado");
            }
        } else {
            System.err.printf("No hay un libro con ese título %n");
        }
    }
}
