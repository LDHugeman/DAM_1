package alturasjugadores;

/**
 *
 * @author David
 */
public class Buscar {

    public static void imprimirResultadoBusqueda(String[][] nombres, float[][] alturas, String[] paises, String nombreBusqueda) {
        String nombre = null;
        float altura = 0;
        String pais = null;
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                if (nombreBusqueda.equals(nombres[i][j])) {
                    nombre = nombres[i][j];
                    altura = alturas[i][j];
                    pais = paises[i];
                }
            }
        }
        if (nombre != null) {
            Visualizar.imprimirDatosJugador(nombre, altura, pais);
        } else{
            System.err.printf("No se ha encontrado al jugador.%n");
        }

    }
}
