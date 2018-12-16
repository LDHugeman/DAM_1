package alturasjugadoresao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class AlturasJugadoresAO {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int numeroJugadores = Introducir.obtenerNumeroDeJugadores(lee);
        String[] paises = {"Espana", "Italia", "Francia", "Alemania"};
        Jugador[] jugador = new Jugador[numeroJugadores];
        float[] alturaMediaSelecciones = new float[4];
        byte opcionSeleccionada = 0;
        float alturaMediaTotal = 0;

        do {
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.obtenerJugadores(lee, jugador, paises, numeroJugadores);
                    break;
                case 2:
                    Calcular.alturaMediaPorSeleccion(alturaMediaSelecciones, jugador, paises);
                    Visualizar.alturaMediaPorSeleccion(alturaMediaSelecciones, paises);
                    break;
                case 3:
                    alturaMediaTotal = Calcular.alturaMediaJugadores(jugador);
                    Visualizar.alturaMediaJugadores(alturaMediaTotal);
                    break;
                case 4:
                    Calcular.alturaMaxima(jugador);
                    break;
                case 5:
                    Jugador jugadorEncontrado=Buscar.busquedaDicotomicaPorNombre(jugador, Introducir.obtenerNombreBusqueda(lee));
                    Visualizar.jugador(jugadorEncontrado);
                    break;
                case 6:
                    Buscar.busquedaPorPais(jugador, Introducir.obtenerPaisBusqueda(lee));
                    break;
                case 7:
                    break;
                default:
                    System.err.println("No existe esa opción.");
            }
        } while (opcionSeleccionada != 7);
    }

}
