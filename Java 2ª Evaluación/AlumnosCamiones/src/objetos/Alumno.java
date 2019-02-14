
package objetos;
import interfaces.I_Nexo;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Alumno implements I_Nexo{
    private String dni;
    private String nombre;
    private String ciclo;
    private ArrayList<Asignatura> asignaturas;
    
    public Alumno(String dni, String nombre,  String ciclo, Asignatura primerAsignatura){
        this.dni=dni;
        this.nombre=nombre;
        this.ciclo=ciclo;
        asignaturas=new ArrayList<>();
        asignaturas.add(primerAsignatura);
    }

    @Override
    public float calcular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return nombre;
    } 

    public String getDni() {
        return dni;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }  

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
