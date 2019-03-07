package objetos;

/**
 *
 * @author David
 */
public class Yogourt {

    private String codigo;
    private String marca;
    private String tipo;
    private Yogourt siguiente;

    public Yogourt(String codigo, String marca, String tipo) {
        this.codigo = codigo;
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Yogourt getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Yogourt siguiente) {
        this.siguiente = siguiente;
    }

}
