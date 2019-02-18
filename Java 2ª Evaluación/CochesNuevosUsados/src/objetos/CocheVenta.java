
package objetos;

/**
 *
 * @author a18luisdvp
 */
public class CocheVenta extends Coche{
    private float precioVenta;
    
    public CocheVenta(String codigo, String marca, String modelo, float precioVenta){
        super(codigo, marca, modelo);
        this.precioVenta=precioVenta; 
    }

    public float getPrecioVenta() {
        return precioVenta;
    }
}
