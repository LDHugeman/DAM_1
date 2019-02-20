package cochesnuevosusados;

import java.util.ArrayList;
import objetos.Coche;
import objetos.CocheAlquiler;
import objetos.CocheVenta;
import objetos.Uso;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrarCocheVenta(CocheVenta coche) {
        System.out.println("-------------------------------------------");
        System.out.println("Código: " + coche.getCodigo());
        System.out.println("Marca: " + coche.getMarca());
        System.out.println("Modelo: " + coche.getModelo());
        System.out.println("Precio de venta: " + coche.getPrecioVenta() + "€");
        System.out.println("-------------------------------------------");
    }

    public static void mostrarCochesVenta(ArrayList<Coche> coches) {
        for (Coche coche : coches) {
            if (coche instanceof CocheVenta) {
                mostrarCocheVenta(((CocheVenta) coche));
            }
        }
    }

    public static void mostrarCocheAlquiler(CocheAlquiler coche) {
        System.out.println("-------------------------------------------");
        System.out.println("Código: " + coche.getCodigo());
        System.out.println("Marca: " + coche.getMarca());
        System.out.println("Modelo: " + coche.getModelo());
        System.out.println("Precio por día: " + coche.getPrecioDia() + "€");
        System.out.println("-------------------------------------------");
    }

    public static void mostrarUso(Uso uso) {
        System.out.println("-------------------------------------------");
        System.out.println("Fecha de alquiler: " + Crear.getStringFecha(uso.getFechaAlquiler()));
        System.out.println("Fecha de devolución: " + Crear.getStringFecha(uso.getFechaDevolucion()));
        System.out.println("Importe: " + uso.getImporte() + "€");
        System.out.println("-------------------------------------------");
    }

    public static void mostrarUsos(ArrayList<Uso> usos) {
        for (Uso uso : usos) {
            mostrarUso(uso);
        }
    }
}
