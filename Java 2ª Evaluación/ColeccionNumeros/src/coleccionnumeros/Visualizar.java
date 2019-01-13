
package coleccionnumeros;
import java.util.*;
/**
 *
 * @author David
 */
public class Visualizar {
    
    public static void verNumerosIntroducidos(ArrayList<Float> numeros){
        Iterator it = numeros.iterator();
        int contador = 0;
        System.out.printf("--- Números introducidos --- %n");
        while(it.hasNext()){
            contador++;
            float numero = (Float)it.next();
            System.out.printf("Número %d: %.2f %n",contador,numero);
        }
    }
    
    public static void verNumeros(float [] numeros){
        for(int i=0; i<numeros.length; i++){
            System.out.printf("Número %d %.2f %n",i+1, numeros[i]);
        }
    }
}
