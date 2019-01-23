
package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;
import obxetos.CuentaCorriente;

/**
 *
 * @author Luis David
 */
public class Altas {

    public static void altaCuentaCorriente(ArrayList<Cuenta> cuentasGuardadas, ArrayList<Cliente> clientesGardados, BufferedReader lee) throws IOException {
        Cliente primerCliente = obtenerPrimerCliente(clientesGardados, lee);
        String numeroCuenta = Crear.pedirNuevoNumeroCuenta(cuentasGuardadas, lee);
        Cuenta nuevaCuenta = Crear.nuevaCuentaCorriente(numeroCuenta, lee, primerCliente);
        cuentasGuardadas.add(nuevaCuenta);
    }

    public static void altaCuentaPlazo(ArrayList<Cuenta> cuentasGuardadas, ArrayList<Cliente> clientesGuardados, BufferedReader lee) throws IOException, ParseException {
        Cliente primerCliente = obtenerPrimerCliente(clientesGuardados, lee);
        String nuevoNumeroCuenta = Crear.pedirNuevoNumeroCuenta(cuentasGuardadas, lee);
        Cuenta nuevaCuenta = Crear.nuevaCuentaPlazo(nuevoNumeroCuenta, lee, primerCliente);
        cuentasGuardadas.add(nuevaCuenta);
    }

    public static Cliente obtenerPrimerCliente(ArrayList<Cliente> clientes, BufferedReader lee) throws IOException {
        Cliente clienteAsociado;
        if (clientes.size() > 0) {
            clienteAsociado = escojerCliente(clientes, lee);
        } else {
            System.out.println("Necesita crear polo menos un cliente para engadilo a nova conta");
            clienteAsociado = Crear.crearNuevoCliente(Crear.pedirNuevoDNI(clientes, lee), lee, clientes);
        }
        return clienteAsociado;
    }

    public static Cliente escojerCliente(ArrayList<Cliente> clientes, BufferedReader lee) throws IOException {
        Cliente clienteEscogido = null;
        boolean existeCliente = false;
        do {
            System.out.println("Escolla un dni dun dos clientes para engadilo a nova conta, ou pulse 0 para crear un novo");
            String opcion = lee.readLine();
            if (!opcion.equals("0")) {
                if(Consultar.existeCliente(opcion, clientes)){
                    clienteEscogido = Consultar.encontrarCliente(clientes, opcion);
                    existeCliente = true;
                }else{
                    System.out.println("O dni que acaba de insertar non pertence a ningun cliente");
                    existeCliente = false;
                }
                
            } else {
                clienteEscogido = Crear.crearNuevoCliente(Crear.pedirNuevoDNI(clientes, lee), lee, clientes);
                existeCliente = true;
            }
        } while (!existeCliente);

        return clienteEscogido;
    }
    
    public static void altaMovimiento(BufferedReader lee, ArrayList<Cuenta> cuentas)throws IOException, ParseException{
        String numeroCuenta = Crear.pedirNumeroCuenta(lee);
        Cuenta cuenta = Consultar.encontrarCuenta(numeroCuenta, cuentas);
        if(cuenta!=null){
            if(cuenta instanceof CuentaCorriente){
                ((CuentaCorriente) cuenta).agregarNuevoMovimiento();
            }
        }else{
            System.err.printf("No existe esa cuenta. %n");
        }
    }
}
