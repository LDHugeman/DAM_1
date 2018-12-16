
package descuentoennominabr;
import java.io.*;
/**
 *
 * @author Luis David
 */
public class DescuentoEnNominaBR {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        //ENTRADA
        
        System.out.printf("Nombre del empleado: ");
        String empleado = lee.readLine();
        System.out.printf("Horas que faltó: ");
        byte horasFaltadas = Byte.parseByte(lee.readLine());
        
        //PROCESO
        
        float descuento = (horasFaltadas/3)*30;
        int horasPendientesProximoMes = horasFaltadas%3;
        
        //SALIDA
        
        System.out.printf("El empleado %s faltó %d horas. %n", empleado, horasFaltadas);
        System.out.printf("Le corresponde un descuento de %.2f euros.%n", descuento);
        System.out.printf("Le restan %d horas para el próximo mes. %n",horasPendientesProximoMes);
        
              
    }
    
}
