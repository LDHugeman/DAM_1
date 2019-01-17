/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obxetos;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Luis David
 */
public class Cuenta {
    private String numero;
    private String sucursal;
    private ArrayList<Cliente> clientes;
    
    public Cuenta(String numero, String sucursal, ArrayList<Cliente> clientes) throws IOException{
        this.numero = numero;
        this.sucursal = sucursal;
        this.clientes = clientes;
        asociarCuentaEnClientes(clientes);
    }
    
    public String getNumero(){
        return numero;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    private void asociarCuentaEnClientes(ArrayList<Cliente>clientes){
        for(Cliente cliente : clientes){
            cliente.getCuentas().add(this);
        }
    }

    public String getSucursal() {
        return sucursal;
    }
    
    public void eliminarCliente(String dni){
        for(Cliente cliente : clientes){
            if(cliente.getDNI().equals(dni)){
                clientes.remove(cliente);
            }
        }
    }

    
    
    
}
