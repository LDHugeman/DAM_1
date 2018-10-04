package objetorectangulo;

import java.util.*;

/**
 *
 * @author clara
 */
public class ObjetoRectangulo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("dame base :");
        int base = sc.nextInt();
        System.out.println("dame altura :");
        float altura = sc.nextFloat();
        //Constructor con parámetros.

        Rectangulo rec2 = new Rectangulo(base, altura);

        //Visualización
        Visualizar.visual(rec2);

        System.out.println("dame base :");
        int base1 = sc.nextInt();
        System.out.println("dame altura :");
        float altura1 = sc.nextFloat();
        //Constructor sin parámetros
        Rectangulo rec = new Rectangulo();

        rec.setBase(base1);
        rec.setAltura(altura1);

        //Visualización
        Visualizar.visual(rec);

    }
}
