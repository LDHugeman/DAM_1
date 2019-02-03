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
public class Menu {

    public static ArrayList<Autor> menuAltas(ArrayList<Autor> autores, ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    autores = Altas.altaAutores(autores, libros, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción. %n");
            }
        } while (opcionSeleccionada != 0);
        return autores;
    }

    public static void menuModificaciones(ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuModificaciones(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Libro libro;
                    do {
                        String isbn = Crear.pedirIsbn(lee);
                        libro = Consultar.encontrarLibro(isbn, libros);
                    } while (libro == null || !modificacionPrecioConfirmada(libro, lee));
                    libro = Modificar.modificarPrecioLibro(libro, lee);
                    System.out.printf("Precio del libro %s modificado. %n", libro.getTitulo());
                    Visualizar.mostrarLibro(libro);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción. %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuBajas(ArrayList<Autor> autores, ArrayList<Libro> libros, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuBajas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Libro libro;
                    do {
                        String nombre = Crear.pedirTitulo(lee);
                        libro = Consultar.encontrarLibroPorNombre(nombre, libros);
                    } while (libro == null || !eliminacionLibroConfirmada(libro, lee));
                    Bajas.eliminarLibro(autores, libros, libro);
                    System.out.printf("Libro %s eliminado. %n", libro.getTitulo());
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción. %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuConsultas(ArrayList<Autor> autores, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuConsultas(lee);
            switch (opcionSeleccionada) {

                case 1:
                    Autor autor = Consultar.encontrarAutorPorNombre(Crear.pedirNombreAutor(lee), autores);
                    if (autor != null) {
                        System.out.printf("Viendo libros del autor %s %n", autor.getNombre());
                        Visualizar.mostrarLibros(autor.getLibros());
                    } else {
                        System.err.printf("Ese autor no existe. %n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción. %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Altas");
        System.out.println("[2] Modificaciones");
        System.out.println("[3] Bajas");
        System.out.println("[4] Consultas");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) throws IOException {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Autor");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuModificaciones(BufferedReader lee) throws IOException {
        System.out.println("------- MODIFICACIONES -------");
        System.out.println("[1] Precio de un libro");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuBajas(BufferedReader lee) throws IOException {
        System.out.println("------- BAJAS -------");
        System.out.println("[1] Eliminar un libro");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuConsultas(BufferedReader lee) throws IOException {
        System.out.println("------- CONSULTAS -------");
        System.out.println("[1] Ver libros de un autor");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static boolean modificacionPrecioConfirmada(Libro libro, BufferedReader lee) throws IOException {
        Visualizar.mostrarLibro(libro);
        System.out.println("Es " + libro.getTitulo() + " el libro al que desea modificar el precio?");
        System.out.println("[1] Sí.");
        System.out.println("[2] No.");
        System.out.printf("Seleccione una opción: ");
        byte opcionSeleccionada = Byte.parseByte(lee.readLine());
        if (opcionSeleccionada == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean eliminacionLibroConfirmada(Libro libro, BufferedReader lee) throws IOException {
        Visualizar.mostrarLibro(libro);
        System.out.println("Es " + libro.getTitulo() + " el libro que desea eliminar?");
        System.out.println("[1] Sí.");
        System.out.println("[2] No.");
        System.out.printf("Seleccione una opción: ");
        byte opcionSeleccionada = Byte.parseByte(lee.readLine());
        if (opcionSeleccionada == 1) {
            return true;
        } else {
            return false;
        }
    }
}
