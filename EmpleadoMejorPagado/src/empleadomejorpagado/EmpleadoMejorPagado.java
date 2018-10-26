package empleadomejorpagado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class EmpleadoMejorPagado {

    public static void main(String[] args) throws IOException {
        obterEmpleados();
    }

    public static void obterEmpleados() throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String nombreMayor = null;
        float SueldoMayor = 0;
        
        for (int i = 0; i < 10; i++) {
            System.out.printf("Nombre del empleado: ");
            String nombre = lee.readLine();
            System.out.printf("Sueldo: ");
            float sueldo = Float.parseFloat(lee.readLine());
            if (sueldo > SueldoMayor) {
                SueldoMayor = sueldo;
                nombreMayor = nombre;
            }
        }
        System.out.printf("El empleado %s", nombreMayor
                + " es el que tiene el mayor sueldo: %.2f", SueldoMayor);
    }
}
