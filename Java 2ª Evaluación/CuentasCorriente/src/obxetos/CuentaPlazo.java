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
public class CuentaPlazo extends Cuenta{
    private float intereses;
    private String fechaVencimiento;
    private long depositoPlazo;
    
    public CuentaPlazo(String numero, String sucursal, ArrayList<Cliente> clientes, float intereses, String fechaVencimiento, long depositoPlazo) throws IOException{
        super(numero, sucursal, clientes);
        this.intereses = intereses;
        this.fechaVencimiento = fechaVencimiento;
        this.depositoPlazo = depositoPlazo;
    }

    public float getIntereses() {
        return intereses;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public long getDepositoPlazo() {
        return depositoPlazo;
    }
    
    public void setIntereses(float intereses){
        this.intereses = intereses;
    }
}
