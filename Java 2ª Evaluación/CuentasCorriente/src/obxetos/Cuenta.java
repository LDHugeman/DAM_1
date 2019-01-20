package obxetos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Luis David
 */
public class Cuenta {

    private String numero;
    private String sucursal;
    private ArrayList<Cliente> clientes;

    public Cuenta(String numero, String sucursal, Cliente primerCliente) throws IOException {
        this.numero = numero;
        this.sucursal = sucursal;
        this.clientes = new ArrayList<>();
        clientes.add(primerCliente);
    }

    public String getNumero() {
        return numero;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void eliminarCliente(String dni) {
        Cliente clienteABorrar= null;
        Iterator it = clientes.iterator();
        while (it.hasNext()) {
            Cliente cliente = (Cliente) it.next();
            if (cliente.getDNI().equals(dni)) {
                clienteABorrar = cliente;
                System.out.println("Eliminado cliente " + cliente.getDNI() + " de la cuenta " + this.getNumero());               
            }
        }
        clientes.remove(clienteABorrar);
    }   
}
