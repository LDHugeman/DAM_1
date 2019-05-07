
package objetos;

/**
 *
 * @author David
 */
public class Coche extends Vehiculo{
    
    private String modelo;

    public Coche(String matricula, String propietario, float precio, String modelo) {
        super(matricula, propietario, precio);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public float getImpuesto() {
        return super.getPrecio() * 0.90f;
    }   
}
