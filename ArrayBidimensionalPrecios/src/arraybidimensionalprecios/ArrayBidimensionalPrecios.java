package arraybidimensionalprecios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class ArrayBidimensionalPrecios {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        float[][] precios = new float[3][];
        String[] ciudades = new String[2];
        String[] productos = new String[3];
        byte opcionSeleccionada;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.obterCiudades(ciudades, lee);
                    Introducir.obterProductos(productos, lee);
                    Introducir.obtenerPrecios(precios, ciudades, productos, lee);
            }
        } while (opcionSeleccionada != 6);
    }
}
