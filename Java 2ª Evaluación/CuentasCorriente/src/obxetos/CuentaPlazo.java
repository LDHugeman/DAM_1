
package obxetos;

import java.io.IOException;

/**
 *
 * @author Luis David
 */
public class CuentaPlazo extends Cuenta{
    private float intereses;
    private String fechaVencimiento;
    private long depositoPlazo;
    
    public CuentaPlazo(String numero, String sucursal, Cliente primerCliente, float intereses, String fechaVencimiento, long depositoPlazo) throws IOException{
        super(numero, sucursal, primerCliente);
        this.intereses = intereses;
        this.fechaVencimiento = fechaVencimiento;
        this.depositoPlazo = depositoPlazo;
    }

    public float getIntereses() {
        return intereses;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public long getDepositoPlazo() {
        return depositoPlazo;
    }
    
    public void setIntereses(float intereses){
        this.intereses = intereses;
    }
}
