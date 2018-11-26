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
        float [] copiaPreciosMediosFila; 
        String [] copiaProductos;
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
                        System.err.printf("No hay datos introducidos. %n");
                    }
                    System.out.printf("MEDIAS OBTENIDAS %n");
                    break;
                case 5:
                    if(datosCargados){
                        System.out.printf("Datos introducidos: %n");
                        Visualizar.verPreciosDeProductosEnCiudades(precios, productos, ciudades);
                    } else {
                        System.err.printf("No hay datos introducidos. %n");
                    }
                    if(mediaCalculada){
                        System.out.printf("Precio medio por producto: %n");
                        Visualizar.verPreciosMediosFila(preciosMediosFila, productos);
                        System.out.printf("Precio medio por ciudad: %n");
                        Visualizar.verPreciosMediosColumna(preciosMediosColumna, ciudades);
                    }else {
                        System.err.printf("No se ha calculado la media. %n");
                    }
                    break;
                case 6:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 6);
    }
}
