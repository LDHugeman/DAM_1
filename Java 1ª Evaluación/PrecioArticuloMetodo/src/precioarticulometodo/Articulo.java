
package precioarticulometodo;

/**
 *
 * @author David
 */
public class Articulo {
    private String nombre;
    private float precioInicial;
    private float precioFinal;
    private float variacionPrecio;
    private float porcentajeVariacion;

    public Articulo (String nombre, float precioInicial, float  precioFinal) {
        this.nombre = nombre;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioInicial() {
        return precioInicial;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public float getVariacionPrecio() {
        return calcularVariacionPrecio();
    }

    public float getPorcentajeVariacion() {
        return calcularPorcentajeVariacion();
    }

    private float calcularVariacionPrecio(){
        variacionPrecio = (precioFinal - precioInicial);
        return variacionPrecio;
    }
    
    private float calcularPorcentajeVariacion (){
        porcentajeVariacion = (variacionPrecio * 100/precioInicial);
        return porcentajeVariacion;
    }
     
    
}

