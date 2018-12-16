package alturasjugadoresao;

/**
 *
 * @author David
 */
public class Buscar {

    private static void ordernarBurbujaAscendente(Jugador[] jugadores) {
        Jugador aux;
        for (int i = 0; i < jugadores.length - 1; i++) {
            for (int j = i + 1; j < jugadores.length; j++) {
                if (jugadores[i].getNombre().compareToIgnoreCase(jugadores[j].getNombre()) > 0) {
                    aux = jugadores[i];
                    jugadores[i] = jugadores[j];
                    jugadores[j] = aux;
                }
            }
        }
    }

    public static Jugador busquedaDicotomicaPorNombre(Jugador[] jugadores, String nombreBusqueda) {
        ordernarBurbujaAscendente(jugadores);
        int low = 0;
        int puntoMedio;
        int high = jugadores.length - 1;
        while (low < high) {
            puntoMedio = (int) (low + high) / 2;
            if (nombreBusqueda.compareToIgnoreCase(jugadores[puntoMedio].getNombre()) == 0) {
                low = puntoMedio;
                high = puntoMedio;
            } else if (nombreBusqueda.compareToIgnoreCase(jugadores[puntoMedio].getNombre()) < 0) {
                high = puntoMedio - 1;
            } else {
                low = puntoMedio + 1;
            }
        }
        if (nombreBusqueda.compareToIgnoreCase(jugadores[low].getNombre()) == 0) {
            return jugadores[low];
        } else {
            System.err.printf("No se ha encontrado al jugador %s %n", nombreBusqueda);
            return null;
        }
    }

    public static void busquedaPorPais(Jugador[] jugadores, String paisBusqueda) {
        ordernarBurbujaAscendente(jugadores);
        boolean hayJugadorEncontrado = false;
        System.out.printf("Jugadores de %s %n", paisBusqueda);
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getPais().equalsIgnoreCase(paisBusqueda)) {
                Visualizar.jugador(jugadores[i]);
                hayJugadorEncontrado = true;
            }
        }
        if (!hayJugadorEncontrado) {
            System.err.printf("No se encontraron jugadores de %s. %n", paisBusqueda);
        }
    }
}
