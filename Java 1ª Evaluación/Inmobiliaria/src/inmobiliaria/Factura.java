package inmobiliaria;

/**
 *
 * @author David
 */
public class Factura {

    private String tipoInmueble;
    private double precio;
    private float porcentajeInteres;
    private double precioInteres;
    private double precioTotal;
    private short mensualidades;
    private double precioMensualidad;
    private boolean eFuncionario;

    public Factura(String tipoInmueble, double precio, boolean funcionario) {
        this.tipoInmueble = tipoInmueble;
        this.precio = precio;
        this.eFuncionario = funcionario;
        /*Calcúlanse os valores cando se constrúe o obxecto para evitar
        que se volvan a calcular, xa que son sempre os mesmos*/
        calcularValoresDoObxecto();
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public double getPrecio() {
        return precio;
    }

    public float getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public double getPrecioInteres() {
        return precioInteres;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public short getMensualidades() {
        return mensualidades;
    }

    public double getPrecioMensualidad() {
        return precioMensualidad;
    }

    private void asignarPorcentajeInteres() {
        if (tipoInmueble.equals("Fincas") || tipoInmueble.equals("Solares")) {
            porcentajeInteres = 11f;
            mensualidades = 10 * 12;
        } else if (tipoInmueble.equals("Pisos") || tipoInmueble.equals("Casas")) {
            if (eFuncionario) {
                porcentajeInteres = 7.5f;
            } else {
                porcentajeInteres = 10.5f;
            }
            if (precio <= 100000) {
                mensualidades = 12 * 12;
            } else {
                mensualidades = 20 * 12;
            }
        } else if (tipoInmueble.equals("Locales comerciales")) {
            porcentajeInteres = 10f;
            mensualidades = 15 * 12;
        }
    }

    private double calcularPrecioInteres() {
        return precioInteres = porcentajeInteres * precio / 100;
    }

    private double calcularPrecioTotal() {
        return precioTotal = precio + precioInteres;
    }

    private double calcularPrecioMensualidades() {
        return precioMensualidad = precioTotal / mensualidades;
    }

    private void calcularValoresDoObxecto() {
        asignarPorcentajeInteres();
        calcularPrecioInteres();
        calcularPrecioTotal();
        calcularPrecioMensualidades();
    }
}
