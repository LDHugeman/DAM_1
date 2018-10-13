
package toxicidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Luis David
 */
public class Toxicidad {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Producto producto = obterProducto(lee);
        System.out.println(producto.getTipo());
    }
    
    public static Producto obterProducto (BufferedReader lee) throws IOException{
        System.out.printf("Nombre del producto: ");
        String nombre = lee.readLine();
        System.out.printf("Grado de toxicidad: ");
        Byte grado = Byte.parseByte(lee.readLine());
        
        return new Producto(nombre, grado);
    }
}
