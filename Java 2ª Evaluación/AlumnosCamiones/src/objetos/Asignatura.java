
package objetos;

/**
 *
 * @author David
 */
public class Asignatura {
    private String nombre;
    private float nota;
    
    public Asignatura(String nombre, float nota){
        this.nombre=nombre;
        this.nota=nota;
    }

    public String getNombre() {
        return nombre;
    }

    public float getNota() {
        return nota;
    }      
}
