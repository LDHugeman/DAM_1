
package objetos;

import interfaces.I_Nexo;

/**
 *
 * @author David
 */
public class Camion implements I_Nexo{
    
    private String propietario;
    private String matricula;
    private float kmInicio;
    private float kmFin;
    private float litros;
    private float consumo;
    
    public Camion(String propietario, String matricula, float kmInicio, float kmFin, float litros){
        this.propietario=propietario;
        this.matricula=matricula;
        this.kmInicio=kmInicio;
        this.kmFin=kmFin;
        this.litros=litros;
    }

    @Override
    public float calcular() {
        consumo = (kmFin - kmInicio)*100/litros;
        return consumo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }   

    public float getKmInicio() {
        return kmInicio;
    }

    public float getKmFin() {
        return kmFin;
    }

    public float getLitros() {
        return litros;
    }

    public float getConsumo() {
        calcular();
        return consumo;
    }

    
    
    
}
