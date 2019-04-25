
package objetos;

import cuentascorrientefichero.Crear;
import java.io.BufferedReader;
import java.util.ArrayList;
/**
 *
 * @author Luis David
 */
public class CuentaCorriente extends Cuenta{
    double saldoActual;
    private ArrayList<Movimiento> movimientos;
    
    public CuentaCorriente(String numero, String sucursal, double saldoActual) {
        super(numero, sucursal);
        this.saldoActual = saldoActual;
        this.movimientos = new ArrayList<>();
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }         
    
    public void agregarNuevoMovimiento(BufferedReader lee) {
        Movimiento nuevoMovimiento = Crear.nuevoMovimiento(super.getNumero(), saldoActual, lee);
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
