
package librosal;

/**
 *
 * @author a18luisdvp
 */
public class Libro {
    String isbn;
    String nombre;
    float precio;
    
    public Libro(){
        
    }
    
    public Libro(String nombre, float precio, String isbn){
        this.nombre = nombre;
        this.precio = precio;
        this.isbn = isbn;               
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }        
}
