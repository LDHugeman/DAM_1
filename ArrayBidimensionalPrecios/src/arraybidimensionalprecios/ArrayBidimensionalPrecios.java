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
        float[] preciosMediosFila = new float[precios.length]; //Podría ser 3
        float[] preciosMediosColumna = new float[ciudades.length]; //Podría ser 2
        byte opcionSeleccionada;
        boolean datosCargados = false;
        boolean mediaCalculada = false;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.obterCiudades(ciudades, lee);
                    Introducir.obterProductos(productos, lee);
                    Introducir.obtenerPrecios(precios, ciudades, productos, lee);
                    datosCargados = true;
                    break;
                case 2:
                    if (datosCargados) {
                        Calcular.obterPrecioMedioPorFila(precios, preciosMediosFila);
                        Calcular.obterPrecioMedioPorColumna(precios, preciosMediosColumna);
                        mediaCalculada = true;
                    } else {
                        System.err.println("No hay datos introducidos. %n");
                    }
                    System.out.printf("MEDIAS OBTENIDAS %n");
                    break;
                case 5:
                    if(datosCargados){
                        Visualizar.verPreciosDeProductosEnCiudades(precios, productos, ciudades);
                    } else {
                        System.err.println("No hay datos introducidos. %n");
                    }
                    if(mediaCalculada){
                        Visualizar.verPreciosMediosFila(precios, preciosMediosFila, productos, ciudades);
                        Visualizar.verPreciosMediosColumna(precios, preciosMediosColumna, productos, ciudades);
                    }
                    break;
                default:
                    System.err.printf("Esa opción no existe.");
            }
        } while (opcionSeleccionada != 6);
    }
}
