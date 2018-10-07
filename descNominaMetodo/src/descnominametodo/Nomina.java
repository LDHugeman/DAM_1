
package descnominametodo;

/**
 *
 * @author a18luisdvp
 */
public class Nomina {
    
    //Propiedades
    private String nombreEmpleado;
    private byte horasFaltadas;
    private float descuento;
    private int horasPendientesProximoMes;
    
    public Nomina (){
    }
    
    public Nomina(String empleado, byte horasFaltadas){
        this.nombreEmpleado = empleado;
        this.horasFaltadas = horasFaltadas;
    }
    
    public String getEmpleado() {
        return nombreEmpleado;
    }

    public void setEmpleado(String empleado) {
        this.nombreEmpleado = empleado;
    }

    public byte getHorasFaltadas() {
        return horasFaltadas;
    }

    public void setHorasFaltadas(byte horasFaltadas) {
        this.horasFaltadas = horasFaltadas;
    }
    
    private float calculoDoDesconto (){
        descuento = (horasFaltadas/3)*30;
        return descuento;
    }
    private int calculoHorasPendientes (){
        horasPendientesProximoMes = horasFaltadas%3;
        return horasPendientesProximoMes;
    }

    public float getDescuento() {
        return calculoDoDesconto();
    }

    public int getHorasPendientesProximoMes() {
        return calculoHorasPendientes();
    }
    
}
