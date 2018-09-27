package nominaempleado;

import java.io.*;

/**
 *
 * @author a18luisdvp
 */
public class NominaEmpleado {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        //ENTRADA
        
        System.out.printf("Nombre del empleado: ");
        String Empleado=lee.readLine();
        System.out.printf("Sueldo base: ");
        String SueldoBase=lee.readLine();
        System.out.printf("Porcentaje de descuento: ");
        String PorcentajeDescuento=lee.readLine();
        System.out.printf("Horas extra trabajadas: ");
        String HorasExtraTrabajadas=lee.readLine();
        
    }

}
