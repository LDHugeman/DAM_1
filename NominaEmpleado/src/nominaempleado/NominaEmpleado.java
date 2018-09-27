package nominaempleado;

import java.io.*;

/**
 *
 * @author a18luisdvp
 */
public class NominaEmpleado {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        //ENTRADA
        
        System.out.printf("Nombre del empleado: ");
        String empleado = lee.readLine();
        System.out.printf("Sueldo base: ");
        float sueldo = Float.parseFloat(lee.readLine());
        System.out.printf("Porcentaje de descuento: ");
        float porcentajeDescuento = Float.parseFloat(lee.readLine());
        System.out.printf("Horas extra trabajadas: ");
        byte horasExtraTrabajadas = Byte.parseByte(lee.readLine());
        System.out.printf("Precio hora: ");
        float precioHora = Float.parseFloat(lee.readLine());
        System.out.printf("Mes: ");
        String mes = lee.readLine();
        
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
