package objetos;

/**
 *
 * @author a18luisdvp
 */
public class Alumno {

    private String nombre;
    private String codigo;
    private String modulo;
    private int nota;
    private Alumno siguiente = null;

    public Alumno(String nombre, String codigo, String modulo, int nota) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.modulo = modulo;
        this.nota = nota;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModulo() {
        return modulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Alumno siguiente) {
        this.siguiente = siguiente;
    }
}
