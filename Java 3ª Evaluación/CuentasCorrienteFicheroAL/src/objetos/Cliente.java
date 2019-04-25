
package objetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Luis David
 */
public class Cliente implements Serializable{
    private String dni;
    private String nombre;
    private String direccion;
    
    public Cliente(String dni, String nombre, String direccion){
        this.dni = dni;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    
    public String getDni(){
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    } 

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }   
}
