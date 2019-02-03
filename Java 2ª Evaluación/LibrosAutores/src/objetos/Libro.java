
package objetos;

/**
 *
 * @author a18luisdvp
 */
public class Libro {
    private String isbn;
    private String titulo;
    private float precio;
    
    public Libro(String isbn, String titulo, float precio){
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPrecio() {
        return precio;
    } 

    public void setPrecio(float precio) {
        this.precio = precio;
    }      
}
