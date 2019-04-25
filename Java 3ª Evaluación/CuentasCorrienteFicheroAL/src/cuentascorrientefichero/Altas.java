package cuentascorrientefichero;

import java.io.File;
import java.util.ArrayList;
import objetos.Cuenta;

/**
 *
 * @author David
 */
public class Altas {

    public static void cuenta(ArrayList<Cuenta> cuentas, File fichero, Cuenta cuenta) {
        cuentas.add(cuenta);
        Archivo.reescribirFichero(fichero, cuentas);
    }
}
