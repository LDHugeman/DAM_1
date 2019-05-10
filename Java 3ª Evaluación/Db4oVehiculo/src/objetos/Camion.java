
package objetos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author David
 */
public class Camion extends Vehiculo{
    
    private float potencia;
    private int numeroDeAnos;
    private Date fechaDeAlta;

    public Camion(String matricula, String propietario, float precio, float potencia, Date fechaDeAlta) {
        super(matricula, propietario, precio);
        this.potencia = potencia;
        this.fechaDeAlta = fechaDeAlta;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }
    
    public String getStringFechaDeAlta(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fechaDeAlta);
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public int getNumeroDeAnos() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaAlta = LocalDate.of(1900 + fechaDeAlta.getYear(), fechaDeAlta.getMonth()+1, fechaDeAlta.getDay());
        Period periodNumeroAnos = Period.between(fechaAlta, fechaActual);
        numeroDeAnos = periodNumeroAnos.getYears();
        
        return numeroDeAnos;
    }

    public void setNumeroDeAnos(int numeroDeAnos) {
        this.numeroDeAnos = numeroDeAnos;
    }

    @Override
    public float getImpuesto() {
        return super.getPrecio() * 0.120f + numeroDeAnos * 0.02f;
    }  
}
