package alturasjugadores;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Introducir {

    public static String obterNombre(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del jugador: ");
        return lee.readLine();
    }

    private static String obterPais(BufferedReader lee) throws IOException {
        System.out.printf("País: ");
        return lee.readLine();
    }

    private static float obterAltura(BufferedReader lee, String nombreJugador) throws IOException {
        System.out.printf("Altura de %s: ", nombreJugador);
        return Float.parseFloat(lee.readLine());
    }

    public static void asignarNombres(BufferedReader lee, String[] paises, String[][] nombres) throws IOException {
        for (int i = 0; i < paises.length; i++) {
            System.out.printf("Introduciendo jugadores de %s:%n", paises[i]);
            for (int j = 0; j < nombres[i].length; j++) {
                nombres[i][j] = obterNombre(lee);
            }
        }  
    }

    public static void asignarPaises(BufferedReader lee, String[] paises) throws IOException {
        for (int i = 0; i < paises.length; i++) {
            paises[i] = obterPais(lee);
        }
    }

    public static void asignarAlturas(BufferedReader lee, float[][] alturas, String[][]nombres) throws IOException {
        for (int i = 0; i < alturas.length; i++) {
            for (int j = 0; j < alturas[i].length; j++) {
                alturas[i][j]= obterAltura(lee, nombres[i][j]);
            }
        }     
    }  
    
}
