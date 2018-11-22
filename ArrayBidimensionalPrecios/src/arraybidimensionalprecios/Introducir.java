package arraybidimensionalprecios;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {

    private static String obterCiudad(BufferedReader lee) throws IOException {
        System.out.printf("Nombre de la ciudad: ");
        return lee.readLine();
    }
    
    public static String[] obterCiudades(String [] ciudades, BufferedReader lee)throws IOException{
        for(int i = 0;i<ciudades.length;i++){
            ciudades[i] = obterCiudad(lee);
        }
        return ciudades;
    }

    private static String obterProducto(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del producto: ");
        return lee.readLine();
    }
    
    public static String[] obterProductos(String[] productos, BufferedReader lee)throws IOException{
        for(int i = 0;i<productos.length;i++){
            productos[i] = obterProducto(lee);
        }
        return productos;
    }
    
    private static float obterPrecio(String producto, String ciudad, BufferedReader lee)throws IOException{
        System.out.printf("Precio del producto %s en %s: ",producto, ciudad);
        return Float.parseFloat(lee.readLine());
    }

    public static void obtenerPrecios(
            float[][] precios,
            String[] ciudades,
            String[] productos,
            BufferedReader lee) throws IOException{
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < ciudades.length; j++) {
                precios [i] [j] = obterPrecio(productos[i], ciudades[i], lee);
            }
        }
    }
}
