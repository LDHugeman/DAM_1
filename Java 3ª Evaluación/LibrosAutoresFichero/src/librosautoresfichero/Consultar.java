package librosautoresfichero;

import Objetos.Autor;
import Objetos.Libro;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author a18luisdvp
 */
public class Consultar {

    public static Autor encontrarAutorPorDni(File fichero, String dni) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        Autor autorEncontrado = null;
        try {
            do {
                Autor autor = (Autor) flujoLectura.readObject();
                if (autor.getDni().equalsIgnoreCase(dni)) {
                    autorEncontrado = autor;
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
        return autorEncontrado;
    }

    public static boolean existeAutorPorDni(File fichero, String dni) {
        return encontrarAutorPorDni(fichero, dni) != null;
    }
    
    public static Autor encontrarAutorPorNombre(File fichero, String nombre) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        Autor autorEncontrado = null;
        try {
            do {
                Autor autor = (Autor) flujoLectura.readObject();
                if (autor.getNombre().equalsIgnoreCase(nombre)) {
                    autorEncontrado = autor;
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
        return autorEncontrado;
    }

    public static Autor encontrarAutorPorTituloLibro(File fichero, String titulo) {
        ObjectInputStream flujoLectura = Archivo.abrirLecturaFichero(fichero);
        Autor autorEncontrado = null;
        try {
            do {
                Autor autor = (Autor) flujoLectura.readObject();
                for (Libro libro : autor.getLibros()) {
                    if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                        autorEncontrado = autor;
                    }
                }
            } while (true);
        } catch (EOFException excepcion) {
        } catch (ClassNotFoundException excepcion) {
            System.out.println("Clase no encontrada");
        } catch (IOException expepcion) {
            System.out.println("Error al leer el fichero");
        }finally{
            Archivo.cerrarFlujo(flujoLectura);
        }      
        return autorEncontrado;
    }
}
