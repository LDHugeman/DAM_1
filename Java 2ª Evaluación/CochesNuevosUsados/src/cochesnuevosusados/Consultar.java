package cochesnuevosusados;

import java.util.ArrayList;
import objetos.Coche;
import objetos.CocheAlquiler;
import objetos.CocheVenta;

/**
 *
 * @author David
 */
public class Consultar {

    public static Coche encontrarCochePorCodigo(String codigo, ArrayList<Coche> coches) {
        Coche cocheEncontrado = null;
        for (Coche coche : coches) {
            if (coche.getCodigo().equalsIgnoreCase(codigo)) {
                cocheEncontrado = coche;
            }
        }
        return cocheEncontrado;
    }

    public static boolean existeCochePorCodigo(String codigo, ArrayList<Coche> coches) {
        return encontrarCochePorCodigo(codigo, coches) != null;
    }

    public static CocheVenta encontrarCocheVentaPorCodigo(String codigo, ArrayList<Coche> coches) {
        CocheVenta cocheEncontrado = null;
        for (Coche coche : coches) {
            if (coche instanceof CocheVenta) {
                if (coche.getCodigo().equalsIgnoreCase(codigo)) {
                    cocheEncontrado = ((CocheVenta)coche);
                }
            }
        }
        return cocheEncontrado;
    }
    
    public static boolean existeCocheVentaPorCodigo(String codigo, ArrayList<Coche> coches) {
        return encontrarCocheVentaPorCodigo(codigo, coches) != null;
    }
    
    public static CocheAlquiler encontrarCocheAlquilerPorCodigo(String codigo, ArrayList<Coche> coches) {
        CocheAlquiler cocheEncontrado = null;
        for (Coche coche : coches) {
            if (coche instanceof CocheAlquiler) {
                if (coche.getCodigo().equalsIgnoreCase(codigo)) {
                    cocheEncontrado = ((CocheAlquiler)coche);
                }
            }
        }
        return cocheEncontrado;
    }
    
    public static boolean existeCocheAlquilerPorCodigo(String codigo, ArrayList<Coche> coches) {
        return encontrarCocheAlquilerPorCodigo(codigo, coches) != null;
    }
    
    public static 
}
