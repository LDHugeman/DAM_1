
package obxetos;

import java.io.IOException;

/**
 *
 * @author Luis David
 */
public class CuentaCorriente extends Cuenta{
    double saldoActual;
    
    public CuentaCorriente(String numero, String sucursal, Cliente primerCliente, double saldoActual) throws IOException{
        super(numero, sucursal, primerCliente);
        this.saldoActual = saldoActual;
    }

    public double getSaldoActual() {
        return saldoActual;
    }
}
