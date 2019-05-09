
package objetos;

import java.text.SimpleDateFormat;
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
        final int ANO_MS = 1000*60*60*24*365;
        Date fechaActual = new Date(); 
        long fechaAc = fechaActual.getTime();
        long fechaAlta = this.fechaDeAlta.getTime();
        numeroDeAnos = (int)((fechaAc - fechaAlta)/ANO_MS);      
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
