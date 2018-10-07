
package precioarticulometodo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class PrecioArticuloMetodo {

    
    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Articulo articulo = new Articulo(pedirNombreArticulo(lee), pedirPrecioInicial(lee), pedirPrecioFinal(lee));
        imprimirArticulo(articulo);
    }
    
    public static String pedirNombreArticulo(BufferedReader lee)throws IOException{
        System.out.printf("Artículo: ");
        return lee.readLine();
    }
    
    public static float pedirPrecioInicial (BufferedReader chocolate) throws IOException{
        System.out.printf("Precio inicial: ");
        return Float.parseFloat(chocolate.readLine());
    }
    
    public static float pedirPrecioFinal (BufferedReader lee) throws IOException{
        System.out.printf("Precio final: ");
        return Float.parseFloat(lee.readLine());
    }
    
    public static void imprimirArticulo (Articulo articulo){
        System.out.printf("Artículo: %s %n", articulo.getNombre());
        System.out.printf("Variación de precio: %.2f %n", articulo.getVariacionPrecio());
        System.out.printf("Porcentaje de variación: %.2f%% %n", articulo.getPorcentajeVariacion());        
    }
}
