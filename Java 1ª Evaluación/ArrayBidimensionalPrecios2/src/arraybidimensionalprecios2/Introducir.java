
package arraybidimensionalprecios2;
import java.io.*;
/**
 *
 * @author Luis David
 */
public class Introducir {
    
    public static String obtenerProductoBusqueda(BufferedReader lee)throws IOException{
        System.out.printf("Nombre del producto por el que desea buscar: ");
        return lee.readLine();
    }
    
    private static String obtenerProducto (BufferedReader lee) throws IOException{
        System.out.printf("Nombre del producto: ");
        return lee.readLine();
    }
    
    private static String obtenerCiudad (BufferedReader lee) throws IOException{
        System.out.printf("Nombre de la ciudad: ");
        return lee.readLine();
    }
    
    private static float obtenerPrecio(String producto, String ciudad, BufferedReader lee)throws IOException{
        System.out.printf("Precio del producto %s en %s: ",producto, ciudad);
        return Float.parseFloat(lee.readLine());
    }
    
    public static void obtenerProductos(String[]productos,String [] copiaProductos, BufferedReader lee)throws IOException{
        for(int i=0; i<productos.length;i++){
            String nombreProducto = obtenerProducto(lee);
            productos[i]= nombreProducto;
            copiaProductos[i]= nombreProducto;                     
        }       
    }
    
    public static String[] obtenerCiudades(String[]ciudades, BufferedReader lee)throws IOException{
        for(int i=0; i<ciudades.length;i++){
            ciudades[i]=obtenerCiudad(lee);
        }
        return ciudades;
    }
    
    public static float [][] obtenerPrecios (float[][] precios, String[]productos, String []ciudades, BufferedReader lee)throws IOException{
        for(int i=0; i<precios.length;i++){
            precios[i]= new float [ciudades.length]; // Esto non sería necesario*
            for(int j=0; j<ciudades.length; j++){    //Igual que precios[i].length*
                precios[i][j] = obtenerPrecio(productos[i], ciudades[j], lee);
            }
        }
        return precios;
    }    
}
