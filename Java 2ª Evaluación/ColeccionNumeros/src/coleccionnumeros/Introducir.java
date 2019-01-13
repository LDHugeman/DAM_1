
package coleccionnumeros;
import java.io.*;
import java.util.*;
/**
 *
 * @author David
 */
public class Introducir {
    
    public static ArrayList<Float> obtenerNumeros(BufferedReader lee)throws IOException{
        ArrayList<Float> numeros = new ArrayList<>();
        char repetir = 'n';
        do{
            System.out.printf("Introduzca un número: ");
            float numero = Float.parseFloat(lee.readLine());
            numeros.add(numero);
            System.out.printf("¿Desea introducir otro número? %n"
                    + "s - Sí %n"
                    + "n - No %n");
            repetir = Character.toLowerCase(lee.readLine().charAt(0));
        }while(repetir =='s');
        return numeros;
    }
}
