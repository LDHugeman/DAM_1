
package toxicidad;

/**
 *
 * @author Luis David
 */
public class Producto {
    private String nombre;
    private String tipo;
    private byte grado;
    
    public Producto (String nombreArticulo, byte gradoDeToxicidad, String tipoDeToxicidad){
        this.nombre = nombreArticulo;
        this.grado = gradoDeToxicidad;
        this.tipo = tipoDeToxicidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte getGrado() {
        return grado;
    }

    public void setGrado(byte grado) {
        this.grado = grado;
    }
    
    private void asignarTipo(){
        if(grado>=)
    }
    
    
    
    
}
