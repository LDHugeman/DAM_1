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
        System.out.printf("Porcentaje de descuento: ");
        float porcentajeDescuento = sc.nextFloat();
        System.out.printf("Horas extra trabajadas: ");
        byte horasExtraTrabajadas = sc.nextByte();
        System.out.printf("Precio hora: ");
        float precioHora = sc.nextFloat();
        
        //PROCESO

        float horasExtra = horasExtraTrabajadas * precioHora;
        float descuentos = porcentajeDescuento * (sueldo + horasExtra) / 100;
        float diferencia = sueldo - descuentos;
        float sueldoNeto = diferencia + horasExtra;

        //SALIDA
        
        System.out.printf("Mes: %s %n", mes);
        System.out.printf("Nómina del empleado: %s %n", empleado);
        System.out.printf("Porcentaje de descuento: %.2f%% %n", porcentajeDescuento);
        System.out.printf("Horas Extras: %.2f %n", horasExtra);
        System.out.printf("Descuentos: %.2f %n", descuentos);
        System.out.printf("Diferencia: %.2f %n", diferencia);
        System.out.printf("Sueldo Neto: %.2f %n", sueldoNeto);
        
    }

}
