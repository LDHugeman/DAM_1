
package arraybidimensionalprecios;

/**
 *
 * @author a18luisdvp
 */
public class EJEMPLO2 {

    public static void sumarColumnas(float[][] precios, float[] sc) {
        int i = 0;
        for (i = 0; i < precios[0].length; i++) {
            float ac = 0;
            for (int j = 0; j < precios.length; j++) {
                ac = ac + precios[j][i];
            }
            sc[i] = ac / precios.length;
        }
    } 
}