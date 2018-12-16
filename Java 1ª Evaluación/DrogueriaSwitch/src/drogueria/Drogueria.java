
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
        if(articulo!=null){
            System.out.println("Las ventas del producto " + articulo.getNombre() + " son: "+ articulo.getTipo());    
        }        
    }
    
    public static Articulo obterArticulo(BufferedReader lee)throws IOException{
        System.out.printf("Nombre del artículo: ");
        String nombre = lee.readLine();
        String tipo = obterTipo(lee);
        if(tipo!=null){
        return new Articulo(nombre, tipo);    
        }else{
            return null;
        }        
    }
            
    public static String obterTipo(BufferedReader lee) throws IOException{
        String tipo;
        switch(Menu.mostrarMenuVentas(lee)){
            case 1:
                tipo = "Artículo de bajo consumo";
                break;
            case 2:
                tipo = "Artículo de consumo medio";
                break;
            case 3:
                tipo = "Artículo de consumo alto";
                break;
            case 4:
                tipo = "Artículo de primera necesidad";
                break;
            default:
                System.err.println("Esa opción non existe.");
                    return null;
        }
        return tipo;
    }
}   
