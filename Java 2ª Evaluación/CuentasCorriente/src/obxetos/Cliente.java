
package obxetos;

/**
 *
 * @author Luis David
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String direccion;
    
    public Cliente(String dni, String nombre, String direccion){
        this.dni = dni;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    
    public String getDNI(){
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }    
}
