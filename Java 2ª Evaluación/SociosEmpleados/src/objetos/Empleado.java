
package objetos;

/**
 *
 * @author David
 */
public abstract class Empleado {
    private String nombre;
    private String dni;
    private int porcentajeRetencion;
    private int sueldo;
    
    public Empleado (String nombre, String dni, int retencion, int sueldo){
        this.nombre= nombre;
        this.dni=dni;
        this.porcentajeRetencion=retencion;
        this.sueldo=sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getPorcentajeRetencion() {
        return porcentajeRetencion;
    }  

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setPorcentajeRetencion(int porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }   
    
    public abstract double sueldoNeto();          
    
}
