
package drogueria;

/**
 *
 * @author David
 */
public class Articulo {
    private String nombre;    
    private String tipo;
    
    public Articulo (String nombreArticulo, String tipo){
        this.nombre = nombreArticulo;
        this.tipo = tipo;    
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
}
