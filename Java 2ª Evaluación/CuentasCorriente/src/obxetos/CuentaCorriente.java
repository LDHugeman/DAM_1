
package obxetos;

import java.io.IOException;
import java.util.ArrayList;
import cuentascorriente.Crear;
import java.text.ParseException;
/**
 *
 * @author Luis David
 */
public class CuentaCorriente extends Cuenta{
    double saldoActual;
    private ArrayList<Movimiento> movimientos;
    
    public CuentaCorriente(String numero, String sucursal, Cliente primerCliente, double saldoActual) throws IOException{
        super(numero, sucursal, primerCliente);
        this.saldoActual = saldoActual;
        this.movimientos = new ArrayList<>();
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }        
    
    public void agregarNuevoMovimiento() throws IOException, ParseException{
        Movimiento nuevoMovimiento = Crear.crearMovimiento(super.getNumero(), saldoActual);
        double nuevoSaldo =saldoActual + nuevoMovimiento.getCantidad();
        if(nuevoSaldo>=0){
            movimientos.add(nuevoMovimiento);
            saldoActual= nuevoSaldo;
            System.out.printf("Saldo actualizado %n");
        } else{
            System.err.printf("Saldo insuficiente %n");       
        }
    }
}
