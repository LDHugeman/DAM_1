
package articulospilas;
import clases.*;

// @author 

public class Visualizar {
    
    public static void visualizar(Articulo p) {
        
        
        System.out.printf("%n%n--Artículo:"
                + "%nCódigo:%5d"
                + "%nUnidades:%-5d"
                + "%nPrecio:%-5.2f"
                + "%n%n",p.getCodigo(),p.getUnidades(),p.getPrecio());

    }
    
    public static void visualizarListado(Articulo p) {
        
        System.out.printf("--LISTA DE ARTICULOS--"
                +"%n%n    Articulo       Unidades       Precio"
                +"%n________________________________________");
        
        while (p != null) 
        {
            System.out.printf("%n%10d %10d %14.2f", p.getCodigo(), p.getUnidades(), p.getPrecio());
            p=p.getSiguiente();
        }

    }
    
    public static void visualizar() {
        
        System.out.printf("%n--Artículo no encontrado--%n");
    }
    
}
