package ensaladaslista;

import java.util.Date;
import objetos.Ensalada;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrarEnsalada(Ensalada ensalada) {
        System.out.println("-------------------------------------------");
        System.out.println("Código: " + ensalada.getCodigo());
        System.out.println("Marca: " + ensalada.getMarca());
        System.out.println("Fecha: " + ensalada.getStringFecha());
        System.out.println("-------------------------------------------");
    }

    public static void mostrarEnsaladas(Ensalada cabecera) {
        Ensalada actual = cabecera;
        while (actual != null) {
            mostrarEnsalada(actual);
            actual = actual.getSiguiente();
        }
    }

    public static void mostrarEnsaladasCaducadas(Ensalada cabecera) {
        Ensalada actual = cabecera;
        System.out.println("--- Ensaladas caducadas ---");
        while (actual != null) {
            if (estaEnsaladaCaducada(actual)) {               
                mostrarEnsalada(actual);
            }
            actual = actual.getSiguiente();
        }
    }

    public static boolean estaEnsaladaCaducada(Ensalada ensalada) {
        final long MS_CADUCIDAD = 7 * 24 * 60 * 60 * 1000; // 7 Días como fecha límite de caducidad
        return ensalada.getFecha().getTime() < (new Date().getTime() - MS_CADUCIDAD);
    }
}
