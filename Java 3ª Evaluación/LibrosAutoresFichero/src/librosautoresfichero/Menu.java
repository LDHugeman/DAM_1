package librosautoresfichero;

import Objetos.Autor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    public static void menuAltas(File fichero, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Autor nuevoAutor = Crear.nuevoAutor(fichero, lee);
                    System.out.println("--- Introduzca un libro para el autor ---");
                    nuevoAutor.getLibros().add(Crear.nuevoLibro(lee));
                    byte opcion = 0;
                    do {
                        System.out.println("¿Desea añadir más libros al autor " + nuevoAutor.getNombre() + "?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opcion: ");
                        opcion = Pedir.numeroByte(lee);
                        if (opcion == 1) {
                            nuevoAutor.getLibros().add(Crear.nuevoLibro(lee));
                        }
                    } while (opcion == 1);
                    Altas.autor(fichero, nuevoAutor);
                    break;
                case 2:
                    if (fichero.exists()) {
                        Altas.libros(fichero, lee);
                    } else {
                        System.err.printf("Fichero inexistente %n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuBajas(File fichero, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuBajas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Autor autorEncontrado = Consultar.encontrarAutorPorDni(fichero, Crear.pedirDniExistente(fichero, lee));
                    if (autorEncontrado != null) {
                        Visualizar.mostrar(autorEncontrado);
                        System.out.println("¿Es este el autor que desea borrar?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opcion: ");
                        byte opcion = Pedir.numeroByte(lee);
                        if (opcion == 1) {
                            Bajas.bajaAutor(fichero, autorEncontrado);
                            System.out.println("El autor " + autorEncontrado.getNombre() + " ha sido eliminado");
                        }
                    } else {
                        System.err.printf("Autor no encontrado %n");
                    }
                    break;

                case 2:
                    Bajas.bajaLibro(fichero, Crear.pedirTitulo(lee), lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Crear fichero");
        System.out.println("[2] Altas");
        System.out.println("[3] Bajas");
        System.out.println("[4] Modificaciones");
        System.out.println("[5] Consultar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Altas de nuevos autores con sus libros");
        System.out.println("[2] Añadir libros a un autor existente");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarOpcionMenuBajas(BufferedReader lee) {
        System.out.println("------- BAJAS -------");
        System.out.println("[1] Baja de un autor");
        System.out.println("[2] Baja de un determinado libro de un autor");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }
}
