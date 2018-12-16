package alturasjugadoresao;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {

    public static int obtenerNumeroDeJugadores(BufferedReader lee) throws IOException {
        System.out.printf("¿Cuántos jugadores desea introducir? %n");
        return Integer.parseInt(lee.readLine());
    }

    public static Jugador[] obtenerJugadores(BufferedReader lee, Jugador[] jugadores, String[] paises, int numeroJugadores) throws IOException {
        for(int i=0; i<jugadores.length;i++){
            jugadores [i]= obtenerJugador(lee, paises);
        }
        return jugadores;
    } 
    
    private static String seleccionarPais(String [] paises,BufferedReader lee)throws IOException{
        System.out.printf("Escoja un país: %n");
        for (int i = 0; i < paises.length; i++){
            System.out.printf("%d. %s %n",i,paises[i]);        
        }
        System.out.printf("País seleccionado: ");
        int paisSeleccionado = Integer.parseInt(lee.readLine());
        return paises[paisSeleccionado];
    }       
    
    private static Jugador obtenerJugador(BufferedReader lee, String[]paises) throws IOException {
        System.out.printf("Nombre del jugador: ");
        String nombre = lee.readLine();
        System.out.printf("Altura de %s:", nombre);
        float altura = Float.parseFloat(lee.readLine());

        return new Jugador(nombre, seleccionarPais(paises, lee), altura);
    }
    
    public static String obtenerNombreBusqueda(BufferedReader lee)throws IOException{
        System.out.printf("Nombre del jugador: ");
        return lee.readLine();
    }
    
    public static String obtenerPaisBusqueda(BufferedReader lee)throws IOException{
        System.out.printf("País: ");
        return lee.readLine();
    }
}
