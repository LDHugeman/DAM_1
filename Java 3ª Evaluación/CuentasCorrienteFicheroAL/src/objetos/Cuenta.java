package objetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Luis David
 */
public abstract class Cuenta implements Serializable{

    private String numero;
    private String sucursal;
    private ArrayList<Cliente> clientes;

    public Cuenta(String numero, String sucursal) {
        this.numero = numero;
        this.sucursal = sucursal;
        this.clientes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }
    
    public String getSucursal() {
        return sucursal;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }   
}
