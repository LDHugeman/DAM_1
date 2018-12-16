package metodoconsumo;

import java.io.*;

/**
 *
 * @author clara
 */
public class MetodoConsumo {

    public static void Consumo(String Propietario, String Ma, float Litros, float c1, float c2) {

        float Cs = Litros * 100 / (c2 - c1);
        System.out.println("Estamos en Método CONSUMO()***********");
        System.out.printf("el propietario  %s %n", Propietario);
        System.out.printf("la matrícula es %s%n", Ma);
        System.out.printf("el consumo es %.2f%n", Cs);

        //return Cs;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("el propietario es ");
        String Propietario = lee.readLine();
        System.out.printf("La Matricula es=");
        String Ma = lee.readLine();
        System.out.printf("litros ");
        float Litros = Float.parseFloat(lee.readLine());
        System.out.printf("estado cuentaKilómetros1 es =");
        int c1 = Integer.parseInt(lee.readLine());
        System.out.printf("estado cuentaKilómetros2 es =");
        int c2 = Integer.parseInt(lee.readLine());

        /*float c=*/
        Consumo(Propietario, Ma, Litros, c1, c2);
        /*System.out.println("Estamos en main()***********"); 
        System.out.printf("el propietario  %s %n",Propietario);
       System.out.printf("la matrícula es %s%n",Ma);
       System.out.printf("el consumo es %.2f%n",c);*/

    }

}
