package arraybidimensionalprecios;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void verPreciosDeProductosEnCiudades(float[][] precios, String[] productos, String[] ciudades) {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < ciudades.length; j++) {
                verDatosProducto(ciudades[j], productos[i], precios[i][j]);
            }
        }
    }

    public static void verPreciosMediosFila(float[][] precios, float[] preciosMediosFila, String[] productos, String[] ciudades) {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < ciudades.length; j++) {
                verPrecioMedioProducto(productos [i], preciosMediosFila[i]);
            }
        }
    }
    
    public static void verPreciosMediosColumna(float[][] precios, float[] preciosMediosColumna, String[] productos, String[] ciudades) {
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < productos.length; j++) {
                verPrecioMedioCiudad(ciudades[i], preciosMediosColumna[i]);
            }
        }
    }
    
    private static void verDatosProducto(String ciudad, String producto, float precio){
        System.out.printf("Datos introducidos: %n");
        System.out.printf("%s - %s: %.2f %n",ciudad, producto, precio);       
    }
    
    private static void verPrecioMedioProducto(String producto, float precioMedio){
        System.out.printf("Precio medio por producto: %n");
        System.out.printf("%s: %.2f %n",producto, precioMedio);  
    }
    
    private static void verPrecioMedioCiudad(String ciudad, float precioMedio){
        System.out.printf("Precio medio por ciudad: %n");
        System.out.printf("%s: %.2f %n",ciudad, precioMedio); 
    }
}

