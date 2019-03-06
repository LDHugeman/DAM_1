package yogurescola;

import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void mostrarYogur(Yogourt yogur) {
        System.out.println("-------------------------------------------");
        System.out.println("Código: " + yogur.getCodigo());
        System.out.println("Marca: " + yogur.getMarca());
        System.out.println("Tipo: " + yogur.getTipo());
        System.out.println("-------------------------------------------");
    }

    public static void mostrarYogures(Yogourt cabecera) {
        Yogourt actual = cabecera;
        while (actual != null) {
            mostrarYogur(actual);
            actual = actual.getSiguiente();
        }
    }

    public static void mostrarYoguresPorMarca(String marca, Yogourt cabecera) {
        Yogourt actual = cabecera;
        while (actual != null) {
            if (actual.getMarca().equalsIgnoreCase(marca)) {
                mostrarYogur(actual);
            }
            actual = actual.getSiguiente();
        }
    }
}
