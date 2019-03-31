package metodos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import objetos.CAutores;
import objetos.CLibros;

/**
 *
 * @author 
 */
public class BajasFisicas {

    public static void bajaFisica(File fichero) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        File ficheroTemp = new File("Temporal.dat");
        int b = 0;
        char opcion;
        if (fichero.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
            System.out.println("Introduce el titulo del libro");
            String titulo = scan.nextLine();
            CAutores autor;
            try {
                do {
                    CLibros libro = null;
                    autor = (CAutores) ois.readObject();
                    for (CLibros l : autor.getLibros()) {
                        if (l.getTitulo().equalsIgnoreCase(titulo)) {
                            libro = l;
                            b = 1;
                        }
                    }
                    if (b == 1) {
                        System.out.println("Libro encontrado");
                        System.out.println("Titulo: " + libro.getTitulo() + "\nISBN: " + libro.getIsbn());
                        System.out.println("Autor: " + autor.getNombre());
                        System.out.println("Dessea borrar el libro");
                        opcion = scan.nextLine().toLowerCase().charAt(0);
                        if (opcion == 's') {
                            autor.getLibros().remove(libro);
                            if (!autor.getLibros().isEmpty()) {
                                oos.writeObject(autor);
                            }
                        } else {
                            oos.writeObject(autor);
                        }
                    } else {
                        oos.writeObject(autor);
                    }
                } while (true);
            } catch (EOFException e) {
                if (b != 1) {
                    System.out.println("ERROR, CODIGO NO ENCONTRADO");
                }
            }
            oos.close();
            ois.close();
            fichero.delete();
            ficheroTemp.renameTo(fichero);

        } else {
            System.out.println("Fichero inexistente");
        }
    }
}
