
package objetos;

import java.util.Date;

/**
 *
 * @author David
 */
public class Camion extends Vehiculo{
    
    private float potencia;
    private Date fechaDeAlta;

    public Camion(String matricula, String propietario, float precio, int numeroDeAnos, float potencia, Date fechaDeAlta) {
        super(matricula, propietario, precio, numeroDeAnos);
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

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    @Override
    public float getImpuesto() {
        return super.getPrecio() * 0.120f + super.getNumeroDeAnos() * 0.02f;
    }  
}
