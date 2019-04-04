package librosautoresfichero;

import Objetos.Autor;
import Objetos.ObjectOutputStreamSinCabecera;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Altas {

    public static void autor(File fichero, Autor autor) {
        ObjectOutputStreamSinCabecera flujoArchivo = Archivo.abrirEscrituraFichero(fichero);
        try {
            flujoArchivo.writeObject(autor);
        } catch (IOException excepcion) {
            System.out.println("Error en escritura");
        }
        Archivo.cerrarFlujo(flujoArchivo);
    }

    public static void libros(File fichero, BufferedReader lee) {
        Autor autorEncontrado = Consultar.encontrarAutorPorDni(fichero, Crear.pedirDniExistente(fichero, lee));
        if (autorEncontrado != null) {
            File temporal = Archivo.obtenerTemporal(fichero, autorEncontrado);
            autorEncontrado.getLibros().add(Crear.nuevoLibro(lee));
            byte opcion = 0;
            do {
                System.out.println("¿Desea añadir más libros a este al autor " + autorEncontrado.getNombre() + "?");
                System.out.println("[1] Sí");
                System.out.println("[2] No");
                System.out.printf("Seleccione una opcion: ");
                opcion = Pedir.numeroByte(lee);
                if (opcion == 1) {
                    autorEncontrado.getLibros().add(Crear.nuevoLibro(lee));
                }
            } while (opcion == 1);
            autor(temporal, autorEncontrado);
            if (fichero.delete()) {
                temporal.renameTo(fichero);
            } else {
                System.out.println("Error al borrar");
            }

        } else {
            System.err.printf("Autor no encontrado %n");
        }
    }
}
