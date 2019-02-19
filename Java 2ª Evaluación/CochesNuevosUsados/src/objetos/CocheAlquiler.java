
package objetos;

import java.util.ArrayList;

/**
 *
 * @author a18luisdvp
 */
public class CocheAlquiler extends Coche{
    private float precioDia;
    private ArrayList<Uso> usos;
    
    public CocheAlquiler(String codigo, String marca, String modelo,float precioDia){
        super(codigo, marca, modelo);
        this.precioDia=precioDia;
        this.usos=new ArrayList<>();
    }

    public float getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(float precioDia) {
        this.precioDia = precioDia;
    }

    public ArrayList<Uso> getUsos() {
        return usos;
    }
    
    public void addUso(Uso uso){
        uso.calcularImporte(precioDia);
        usos.add(uso);
    }
    
    public float getImporte(Uso uso){
        return uso.calcularImporte(precioDia);
    }
}
