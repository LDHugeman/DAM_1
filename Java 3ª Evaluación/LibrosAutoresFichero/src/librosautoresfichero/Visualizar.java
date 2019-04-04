package librosautoresfichero;

import Objetos.Autor;
import Objetos.Libro;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrar(Autor autor) {
        System.out.println("-------------------------------------------");
        System.out.println("Dni: " + autor.getDni());
        System.out.println("Nombre: " + autor.getNombre());
        System.out.println("Ciudad: " + autor.getCiudad());
        System.out.println("-------------------------------------------");
    }

    public static void mostrar(Libro libro) {
        System.out.println("-------------------------------------------");
        System.out.println("Isbn: " + libro.getIsbn());
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Precio: " + libro.getPrecio());
        System.out.println("-------------------------------------------");
    }

    public static void mostrarLibros(Autor autor) {
        for (Libro libro : autor.getLibros()) {
            System.out.println("-------------------------------------------");
            System.out.println("Isbn: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Precio: " + libro.getPrecio());
            System.out.println("-------------------------------------------");
        }
    }

    public static void autoresDeUnaCiudad(File fichero, String ciudad) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        int contador = 0;
        try {
            do {
                Autor autor = (Autor) flujoLectura.readObject();
                if (autor.getCiudad().equalsIgnoreCase(ciudad)) {
                    contador++;
                    Visualizar.mostrar(autor);
                    for (Libro libro : autor.getLibros()) {
                        Visualizar.mostrar(libro);
                    }
                }
                if (contador == 0) {
                    System.err.printf("No hay ningún autor de esa ciudad %n");
                }
            } while (true);
        } catch (EOFException excepcion) {
        } catch (ClassNotFoundException excepcion) {
            System.out.println("Clase no encontrada");
        } catch (IOException expepcion) {
            System.out.println("Error al leer el fichero");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
    }

    public static void librosPrecioSuperior(File fichero) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        int contador = 0;
        try {
            do {
                Autor autor = (Autor) flujoLectura.readObject();
                for (Libro libro : autor.getLibros()) {
                    if (Consultar.esLibroSuperiorAPrecio(libro, 50)) {
                        contador++;
                        System.out.println("Autor: " + autor.getNombre());
                        Visualizar.mostrar(libro);
                    }
                }
            } while (true);
        } catch (EOFException excepcion) {
        } catch (ClassNotFoundException excepcion) {
            System.out.println("Clase no encontrada");
        } catch (IOException expepcion) {
            System.out.println("Error al leer el fichero");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        if (contador == 0) {
            System.err.printf("No hay ningún libro con un precio superior a 50€ %n");
        }
    }
}
