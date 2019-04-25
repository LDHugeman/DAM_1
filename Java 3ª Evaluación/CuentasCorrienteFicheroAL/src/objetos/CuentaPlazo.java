package objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luis David
 */
public class CuentaPlazo extends Cuenta {

    private float intereses;
    private Date fechaVencimiento;
    private long depositoPlazo;

    public CuentaPlazo(String numero, String sucursal, float intereses, Date fechaVencimiento, long depositoPlazo) {
        super(numero, sucursal);
        this.intereses = intereses;
        this.fechaVencimiento = fechaVencimiento;
        this.depositoPlazo = depositoPlazo;
    }

    public float getIntereses() {
        return intereses;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getStringFechaVencimieto() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaVencimiento);
    }

    public long getDepositoPlazo() {
        return depositoPlazo;
    }

    public void setIntereses(float intereses) {
        this.intereses = intereses;
    }
}
