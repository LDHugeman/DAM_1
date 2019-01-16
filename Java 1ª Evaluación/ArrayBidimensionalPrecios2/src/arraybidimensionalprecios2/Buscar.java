package arraybidimensionalprecios2;

/**
 *
 * @author David
 */
public class Buscar {

    public static void buscarProductoPorNombre(String[] copiaProductos, String productoBusqueda, float [] copiaPreciosMediosProducto) {
        int low = 0;
        int high = copiaProductos.length - 1;
        int puntoMedio =0;
        while (low<high) {
            puntoMedio= (int)(low+high)/2;
            if(productoBusqueda.compareToIgnoreCase(copiaProductos[puntoMedio])==0){
                low=puntoMedio;
                high=puntoMedio;
            }else if(productoBusqueda.compareToIgnoreCase(copiaProductos[puntoMedio])<0){
                high = puntoMedio -1;
            }else{
                low = puntoMedio + 1;
            }
        }
        if(productoBusqueda.compareToIgnoreCase(copiaProductos[low])==0){
            System.out.printf("El precio medio del producto %s es %.2f %n",copiaProductos[low],copiaPreciosMediosProducto[low]);
        }else {
            System.out.printf("No se ha encontrado el producto %s %n", productoBusqueda);
            
        }
    }
    
   /* public static int buscarProductoPorNombre(String[] copiaProductos, String productoBusqueda) {
        int low = 0;
        int high = copiaProductos.length - 1;
        int puntoMedio =0;
        while (low<high) {
            puntoMedio= (int)(low+high)/2;
            if(productoBusqueda.compareToIgnoreCase(copiaProductos[puntoMedio])==0){
                low=puntoMedio;
                high=puntoMedio;
            }else if(productoBusqueda.compareToIgnoreCase(copiaProductos[puntoMedio])<0){
                high = puntoMedio -1;
            }else{
                low = puntoMedio + 1;
            }
        }
        if(productoBusqueda.compareToIgnoreCase(copiaProductos[low])==0){
            return low;
        }else {
            return 0;            
        }
    }
    
    public static void imprimirResultadoBusqueda(String[] copiaProductos, String productoBusqueda, float [] copiaPreciosMediosProducto){
        int posicionEncontrada = buscarProductoPorNombre(copiaProductos, productoBusqueda);
        if(posicionEncontrada==0){
            if()
        }
    }*/
}
