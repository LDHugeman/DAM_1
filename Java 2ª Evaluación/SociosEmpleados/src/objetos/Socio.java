package objetos;

import interfaces.I_Dividendos;

/**
 *
 * @author David
 */
public class Socio extends Empleado implements I_Dividendos{

    private int participaciones;
    private final int VALOR = 100;

    public Socio(String nombre, String dni, int sueldo, int participaciones) {
        super(nombre, dni, 23, sueldo);
        this.participaciones = participaciones;
    }
    
    @Override
    public double dividendo() {
        double beneficios = participaciones * VALOR;
        double retencion = I_Dividendos.PORCENTAJE_RETENCION_SOCIO * beneficios/100;
        return beneficios - retencion;
    }

    @Override
    public double sueldoNeto() {
        double retencion = super.getPorcentajeRetencion()* super.getSueldo()/100;
        double sueldo = super.getSueldo()-retencion;
        return sueldo + dividendo();
    }  

    public int getParticipaciones() {
        return participaciones;
    }    
}
