
package descnominametodo;
import java.io.*;
/**
 *
 * @author a18luisdvp
 */
public class DescNominaMetodo {

    public static void main(String[] args) throws IOException{
        BufferedReader lee=new BufferedReader(new InputStreamReader(System.in));
        Nomina nomina = new Nomina(pedirNombre(lee), pedirHorasFaltadas(lee) );
        visualizarNomina(nomina);
           
    }
    
    public static String pedirNombre (BufferedReader lee) throws IOException {
        System.out.printf("Nombre del empleado: ");
        return lee.readLine();
    }
    
    public static byte pedirHorasFaltadas (BufferedReader lee) throws IOException {
        System.out.printf("Horas que faltó: ");
        return Byte.parseByte(lee.readLine());
    }
    
    public static void visualizarNomina (Nomina nomina){
        System.out.printf("El empleado %s faltó %d horas.%n",nomina.getEmpleado(), nomina.getHorasFaltadas());
        System.out.printf("Le corresponde un descuento de %.2f euros. %n",nomina.getDescuento());
        System.out.printf("Le restan %d horas para el próximo mes. %n", nomina.getHorasPendientesProximoMes());
        
    }
}
