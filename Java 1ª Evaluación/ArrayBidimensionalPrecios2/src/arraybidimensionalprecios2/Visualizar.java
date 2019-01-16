
package arraybidimensionalprecios2;

/**
 *
 * @author David
 */
public class Visualizar {
    
    public static void verProductosOrdenados(String [] copiaProductos, float [] copiaPreciosMediosProducto){
        System.out.printf("Productos ordenados: %n");
        for(int i=0; i<copiaProductos.length;i++){
            System.out.printf("Producto: %s Precio medio: %.2f %n", copiaProductos[i], copiaPreciosMediosProducto[i]);
        }
    }
    
    public static void verPrecioMedioPorCiudad(String []ciudades, float [] preciosMediosCiudad){
        System.out.printf("Precio medio por ciudades: %n");
        for(int i=0; i<ciudades.length;i++){
            System.out.printf("Ciudad: %s Precio medio: %.2f %n",ciudades[i],preciosMediosCiudad[i]);
        }
    }
    
    public static void verPrecioMedioPorProducto(String []productos, float [] preciosMediosProducto){
        System.out.printf("Precio medio por productos: %n");
        for(int i=0; i<productos.length;i++){
            System.out.printf("Producto: %s Precio medio: %.2f %n",productos[i],preciosMediosProducto[i]);
        }
    }
}
