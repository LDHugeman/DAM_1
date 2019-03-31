package metodos;

import objetos.ObjectOutputStreamSincabecera;
import excepciones.Validar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import objetos.CAutores;
import objetos.CLibros;

/**
 *
 * @author
 */
public class Altas {

    public static void altas(File fichero) throws IOException {
        Scanner scan = new Scanner(System.in);
        ObjectOutputStreamSincabecera oos;
        if (fichero.exists()) {
            oos = new ObjectOutputStreamSincabecera(new FileOutputStream(fichero, true));
            System.out.println("Introduce el titulo del libro");
            String titulo = scan.nextLine();
            System.out.println("Introduce el ISBN del libro");
            String isbn = scan.nextLine();
            System.out.println("Introduce el precio del libro");
            float precio = scan.nextFloat();
            scan.nextLine();
            CLibros libro = new CLibros(isbn, titulo, precio);
            CAutores autor = altasAutor(fichero, libro);
            oos.writeObject(autor);
            oos.close();
        } else {
            System.out.println("FICHERO INEXISTENTE");

        }
    }

    public static CAutores altasAutor(File fichero, CLibros libro) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del autor");
        String nombre = scan.nextLine();
        int error = 0;
        String dni;
        do {
            System.out.println("Introduce el dni del autor");
            dni = scan.nextLine();
            try {
                error = Validar.validarDni(dni, fichero);
            } catch (IOException e) {
            }
        } while (error == 1);
        System.out.println("Introduce el nombre de la ciudad del autor");
        String ciudad = scan.nextLine();
        CAutores autor = new CAutores(dni, nombre, ciudad);
        autor.getLibros().add(libro);
        return autor;
    }

    public static CLibros altasLibro(CAutores autor, CLibros libro) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el titulo del libro");
        String titulo = scan.nextLine();
        System.out.println("Introduce el ISBN del libro");
        return libro;
    }
}
