package librosautoresfichero;

import Objetos.Autor;
import Objetos.Libro;
import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author a18luisdvp
 */
public class Modificar {

    public static void precioLibro(File fichero, BufferedReader lee) {
        System.out.println("--- Inserte nombre del autor ---");
        Autor autorEncontrado = Consultar.encontrarAutorPorNombre(fichero, Crear.pedirNombre(lee));
        if (autorEncontrado != null) {
            System.out.println("--- Inserte título del libro ---");
            String titulo = Crear.pedirTitulo(lee);
            Libro libroEncontrado = null;
            for (Libro libro : autorEncontrado.getLibros()) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    libroEncontrado = libro;
                }
            }
            if (libroEncontrado != null) {
                Visualizar.mostrar(libroEncontrado);
                System.out.println("¿Es este el libro al que desea modificar el precio?");
                System.out.println("[1] Sí");
                System.out.println("[2] No");
                System.out.printf("Seleccione una opcion: ");
                byte opcion = Pedir.numeroByte(lee);
                if (opcion == 1) {
                    System.out.println("--- Introduzca el nuevo precio ---");
                    libroEncontrado.setPrecio(Crear.pedirPrecio(lee));
                    File temporal = Archivo.obtenerTemporal(fichero, autorEncontrado);
                    Altas.autor(temporal, autorEncontrado);
                    fichero.delete();
                    temporal.renameTo(fichero);
                    System.out.println("Se ha modificado el precio del libro " + libroEncontrado.getTitulo() + ".");
                }
            }else{
                System.err.printf("Libro no encontrado %n");
            }
        } else {
            System.err.printf("Autor no encontrado %n");
        }
    }
}
