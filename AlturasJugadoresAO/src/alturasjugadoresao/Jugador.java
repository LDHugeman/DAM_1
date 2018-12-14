package alturasjugadoresao;

/**
 *
 * @author a18luisdvp
 */
public class Jugador {

    private String nombre;
    private String pais;
    private float altura;

    public Jugador(String nombre, String pais, float altura) {
        this.nombre = nombre;
        this.pais = pais;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
