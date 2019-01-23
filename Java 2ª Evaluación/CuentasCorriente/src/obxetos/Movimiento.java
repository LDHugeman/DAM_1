
package obxetos;

import java.util.Date;

/**
 *
 * @author David
 */
public class Movimiento {
    private String numero;
    private Date fechaMovimiento;
    private Date hora;
    private float cantidad;
    private double saldoActual;
    
    
    public Movimiento (String numero, Date fechaMovimiento, Date hora, float cantidad, double saldoActual){
        this.numero = numero;
        this.fechaMovimiento = fechaMovimiento;
        this.hora = hora;
        this.cantidad = cantidad;
        this.saldoActual = saldoActual;
    }

    public String getNumero() {
        return numero;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public Date getHora() {
        return hora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public double getSaldoActual() {
        return saldoActual;
    }          
}
