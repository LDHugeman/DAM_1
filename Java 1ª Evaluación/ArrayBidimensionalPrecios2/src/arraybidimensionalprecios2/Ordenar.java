package arraybidimensionalprecios2;

/**
 *
 * @author Luis David
 */
public class Ordenar {

    public static void ordenarPorBurbujaAscendente(String[] copiaProductos, float[] copiaPreciosMediosProducto) {
        String auxNombre = "";
        float aux = 0;
        for (int i = 0; i < copiaProductos.length - 1; i++) {
            for (int j = i + 1; j < copiaProductos.length; j++) {
                if (copiaProductos[i].compareToIgnoreCase(copiaProductos[j]) > 0) {
                    auxNombre = copiaProductos[i];
                    copiaProductos[i] = copiaProductos[j];
                    copiaProductos[j] = auxNombre;
                    aux = copiaPreciosMediosProducto[i];
                    copiaPreciosMediosProducto[i] = copiaPreciosMediosProducto[j];
                    copiaPreciosMediosProducto[j] = aux;
                }
            }
        }
    }

    public static void ordenarPorIntercambioAscendente(String[] copiaProductos, float[] copiaPreciosMediosProducto) {
        String auxNombre = "";
        float aux = 0;
        boolean estaOrdenado = false;
        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < copiaProductos.length - 1; i++) {
                if (copiaProductos[i].compareToIgnoreCase(copiaProductos[i + 1]) > 0) {
                    auxNombre = copiaProductos[i];
                    copiaProductos[i] = copiaProductos[i + 1];
                    copiaProductos[i + 1] = auxNombre;
                    aux = copiaPreciosMediosProducto[i];
                    copiaPreciosMediosProducto[i] = copiaPreciosMediosProducto[i + 1];
                    copiaPreciosMediosProducto[i + 1] = aux;

                    estaOrdenado = false;
                }
            }
        }
    }
}
