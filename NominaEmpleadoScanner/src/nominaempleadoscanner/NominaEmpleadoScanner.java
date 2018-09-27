package nominaempleadoscanner;

import java.util.*;

/**
 *
 * @author David
 */
public class NominaEmpleadoScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ENTRADA
        
        System.out.printf("Mes: ");
        String mes = sc.nextLine();
        System.out.printf("Nombre del empleado: ");
        String empleado = sc.nextLine();
        System.out.printf("Sueldo base: ");
        float sueldo = sc.nextFloat(); 
        System.out.println("Porcentaje de descuento: ");
        float porcentajeDescuento = sc.nextFloat();
        System.out.println("Horas extra trabajadas: ");
        byte horasExtraTrabajadas = sc.nextByte();
        System.out.printf("Precio hora: ");
        float precioHora = sc.nextFloat();

    }

}
