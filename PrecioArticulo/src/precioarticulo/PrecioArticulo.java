package precioarticulo;

import java.io.*;

/**
 *
 * @author a18luisdvp
 */
public class PrecioArticulo {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        //ENTRADA
        
        System.out.printf("Artículo: ");
        String articulo = lee.readLine();
        System.out.printf("Precio inicial: ");
        float precioInicial = Float.parseFloat(lee.readLine());
        System.out.printf("Precio final: ");
        float precioFinal = Float.parseFloat(lee.readLine());
        
        //PROCESO
        
        float variacionPrecio = (byte) precioFinal-precioInicial;
        float porcentajeVariacion = (int) (variacionPrecio * 100) / precioInicial;
        
        //SALIDA
        
        System.out.printf("Artículo %s %n", articulo);
        System.out.printf("Variación de precio %.2f %n", variacionPrecio);
        System.out.printf("Porcentaje de variación %d%%", porcentajeVariacion);        
      
    }

}
