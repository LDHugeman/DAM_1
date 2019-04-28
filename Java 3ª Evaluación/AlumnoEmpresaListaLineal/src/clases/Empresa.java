
package clases;
import java.util.*;
import java.io.*;
/**
 *
 * @author 
 */
public class Empresa implements Serializable {
    
    private String cif;
    private String razonSocial;
    private String direccion;
    private ArrayList <Alumno> alumnos;

    public Empresa() {
    }

    public Empresa(String cif, String razonSocial, String direccion) {
        this.cif = cif;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.alumnos = new ArrayList <Alumno> ();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
