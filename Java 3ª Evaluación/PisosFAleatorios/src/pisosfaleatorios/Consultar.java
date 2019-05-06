package pisosfaleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objetos.Piso;
import static pisosfaleatorios.Archivo.getPiso;

/**
 *
 * @author David
 */
public class Consultar {

    public static Piso buscarPisoPorReferencia(File fichero, String referencia) {
        Piso pisoEncontrado = null;
        int numeroRegistros = Archivo.obtenerNumeroRegistros(fichero);
        RandomAccessFile flujoLectura = Archivo.abrirLecturaFichero(fichero);
        try {
            for (int i = 0; i < numeroRegistros; i++) {
                flujoLectura.seek(i * Archivo.TAMAÑO_MAXIMO_REGISTRO);
                Piso piso = getPiso(flujoLectura);
                if (piso.getReferencia().equalsIgnoreCase(referencia)) {
                    pisoEncontrado = piso;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error en lectura");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return pisoEncontrado;
    }
    
    public static ArrayList<Piso> buscarPisosPorPropietario(File fichero, String nombrePropietario) {
        ArrayList<Piso> pisosPropietario = new ArrayList<>();
        int numeroRegistros = Archivo.obtenerNumeroRegistros(fichero);
        RandomAccessFile flujoLectura = Archivo.abrirLecturaFichero(fichero);
        try {
            for (int i = 0; i < numeroRegistros; i++) {
                flujoLectura.seek(i * Archivo.TAMAÑO_MAXIMO_REGISTRO);
                Piso piso = getPiso(flujoLectura);                              
                if (piso.getNombrePropietario().equalsIgnoreCase(nombrePropietario)) {
                    pisosPropietario.add(piso);
                }
            }
        } catch (IOException exception) {
            System.out.println("Error en lectura");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return pisosPropietario;
    }

    public static int obtenerNumeroRegistroDelPiso(File fichero, String referencia) {
        int numeroRegistro = 0;
        int numeroRegistros = Archivo.obtenerNumeroRegistros(fichero);
        RandomAccessFile flujoLectura = Archivo.abrirLecturaFichero(fichero);
        try {
            for (int i = 0; i < numeroRegistros; i++) {
                flujoLectura.seek(i * Archivo.TAMAÑO_MAXIMO_REGISTRO);
                Piso piso = getPiso(flujoLectura);
                if (piso.getReferencia().equalsIgnoreCase(referencia)) {
                    numeroRegistro = i;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error en lectura");
        } finally {
            Archivo.cerrarFlujo(flujoLectura);
        }
        return numeroRegistro;
    }
}
