package coleccionnumeros;

import java.util.*;

/**
 *
 * @author David
 */
public class Separar {

    public static Numeros dividirNumeros(ArrayList<Float> numeros) {       
        int contadorPositivos = 0;
        int contadorNegativos = 0;
        int contadorNulos=0;        
        for (Float numero : numeros) {
            if (numero > 0) {
                contadorPositivos++;
            } else if (numero < 0) {
                contadorNegativos++;
            } else if (numero ==0){
                contadorNulos++;
            }
        }
        float [] numerosPositivos = new float [contadorPositivos];
        float [] numerosNegativos = new float [contadorNegativos];
        float [] numerosNulos = new float [contadorNulos];
        contadorPositivos =0;
        contadorNegativos =0;
        contadorNulos =0;
        for (Float numero : numeros) {
            if (numero > 0) {
                numerosPositivos [contadorPositivos] = numero;
                contadorPositivos++;               
            } else if (numero < 0) {
                numerosNegativos [contadorNegativos] = numero;
                contadorNegativos++;
            } else if (numero ==0){
                numerosNulos [contadorNulos] = numero;
                contadorNulos++;
            }
        }
        return new Numeros(numerosPositivos, numerosNegativos, numerosNulos);
    }
}
