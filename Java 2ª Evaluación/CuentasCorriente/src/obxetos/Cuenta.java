/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obxetos;

import cuentascorriente.Crear;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author macbookair
 */
public class Cuenta {
    private String numero;
    private String sucursal;
    private ArrayList<Cliente> clientes;
    
    public Cuenta(String numero, String sucursal, ArrayList<Cliente> clientes) throws IOException{
        this.numero = numero;
        this.sucursal = sucursal;
        this.clientes = clientes;
    }
    
    public String getNumero(){
        return numero;
    }
    
}
