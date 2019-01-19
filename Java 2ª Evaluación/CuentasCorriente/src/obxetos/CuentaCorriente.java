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
public class CuentaCorriente extends Cuenta{
    double saldoActual;
    
    public CuentaCorriente(String numero, String sucursal, Cliente primerCliente, double saldoActual) throws IOException{
        super(numero, sucursal, primerCliente);
        this.saldoActual = saldoActual;
    }

    public double getSaldoActual() {
        return saldoActual;
    }
}
