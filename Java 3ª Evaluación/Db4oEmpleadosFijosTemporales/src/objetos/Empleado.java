
package objetos;

/**
 *
 * @author David
 */
public abstract class Empleado {
    
    private String dni;
    private String nombre;
    private String telefono;
    private float porcentajeRetencion;
    
    public Empleado (String dni, String nombre, String telefono, float porcentajeRetencion){
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public void setPorcentajeRetencion(float porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }
 
    public abstract float calculoNomina();
}
