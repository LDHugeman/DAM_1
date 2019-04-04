package librosautoresfichero;

import Objetos.Autor;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Objetos.ObjectOutputStreamSinCabecera;

/**
 *
 * @author David
 */
public class Archivo {

    public static void nuevoFichero(File fichero, BufferedReader lee) {
        ObjectOutputStream flujoArchivo;
        if (fichero.exists()) {
            System.out.println("¿Desea eliminar el fichero actual y crear uno nuevo?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            byte opcion = Pedir.numeroByte(lee);
            if (opcion == 1) {
                flujoArchivo = crearFichero(fichero);
                cerrarFlujo(flujoArchivo);
                System.out.println("Fichero creado");
            } else {
                System.out.println("Operación cancelada");
            }
        } else {
            flujoArchivo = crearFichero(fichero);
            cerrarFlujo(flujoArchivo);
            System.out.println("Fichero creado");
        }
    }

    private static ObjectOutputStream crearFichero(File fichero) {
        ObjectOutputStream flujoArchivo = null;
        try {
            flujoArchivo = new ObjectOutputStream(new FileOutputStream(fichero));
        } catch (IOException excepcion) {
            System.out.println("Error al crear el fichero");
        }
        return flujoArchivo;
    }

    public static ObjectOutputStreamSinCabecera abrirEscrituraFichero(File fichero) {
        ObjectOutputStreamSinCabecera flujoArchivo = null;
        try {
            flujoArchivo = new ObjectOutputStreamSinCabecera(new FileOutputStream(fichero, true));
        } catch (IOException excepcion) {
            System.out.println("Error al abrir el fichero");
        }
        return flujoArchivo;
    }

    public static ObjectInputStream abrirLecturaFichero(File fichero) {
        ObjectInputStream flujoArchivo = null;
        try {
            flujoArchivo = new ObjectInputStream(new FileInputStream(fichero));
        } catch (IOException excepcion) {
            System.out.println("Error al abrir el fichero");
        }
        return flujoArchivo;
    }

    public static void cerrarFlujo(ObjectOutputStream flujo) {
        try {
            flujo.close();
        } catch (IOException excepcion) {
            System.out.println("Error al cerrar el fichero");
        }
    }

    public static void cerrarFlujo(ObjectInputStream flujo) {
        try {
            flujo.close();
        } catch (IOException excepcion) {
            System.out.println("Error al cerrar el fichero");
        }
    }

    /**
     * Crea un archivo temporal sin un autor determinado
     *
     * @param original Archivo original con los autores
     * @param autorBuscado Autor a eliminar
     * @return Nuevo archivo temporal
     */
    public static File obtenerTemporal(File original, Autor autorBuscado) {
        File temporal = new File("temporal.dat");
        ObjectInputStream lecturaOriginal = abrirLecturaFichero(original);
        ObjectOutputStream escrituraTemporal = crearFichero(temporal);
        Autor autor = null;
        try {
            do {
                autor = (Autor) lecturaOriginal.readObject();
                if (!autor.getDni().equalsIgnoreCase(autorBuscado.getDni())) {
                    escrituraTemporal.writeObject(autor);  // Estanse a escribir todos os autores no ficheroTemporal excepto o autorBuscado
                }
            } while (true);
        } catch (EOFException exception) {
        } catch (IOException exception) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException exception) {
            System.out.println("Clase no encontrada");
        }
        cerrarFlujo(lecturaOriginal);
        cerrarFlujo(escrituraTemporal);
        return temporal;
    }
}
