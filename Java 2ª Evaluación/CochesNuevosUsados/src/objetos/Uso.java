
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
    
    public void calcularImporte(float precioDia){
        final int MS_POR_DIA = 24*60*60*1000;
        long fechaAlquilerMs = fechaAlquiler.getTime();
        long fechaDevolucionMs= fechaDevolucion.getTime();
        long diferenciaDias = (fechaDevolucionMs - fechaAlquilerMs) /MS_POR_DIA;
        importe= diferenciaDias * precioDia;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public float getImporte() {
        return importe;
    } 
}
