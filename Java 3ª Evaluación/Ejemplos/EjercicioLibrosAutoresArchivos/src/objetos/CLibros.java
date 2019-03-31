package objetos;

import java.io.Serializable;

/**
 *
 * @author a16daviddss
 */
public class CLibros implements Serializable {

    private String isbn;
    private String titulo;
    private float precio;

    public CLibros() {
    }

    public CLibros(String isbn, String titulo, float precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
