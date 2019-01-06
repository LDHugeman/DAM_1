package librosal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Luis David
 */
public class Introducir {

    public static void asignarLibros(ArrayList<Libro> libro, BufferedReader lee) throws IOException {
        char repetir = 'n';
        do {

            System.out.printf("Introduzca nombre del libro: ");
            String nombre = lee.readLine();
            System.out.printf("Introduzca precio del libro: ");
            Float precio = Float.parseFloat(lee.readLine());
            System.out.printf("Introduzca isbn del libro: ");
            String isbn = lee.readLine();
            libro.add(new Libro(nombre, precio, isbn));

            System.out.printf("¿Desea introducir otro libro? %n"
                    + "s - Sí %n"
                    + "n - No %n");
            repetir = Character.toLowerCase(lee.readLine().charAt(0));
        } while (repetir == 's');
    }

    public static void Insertar(ArrayList<Libro> libro, BufferedReader lee) throws IOException {
        System.out.printf("--- Introduciendo libro en la posición 4 --- %n");
        System.out.printf("Introduzca nombre del libro: ");
        String nombre = lee.readLine();
        System.out.printf("Introduzca precio del libro: ");
        Float precio = Float.parseFloat(lee.readLine());
        System.out.printf("Introduzca isbn del libro: ");
        String isbn = lee.readLine();

        libro.add(4, new Libro(nombre, precio, isbn));
    }
    
    public static String obtenerIsbnBusqueda(BufferedReader lee)throws IOException{
        System.out.printf("Introduzca el isbn del libro que desea borrar: ");
        return lee.readLine();
    }
    
    public static String obternerLibroBusqueda(BufferedReader lee)throws IOException{
        System.out.printf("Introzca el nombre del libro que desea modificar: ");
        return lee.readLine();
        
    }
}
