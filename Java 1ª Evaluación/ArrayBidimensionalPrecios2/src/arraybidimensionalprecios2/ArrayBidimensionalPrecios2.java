
package arraybidimensionalprecios2;
import java.io.*;
/**
 *
 * @author Luis David
 */
public class ArrayBidimensionalPrecios2 {

    public static void main(String[] args) throws IOException{      
        BufferedReader lee = new BufferedReader (new InputStreamReader(System.in));
        float [][] precios = new float [3][];
        String [] productos = new String [3];
        String [] copiaProductos = new String [3];
        String [] ciudades = new String [2];
        float [] preciosMediosCiudad = new float [2];
        float [] preciosMediosProducto = new float [3];
        float [] copiaPreciosMediosProducto = new float [3];
        byte opcionSeleccionada;
        
        do{
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch(opcionSeleccionada){
                case 1:
                   Introducir.obtenerProductos(productos, copiaProductos, lee);
                   Introducir.obtenerCiudades(ciudades, lee);
                   Introducir.obtenerPrecios(precios, productos, ciudades, lee);
                   break;
                case 2:
                    Calcular.obtenerPrecioMedioPorCiudad(precios, preciosMediosCiudad);
                    Visualizar.verPrecioMedioPorCiudad(ciudades, preciosMediosCiudad);
                    break;
                case 3:
                    Calcular.obtenerPrecioMedioPorProducto(precios, preciosMediosProducto, copiaPreciosMediosProducto);
                    Visualizar.verPrecioMedioPorProducto(productos, preciosMediosProducto);
                    break;
                case 4:
                    Ordenar.ordenarPorBurbujaAscendente(copiaProductos, copiaPreciosMediosProducto);
                    Visualizar.verProductosOrdenados(copiaProductos, copiaPreciosMediosProducto);
                    break;
                case 5:
                    String productoBusqueda = Introducir.obtenerProductoBusqueda(lee);
                    Buscar.buscarProductoPorNombre(copiaProductos, productoBusqueda, copiaPreciosMediosProducto);
                    break;
                case 6:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");                    
            }
        }while(opcionSeleccionada!=6);
    }
    
}
