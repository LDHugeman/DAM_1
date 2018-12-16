package alturasjugadoresao;

/**
 *
 * @author David
 */
public class Calcular {

    public static float[] alturaMediaPorSeleccion(float[] alturaMediaSelecciones, Jugador[] jugadores, String[] paises) {
        for (int i = 0; i < paises.length; i++) {
            float sumaAlturas = 0;
            byte contaJugadoresPais = 0;
            for (int j = 0; j < jugadores.length; j++) {
                if (jugadores[j].getPais().equals(paises[i])) {
                    sumaAlturas += jugadores[j].getAltura();
                    contaJugadoresPais++;
                }
            }
            alturaMediaSelecciones[i] = sumaAlturas / contaJugadoresPais;
        }
        return alturaMediaSelecciones;
    }

    public static float alturaMediaJugadores(Jugador[] jugadores) {
        float sumaAlturas = 0;
        for (int i = 0; i < jugadores.length; i++) {
            sumaAlturas += jugadores[i].getAltura();
        }
        return sumaAlturas / jugadores.length;
    }

    public static void alturaMaxima(Jugador[] jugadores) {
        String nombre = "";
        String pais = "";
        float alturaMaxima = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getAltura()>alturaMaxima) {
                nombre = jugadores[i].getNombre();
                pais = jugadores[i].getPais();
                alturaMaxima= jugadores[i].getAltura();
            }
        }
        System.out.printf("La altura máxima es la de %s de la selección de %s con una altura de %.2f%n",nombre,pais,alturaMaxima);
    }       
}

