
package objetos;

/**
 *
 * @author David
 */
public abstract class Vehiculo {
    
    private String matricula;
    private String propietario;
    private float precio;
    private int numeroDeAnos;
    
    public Vehiculo (String matricula, String propietario, float precio){
        this.matricula = matricula;
        this.propietario = propietario;
        this.precio = precio;
    }

    public Vehiculo(String matricula, String propietario, float precio, int numeroDeAnos) {
        this.matricula = matricula;
        this.propietario = propietario;
        this.precio = precio;
        this.numeroDeAnos = numeroDeAnos;
    }    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumeroDeAnos() {
        return numeroDeAnos;
    }

    public void setNumeroDeAnos(int numeroDeAnos) {
        this.numeroDeAnos = numeroDeAnos;
    }
       
    public abstract float getImpuesto();
}

