
package cuentascorriente;

import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;
import obxetos.CuentaPlazo;

/**
 *
 * @author Luis David
 */
public class Modificar {

    public static void modificarIntereses(String dni, String numeroCuenta, float nuevosIntereses, ArrayList<Cuenta> cuentas) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroCuenta)) {
                if (cuenta instanceof CuentaPlazo) {
                    for (Cliente cliente : cuenta.getClientes()) {
                        if (cliente.getDNI().equals(dni)) {
                            ((CuentaPlazo) cuenta).setIntereses(nuevosIntereses);
                        }
                    }
                }

            }
        }
    }
}
