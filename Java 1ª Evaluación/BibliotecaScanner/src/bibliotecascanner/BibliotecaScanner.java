package bibliotecascanner;

import java.util.*;

/**
 *
 * @author Luis David
 */
public class BibliotecaScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ENTRADA
        
        System.out.printf("Mes: ");
        String mes = sc.nextLine();
        System.out.printf("Título del libro: ");
        String titulo = sc.nextLine();
        System.out.printf("Cantidad de libros prestados: ");
        int cantidadLibrosPrestados = sc.nextInt();
        System.out.printf("Número de consultas del libro en el mes: ");
        byte numeroConsultas = sc.nextByte();
        System.out.printf("Préstamos totales en el mes: ");
        int prestamosTotales = sc.nextInt();

        //PROCESO
        
        int tasaDeConsulta = (int) (numeroConsultas * 100) / prestamosTotales;

        //SALIDA
        
        System.out.printf("El libro %s se consultó %d veces.%n", titulo, numeroConsultas);
        System.out.printf("La tasa de consulta en el mes de %s es %d%% %n", mes, tasaDeConsulta);       



    }

}
