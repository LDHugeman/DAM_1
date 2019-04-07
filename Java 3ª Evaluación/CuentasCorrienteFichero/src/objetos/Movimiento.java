
package objetos;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class Movimiento implements Serializable{
    private String numero;
    private Date fechaMovimiento;
    private Time hora;
    private float cantidad;
    private double saldoActual;
    
    
    public Movimiento (String numero, float cantidad, double saldoActual){
        this.numero = numero;
        this.fechaMovimiento = new Date();
        this.hora = new Time(fechaMovimiento.getTime()); 
        this.cantidad = cantidad;
        this.saldoActual = saldoActual;
    }

    public String getNumero() {
        return numero;
    }

    public Date getFechaMovimiento() {      
        return fechaMovimiento;
    }
    
    public String getStringFechaMovimiento(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaMovimiento);
    }
    
    public String getStringHora(){
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
        return formatoHora.format(hora);
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
