package alturasjugadoresao;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void alturaMediaPorSeleccion(float[] alturaMediaSelecciones, String[] paises) {
        System.out.printf("Altura media de cada selección: %n");
        for (int i = 0; i < alturaMediaSelecciones.length; i++) {
            if (alturaMediaSelecciones[i] > 0) {
                System.out.printf("%s: %.2f %n", paises[i], alturaMediaSelecciones[i]);
            }
        }
    }

    public static void alturaMediaJugadores(float alturaMediaTotal) {
        System.out.printf("Altura media de todos los jugadores: %.2f %n", alturaMediaTotal);
    }

    public static void jugador(Jugador jugador) {
        if (jugador != null) {
            System.out.printf("Nombre: %s País: %s Altura: %.2f %n",jugador.getNombre(),jugador.getPais(),jugador.getAltura());
        }
    }   
}
