
package drogueria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class Drogueria {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Articulo articulo = obterArticulo(lee);
        System.out.println(articulo.getTipo());
    }
    
    public static Articulo obterArticulo(BufferedReader lee)throws IOException{
        System.out.printf("Nombre del artículo: ");
        String nombre = lee.readLine();
        System.out.printf("Ventas anuales: ");
        float ventasAnuales = Float.parseFloat(lee.readLine());
        
        return new Articulo(nombre, ventasAnuales);
    }
}   
