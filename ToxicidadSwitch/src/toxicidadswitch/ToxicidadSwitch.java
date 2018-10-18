
package toxicidadswitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class ToxicidadSwitch {


    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Producto producto = obterProducto(lee);
        if (producto!=null){
            System.out.println("La toxicidad del producto "+ producto.getNombre()+ " es: "+ producto.getTipo());
        }
        
    }
    
    public static Producto obterProducto(BufferedReader lee)throws IOException{
        System.out.printf("Nombre del producto: ");
        String nombre = lee.readLine();
        String tipo;
        switch(Menu.mostrarMenuToxicidad(lee)){
            case 1:
                tipo = "No tóxico";
                break;
            case 2:
                tipo = "Baja toxicidad";
                break;
            case 3:
                tipo = "Media toxicidad";
                break;
            case 4:
                tipo = "Alta toxicidad";
                break;
            case 5:
                tipo = "Altamente peligroso";
                break;
            default:
                System.err.println("Esa opción non existe.");
                    return null;
        }
        return new Producto(nombre, tipo);
    }
}
