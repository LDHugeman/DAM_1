package metodos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import objetos.CAutores;
import objetos.CLibros;

/**
 *
 * @author 
 */
public class Consultas {

    public static void consultarAutor(File fichero) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del autor");
        String nombre = scan.nextLine();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        try {
            do {
                CAutores autor = (CAutores) ois.readObject();
                if (autor.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Autor: " + autor.getNombre());
                    for (CLibros l : autor.getLibros()) {
                        System.out.println("Libro: " + l.getTitulo());
                        System.out.println("ISBN: " + l.getIsbn());
                    }
                    break;
                }
            } while (true);
        } catch (EOFException e) {
             System.out.println(" FIN FICHERO");
        }
       /* finally{
        if (ois!= null) 
                ois.close();
        }*/
    }

    public static void consultarCiudad(File fichero) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre de la ciudad");
        String nombre = scan.nextLine();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        try {
            do {
                CAutores autor = (CAutores) ois.readObject();
                if (autor.getCiudad().equalsIgnoreCase(nombre)) {
                    System.out.println("Autor: " + autor.getNombre());
                    for (CLibros l : autor.getLibros()) {
                        System.out.println("Libro: " + l.getTitulo());
                        System.out.println("ISBN: " + l.getIsbn());
                    }
                }
            } while (true);
        } catch (EOFException e) {
        }
    }

    public static void consultarLibro(File fichero) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        try {
            do {
                CAutores autor = (CAutores) ois.readObject();
                for (CLibros l : autor.getLibros()) {
                    if (l.getPrecio() > 50) {
                        System.out.println("Autor: " + autor.getNombre());
                        System.out.println("Libro: " + l.getTitulo());
                        System.out.println("ISBN: " + l.getIsbn());
                    }
                }
            } while (true);
        } catch (EOFException e) {
        }
    }
}
