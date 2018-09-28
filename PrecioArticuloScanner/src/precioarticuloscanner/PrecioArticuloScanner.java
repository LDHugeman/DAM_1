
package precioarticuloscanner;
import java.util.*;
/**
 *
 * @author Luis David
 */
public class PrecioArticuloScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //ENTRADA
        
        System.out.printf("Artículo: ");
        String articulo = sc.nextLine();
        System.out.printf("Precio inicial: ");
        float precioInicial = sc.nextFloat();
        System.out.printf("Precio final: ");
        float precioFinal = sc.nextFloat();
        
        //PROCESO
        
        byte variacionPrecio = (byte) (precioFinal-precioInicial);
        int porcentajeVariacion = (variacionPrecio * 100)/(int)precioInicial;
        
        
        //SALIDA
        
        System.out.printf("Artículo: %s %n", articulo);
        System.out.printf("Variación de precio: %d %n", variacionPrecio);
        System.out.printf("Porcentaje de variación: %d%% %n", porcentajeVariacion);         
    }
    
}
