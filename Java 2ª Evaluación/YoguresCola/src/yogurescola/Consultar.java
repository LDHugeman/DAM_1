package yogurescola;

import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Consultar {

    public static Yogourt encontrarYogurPorCodigo(String codigo, Yogourt cabecera) {
        Yogourt actual = cabecera;
        while (actual != null && !codigo.equalsIgnoreCase(actual.getCodigo())) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public static boolean existeYogurPorCodigo(String codigo, Yogourt cabecera) {
        return encontrarYogurPorCodigo(codigo, cabecera) != null;
    }

    public static Yogourt encontrarYogurPorMarca(String marca, Yogourt cabecera) {
        Yogourt actual = cabecera;
        while (actual != null && !marca.equalsIgnoreCase(actual.getMarca())) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public static boolean existeYogurPorMarca(String marca, Yogourt cabecera) {
        return encontrarYogurPorMarca(marca, cabecera) != null;
    }
}
