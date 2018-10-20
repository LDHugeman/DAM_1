
package inmobiliaria;

/**
 *
 * @author David
 */
public class Visualizar {
    public static void factura(Factura factura){
        if(factura!=null){
            System.out.printf("Compra de: %s %n",factura.getTipoInmueble());
            System.out.printf("Precio de venta: %.2f€ %n", factura.getPrecio());
            System.out.printf("Intereses (%.2f%%): %.2f€ %n", factura.getPorcentajeInteres(), factura.getPrecioInteres());
            System.out.printf("Precio total: %.2f %n", factura.getPrecioTotal());
            System.out.printf("A pagar %d mensualidades de %.2f€ %n", factura.getMensualidades(), factura.getPrecioMensualidad());
        }
    }
}
