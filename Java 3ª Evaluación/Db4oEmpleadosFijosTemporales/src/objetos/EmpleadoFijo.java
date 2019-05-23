package objetos;

/**
 *
 * @author David
 */
public class EmpleadoFijo extends Empleado {

    private int salarioBase;
    private int trienios;

    public EmpleadoFijo(String dni, String nombre, String telefono, float porcentajeRetencion, String cifEmpresa, int salarioBase, int trienios) {
        super(dni, nombre, telefono, porcentajeRetencion, cifEmpresa);
        this.salarioBase = salarioBase;
        this.trienios = trienios;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTrienios() {
        return trienios;
    }

    public void setTrienios(int trienios) {
        this.trienios = trienios;
    }
    
    @Override
    public float calculoNomina() {
        return (salarioBase + trienios) - (salarioBase + trienios) * super.getPorcentajeRetencion();
    }
}
