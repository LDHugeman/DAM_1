
package clientesbancarios;

/**
 *
 * @author David
 */
public class Cliente {
    private String nombre;
    private float saldo = 0;
    
    public Cliente (String nombre, float saldo){
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }       
}
