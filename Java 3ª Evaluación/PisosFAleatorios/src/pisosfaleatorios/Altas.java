
package pisosfaleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import objetos.Piso;

/**
 *
 * @author David
 */
public class Altas {

    public static void piso(Piso piso, File fichero){
        if(piso.getTamañoReal()<=Archivo.TAMAÑO_MAXIMO_REGISTRO){
            int numeroRegistros = Archivo.obtenerNumeroRegistros(fichero);
            RandomAccessFile flujoDatos = Archivo.abrirLecturaEscrituraFichero(fichero);
            try {
                flujoDatos.seek(numeroRegistros*Archivo.TAMAÑO_MAXIMO_REGISTRO); 
                piso.guardarEnArchivo(flujoDatos);
                Archivo.cerrarFlujo(flujoDatos);
            } catch (IOException excepcion) {
                System.out.println("Error al posicionarse en el registro.");
            }                       
        } else {
            System.err.println("El tamaño del registro excede el máximo.");
        }
    }   
}
