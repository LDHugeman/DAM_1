package objetos;

/**
 *
 * @author a18luisdvp
 */
public class Coche {

    private String codigo;
    private String marca;
    private String modelo;

    public Coche(String codigo, String marca, String modelo) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
