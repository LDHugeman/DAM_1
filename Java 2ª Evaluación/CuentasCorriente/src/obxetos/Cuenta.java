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
    
    public Cuenta(String numero, String sucursal, Cliente primerCliente) throws IOException{
        this.numero = numero;
        this.sucursal = sucursal;
        this.clientes = new ArrayList<>();
        clientes.add(primerCliente);
    }
    
    public String getNumero(){
        return numero;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
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
