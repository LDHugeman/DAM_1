package alturasjugadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class AlturasJugadores {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        float[][] alturas = new float[4][4];
        String[][] nombres = new String[4][4];
        String[] paises = new String[4];
        float[] alturasMediasPaises = new float[4];
        byte opcionSeleccionada;
        float alturaMediaJugadores;     
        boolean estanDatosCargados = false;

        do {

            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.asignarPaises(lee, paises);
                    Introducir.asignarNombres(lee, paises, nombres);
                    Introducir.asignarAlturas(lee, alturas, nombres);
                    estanDatosCargados = true;
                    break;
                case 2:
                    if (estanDatosCargados) {
                        Calcular.asignarAlturasMediasPaises(alturas, alturasMediasPaises);
                        Visualizar.verAlturasMediasPaises(alturasMediasPaises, paises);
                    } else {
                        Visualizar.errorDatosSinCargar();
                    }
                    break;
                case 3:
                    if (estanDatosCargados) {
                        alturaMediaJugadores = Calcular.obterAlturaMediaJugadores(alturas);
                        Visualizar.verAlturaMediaJugadores(alturaMediaJugadores);
                    } else {
                        Visualizar.errorDatosSinCargar();
                    }

                    break;
                case 4:
                    if (estanDatosCargados) {
                        Calcular.asignarAlturaMaxima(alturas, nombres, paises);                      
                    } else {
                        Visualizar.errorDatosSinCargar();
                    }
                    break;
                case 5:
                    if (estanDatosCargados) {
                        Buscar.imprimirResultadoBusqueda(nombres, alturas, paises, Introducir.obterNombre(lee));
                    } else {
                        Visualizar.errorDatosSinCargar();
                    }
                    break;
                case 6:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 6);
    }
}
