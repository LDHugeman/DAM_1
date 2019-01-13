package coleccionnumeros;

import java.io.*;
import java.util.*;

/**
 *
 * @author a18luisdvp
 */
public class ColeccionNumeros {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;
        ArrayList<Float> numeros = null;
        Numeros objNumeros = null;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    numeros = Introducir.obtenerNumeros(lee);
                    break;
                case 2:
                    if (numeros != null) {
                        Visualizar.verNumerosIntroducidos(numeros);
                    }
                    break;
                case 3:
                    objNumeros = Separar.dividirNumeros(numeros);
                    break;
                case 4:
                    if (objNumeros != null) {
                        System.out.printf("--- Números positivos --- %n");
                        Visualizar.verNumeros(objNumeros.getNumerosPositivos());
                        System.out.printf("--- Números negativos --- %n");
                        Visualizar.verNumeros(objNumeros.getNumerosNegativos());
                        System.out.printf("--- Números nulos --- %n");
                        Visualizar.verNumeros(objNumeros.getNumerosNulos());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");                    
            }
        } while (opcionSeleccionada != 5);
    }

}
