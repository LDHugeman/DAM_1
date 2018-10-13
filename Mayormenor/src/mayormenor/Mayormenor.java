
package mayormenor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Luis David
 */
public class Mayormenor {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        NumeroMayorYMenor numeroMayorYMenor = obterNumeros(lee);
        System.out.println("El número mayor es " + numeroMayorYMenor.getNumeroMayor() + 
        " y el menor es el " + numeroMayorYMenor.getNumeroMenor()+ ".");
       
    }
    
    public static NumeroMayorYMenor obterNumeros(BufferedReader lee)throws IOException{
        System.out.printf("Primer número: ");
        int numero1 = Integer.parseInt(lee.readLine());
        System.out.printf("Segundo número: ");
        int numero2 = Integer.parseInt(lee.readLine());
        System.out.printf("Tercer número: ");
        int numero3 = Integer.parseInt(lee.readLine());
        
        return new NumeroMayorYMenor(numero1, numero2, numero3);
    }
}
