package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class Factorial {

    public static void main(String[] args) throws IOException {
        int numero = preguntarNumero();
        System.out.println(factorialWhile(numero));
        System.out.println(factorialFor(numero));
    }

    public static int factorialWhile(int numero) {
        int acumulador = 1;
        int resultado = 1;
        while (numero != acumulador) {
            acumulador++;
            resultado = resultado * acumulador;
        }
        return resultado;
    }

    public static int factorialFor(int numero) {
        int resultado = 1;
        for (int acumulador = 1; numero != (acumulador-1); acumulador++) {           
            resultado = resultado * acumulador;
        }
        return resultado;
    }

    public static int preguntarNumero() throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Con qué número desea calcular o factorial?");
        return Integer.parseInt(lee.readLine());
    }

}
