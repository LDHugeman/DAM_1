
package descuentoennominascanner;
import java.util.*;
/**
 *
 * @author Luis David
 */
public class DescuentoEnNominaScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //ENTRADA
        
        System.out.printf("Nombre del empleado: ");
        String empleado = sc.nextLine();
        System.out.printf("Horas que faltó: ");
        byte horasFaltadas = sc.nextByte();
        
        //PROCESO
        
        float descuento = (horasFaltadas/3)*30;
        int horasPendientesProximoMes = horasFaltadas%3;
        
        //SALIDA
        
        System.out.printf("El empleado %s faltó %d horas. %n", empleado, horasFaltadas);
        System.out.printf("Le corresponde un descuento de %.2f euros.%n", descuento);
        System.out.printf("Le restan %d horas para el próximo mes. %n",horasPendientesProximoMes);        
    }
    
}
