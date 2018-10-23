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
        switch (tipoVivienda) {
            case "Apartamento":
                switch (numeroPersonas) {
                    case 1:
                    case 2:
                        precio = estancia * 40;
                        break;
                    case 3:
                    case 4:
                        precio = estancia * 70;
                        break;
                    case 5:
                    case 6:
                        precio = estancia * 100;
                        break;
                    default:
                        if (numeroPersonas >= 7) {
                            precio = estancia * 150;
                        }
                }
                break;
            case "Vivienda":
                precio = numeroPersonas * 25 * estancia;
                break;
        }

        calcularPrecioConDescuento();
    }

    private void calcularPrecioConDescuento() {
        if (estancia > 15) {
            precio = precio - (10 * precio / 100);
        }
    }
}
