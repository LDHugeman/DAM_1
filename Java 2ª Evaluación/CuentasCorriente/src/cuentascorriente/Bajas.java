
package cuentascorriente;

import java.util.ArrayList;
import obxetos.Cuenta;

/**
 *
 * @author Luis David
 */
public class Bajas {
    public  static void eliminarClienteDeCuenta(String dni, String numeroCuenta, ArrayList<Cuenta>cuentas){
        for(Cuenta cuenta : cuentas){
            if(cuenta.getNumero().equals(numeroCuenta)){
                cuenta.eliminarCliente(dni);
            }
        }
    }
}
