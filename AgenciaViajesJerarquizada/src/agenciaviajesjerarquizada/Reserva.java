package agenciaviajesjerarquizada;

/**
 *
 * @author a18luisdvp
 */
public class Reserva {

    private String tipoVivienda;
    private short numeroPersonas;
    private short estancia;
    private double precio;

    public Reserva(String tipoVivienda, short numeroPersonas, short estancia) {
        this.tipoVivienda = tipoVivienda;
        this.numeroPersonas = numeroPersonas;
        this.estancia = estancia;
    }

    public double getPrecio() {
        calcularPrecioVivienda();
        return precio;
    }

    public short getNumeroPersonas() {
        return numeroPersonas;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    private void calcularPrecioVivienda() {
        if (tipoVivienda.equals("Apartamento")) {
            if (numeroPersonas == 1 || numeroPersonas == 2) {
                precio = estancia * 40;
            } else if (numeroPersonas == 3 || numeroPersonas == 4) {
                precio = estancia * 70;
            } else if (numeroPersonas == 5 || numeroPersonas == 6) {
                precio = estancia * 100;
            } else if (numeroPersonas >= 7) {
                precio = estancia * 150;
            }
        } else if (tipoVivienda.equals("Vivienda")) {
            precio = numeroPersonas * 25 * estancia;
        }

        calcularPrecioConDescuento();
    }

    private void calcularPrecioConDescuento() {
        if (estancia > 15) {
            precio = precio - (10 * precio / 100);
        }
    }
}
