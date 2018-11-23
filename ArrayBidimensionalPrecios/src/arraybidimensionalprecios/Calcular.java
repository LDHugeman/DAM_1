package arraybidimensionalprecios;

/**
 *
 * @author David
 */
public class Calcular {

    public static void obterPrecioMedioPorFila(float[][] precios, float[] preciosMediosFila) {
        for (int i = 0; i < precios.length; i++) { // i< numeroFilas
            float sf = 0;
            for (int j = 0; j < precios[i].length; j++) { //j< numeroColumnas
                sf += precios[i][j];
            }
            preciosMediosFila[i] = sf / precios[i].length; // sumaDeLasFilas dividido entre numero de columnas
        }
    }

    public static void obterPrecioMedioPorColumna(float[][] precios, float[] preciosMediosColumna) {
        for (int i = 0; i < precios[i].length; i++) {  //i <numeroColumnas
            float sc = 0;
            for (int j = 0; j < precios.length; j++) {  //j< numeroFilas
                sc += precios[j][i];
            }
            preciosMediosColumna[i]=sc/ precios.length;  // sumaDeLasColumnas dividido entre numero de filas
        }
    }
}
