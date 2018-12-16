package bibliotecabufferedreader;

import java.io.*;

/**
 *
 * @author a18luisdvp
 */
public class BibliotecaBufferedReader {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        //ENTRADA
        System.out.printf("Mes: ");
        String mes = lee.readLine();
        System.out.printf("Cantidad de libros prestados: ");
        int cantidadLibrosPrestados = Integer.parseInt(lee.readLine());
        System.out.printf("Título del libro: ");
        String titulo = lee.readLine();
        System.out.printf("Número de consultas del libro en el mes: ");
        byte numeroConsultas = Byte.parseByte(lee.readLine());
        System.out.printf("Préstamos totales en el mes: ");
        int prestamosTotales = Integer.parseInt(lee.readLine());

        //PROCESO
        int tasaDeConsulta = (int) (numeroConsultas * 100) / prestamosTotales;

        //SALIDA
        System.out.printf("El libro %s se consultó %d veces.%n", titulo, numeroConsultas);
        System.out.printf("La tasa de consulta en el mes de %s es %d%% %n", mes, tasaDeConsulta);
    }

}
