package librosautores;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author a18luisdvp
 */
public class Altas {

    public static ArrayList<Autor> altaAutores(ArrayList<Autor> autores, ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        ArrayList<Autor> nuevosAutores;
        byte opcionSeleccionada;
        if (autores == null) {
            nuevosAutores = new ArrayList<>();
        } else {
            nuevosAutores = autores;
        }

        do {
            System.out.println("Necesita un libro que pertenezca al autor que va a introducir.");
            Libro primerLibro = Crear.crearNuevoLibro(libros, lee);
            Autor autor = Crear.crearNuevoAutor(lee, primerLibro, nuevosAutores);
            añadirLibrosAutor(autor, libros, lee);
            nuevosAutores.add(autor);
            System.out.println("¿Desea dar de alta un nuevo autor?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            opcionSeleccionada = Byte.parseByte(lee.readLine());
        } while (opcionSeleccionada == 1);
        return nuevosAutores;
    }

    public static Autor añadirLibrosAutor(Autor autor, ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 1;
        while (opcionSeleccionada == 1) {
            System.out.println("¿Desea añadir más libros al autor " + autor.getNombre() + "?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            opcionSeleccionada = Byte.parseByte(lee.readLine());
            if (opcionSeleccionada == 1) {
                Libro libro = Crear.crearNuevoLibro(libros, lee);
                autor.getLibros().add(libro);
            }
        }
        return autor;
    }
}
