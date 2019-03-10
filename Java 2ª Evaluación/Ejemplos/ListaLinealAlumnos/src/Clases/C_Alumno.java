
package Clases;

// @author 

public class C_Alumno {
    
    private String nombre;
    private String modulo;
    private float nota;
    private C_Alumno siguiente;
    
    
    
    public C_Alumno() {}
    
    public C_Alumno(String nombre, String modulo, float nota){
        
        this.nombre=nombre;
        this.modulo=modulo;
        this.nota=nota;    
        
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public C_Alumno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(C_Alumno siguiente) {
        this.siguiente = siguiente;
    }
    
}
