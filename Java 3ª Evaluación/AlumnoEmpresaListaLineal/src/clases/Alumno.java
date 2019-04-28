
package clases;
import java.io.*;
/**
 *
 * @author 
 */
public class Alumno implements Serializable {
    
    private int codigo;
    private String nombre;
    private Empresa e;
    private Alumno siguiente;

    public Alumno() {
    }

    public Alumno(int codigo, String nombre, Empresa e, Alumno siguiente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.e = e;
        this.siguiente = siguiente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getE() {
        return e;
    }

    public void setE(Empresa e) {
        this.e = e;
    }

    public Alumno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Alumno siguiente) {
        this.siguiente = siguiente;
    }
}
