package objetos;

/**
 *
 * @author David
 */
public class Jefe extends Empleado{

    private int plus;

    public Jefe(String nombre, String dni, int sueldo, int plus) {
        super(nombre, dni, 30, sueldo);
        this.plus = plus;
    }

    @Override
    public double sueldoNeto() {
        double retencion = super.getPorcentajeRetencion() * super.getSueldo() / 100;
        return (super.getSueldo() - retencion) + plus;
    }

}
