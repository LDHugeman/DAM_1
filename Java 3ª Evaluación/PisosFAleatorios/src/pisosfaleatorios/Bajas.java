
package pisosfaleatorios;

import java.io.File;

/**
 *
 * @author David
 */
public class Bajas {
    
    public static void piso(File fichero, String referenciaBuscada){
        File temporal = Archivo.obtenerTemporal(fichero, referenciaBuscada);
        fichero.delete();
        temporal.renameTo(fichero);
        System.out.println("Piso con referencia "+ referenciaBuscada + " eliminado");
    }
}
