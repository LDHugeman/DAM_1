package arraybidimensionalprecios;

/**
 *
 * @author David
 */
public class Calcular {

    public static void obterPrecioMedioPorFila(float[][] precios, float[] preciosMediosFila) {
        for (int i = 0; i < precios.length; i++) {
            float sf = 0;
            for (int j = 0; j < precios[i].length; j++) {
                sf += precios[i][j];
            }
            preciosMediosFila[i] = sf / precios[i].length;
        }
    }

    public static void obterPrecioMedioPorColumna(float[][] precios, float[] preciosMediosColumna) {
        for (int i = 0; i < precios[0].length; i++) {
            float sc = 0;
            for (int j = 0; j < precios.length; j++) {
                sc += precios[j][i];
            }
            preciosMediosColumna[i]=sc/ precios.length;
        }
    }
}
