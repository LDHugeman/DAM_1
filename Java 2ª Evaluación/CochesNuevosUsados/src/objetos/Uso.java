
package objetos;

import java.util.Date;

/**
 *
 * @author a18luisdvp
 */
public class Uso {
    private Date fechaAlquiler;
    private Date fechaDevolucion;
    private float importe;
    
    public Uso(Date fechaAlquiler, Date fechaEntrega){
        this.fechaAlquiler=fechaAlquiler;
        this.fechaDevolucion=fechaEntrega;       
    }
    
    public float calcularImporte(float precioDia){
        long fechaAlquilerMs = fechaAlquiler.getTime();
        long fechaDevolucionMs= fechaDevolucion.getTime();
        long diferenciaDias = (fechaDevolucionMs - fechaAlquilerMs) /86400000;
        importe= diferenciaDias * precioDia;
        return importe;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
}
