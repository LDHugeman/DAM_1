package alturasjugadores;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void imprimirDatosJugador(String nombre, float altura, String pais) {
        System.out.printf("Nombre: %s   Altura: %.2fm   País: %s%n", nombre, altura, pais);
    }

    public static void verAlturasMediasPaises(float[] alturasMediasPaises, String[] paises) {
        System.out.printf("Alturas medias por país:%n");
        for (int i = 0; i < alturasMediasPaises.length; i++) {
            System.out.printf("%s %.2fm%n", paises[i], alturasMediasPaises[i]);
        }
    }

    public static void verAlturaMediaJugadores(float altura) {
        System.out.printf("La altura media de todos los jugadores es: %.2fm%n", altura);
    }
    
    public static void verAlturaMaximaJugadores(String nombreMaximo, String paisMaximo, float alturaMaxima){
        System.out.printf("La altura máxima es la de %s de la selección de %s con una altura de %.2f%nm",nombreMaximo, paisMaximo,alturaMaxima);
    }
    
    public static void errorDatosSinCargar(){
        System.err.printf("No hay datos introducidos %n");
    }
}