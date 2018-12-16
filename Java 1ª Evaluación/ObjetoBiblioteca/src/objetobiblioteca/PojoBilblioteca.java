package objetobiblioteca;

/**
 *
 * @author a18luisdvp
 */
public class PojoBilblioteca {

    //Propiedades
    private String mes;
    private int cantidad;
    private String Titulo;
    private byte numeroConsultas;
    private int totalPréstamos;

    public PojoBilblioteca() {

    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public byte getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(byte numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getTotalPréstamos() {
        return totalPréstamos;
    }

    public void setTotalPréstamos(int totalPréstamos) {
        this.totalPréstamos = totalPréstamos;
    }

    public float TasaConsulta() {
        (numeroConsultas * 100) /totalPréstamos
         return tc;      
    }
}
