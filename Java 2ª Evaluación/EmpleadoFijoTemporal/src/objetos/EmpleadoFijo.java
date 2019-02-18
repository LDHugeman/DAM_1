package objetos;

/**
 *
 * @author a18luisdvp
 */
public class EmpleadoFijo extends Empleado {

    private double salarioBase;
    private int trienios;

    public EmpleadoFijo(
            String nss,
            String nombre,
            String primerApellido,
            String segundoApellido,
            String fechaNacimiento,
            char sexo,
            double salarioBase,
            int trienios) {
        super(nss, nombre, primerApellido, segundoApellido, fechaNacimiento, sexo);
        this.salarioBase = salarioBase;
        this.trienios = trienios;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getTrienios() {
        return trienios;
    }

    @Override
    public float sueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
