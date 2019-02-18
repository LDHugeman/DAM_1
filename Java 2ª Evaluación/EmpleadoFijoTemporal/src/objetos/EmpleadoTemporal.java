package objetos;

/**
 *
 * @author a18luisdvp
 */
public class EmpleadoTemporal extends Empleado {

    private String fechaInicio;
    private String fechaFin;
    private double precioDia;

    public EmpleadoTemporal(
            String nss,
            String nombre,
            String primerApellido,
            String segundoApellido,
            String fechaNacimiento,
            char sexo,
            String fechaInicio,
            String fechaFin,
            double precioDia) {
        super(nss, nombre, primerApellido, segundoApellido, fechaNacimiento, sexo);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioDia = precioDia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    @Override
    public float sueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
