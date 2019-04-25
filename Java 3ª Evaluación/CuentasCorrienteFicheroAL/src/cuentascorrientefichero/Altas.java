package cuentascorrientefichero;

import java.io.File;
import java.io.IOException;
import objetos.Cuenta;
import objetos.ObjectOutputStreamSinCabecera;

/**
 *
 * @author David
 */
public class Altas {

    public static void cuenta(File fichero, Cuenta cuenta) {
        ObjectOutputStreamSinCabecera flujoArchivo = Archivo.abrirEscrituraFichero(fichero);
        try {
            flujoArchivo.writeObject(cuenta);
        } catch (IOException excepcion) {
            System.out.println("Error en escritura");
        } finally {
            Archivo.cerrarFlujo(flujoArchivo);
        }
    }
}
