
package descnominametodo;

/**
 *
 * @author a18luisdvp
 */
public class ObjetoNomina {
    private String empleado;
    private byte horasFaltadas;
    
    public ObjetoNomina (){
    }
    
    ObjetoNomina objetoNomina = new ObjetoNomina(empleado, horasFaltadas);
 
    public ObjetoNomina(String empleado, byte horasFaltadas){
        this.empleado = empleado;
        this.horasFaltadas = horasFaltadas;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public byte getHorasFaltadas() {
        return horasFaltadas;
    }

    public void setHorasFaltadas(byte horasFaltadas) {
        this.horasFaltadas = horasFaltadas;
    }
    
    public float descuento (){
        float descuento = (horasFaltadas/3)*30;
        return descuento;
    }
    public int horasPendientesProximoMes (){
        int horasPendientesProximoMes = horasFaltadas%3;
        return horasPendientesProximoMes;
    }
}
