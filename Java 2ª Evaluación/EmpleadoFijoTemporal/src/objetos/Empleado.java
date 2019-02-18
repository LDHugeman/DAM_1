package objetos;

/**
 *
 * @author a18luisdvp
 */
public abstract class Empleado {

    private String nss;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String fechaNacimiento;
    private char sexo;

    public Empleado(
            String nss,
            String nombre,
            String primerApellido,
            String segundoApellido,
            String fechaNacimiento,
            char sexo) {

        this.nss = nss;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public String getNss() {
        return nss;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public abstract float sueldo();
}
