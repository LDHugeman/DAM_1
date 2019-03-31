package metodos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import objetos.CAutores;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import objetos.CLibros;

/**
 *
 * @author
 */
public class Modificaciones {

    public static void modificarPrecio(File fichero) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del autor");
        File ficheroTemp = new File("temporal.dat");
        String nombre = scan.nextLine();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroTemp));
        CAutores a = null;
        int d = 0;
        try {
            do {
                a = (CAutores) ois.readObject();
                if (a.getNombre().equalsIgnoreCase(nombre)) {
                    d = 1;
                } else {
                    oos.writeObject(a);
                }
            } while (true);
        } catch (EOFException e) {
            if (d != 1) {
                System.out.println("Autor no encontrado");
            }
        } catch (ClassNotFoundException ex) {

        }
        ois.close();

        if (d == 1) {
            CLibros libro = null;
            System.out.println("Introduce el titulo del libro");
            String titulo = scan.nextLine();
            for (CLibros c : a.getLibros()) {
                System.out.println(c.getTitulo());
                if (c.getTitulo().equalsIgnoreCase(titulo)) {

                    libro = c;
                    break;
                }
            }
            if (libro != null) {
                System.out.println("Introduce el nuevo precio\nPrecio actual: " + String.format("%.2f€", libro.getPrecio()));
                float precio = scan.nextFloat();
                scan.nextLine();
                System.out.println("Estas seguro de que quieres modificar el precio?");
                char c = scan.nextLine().toLowerCase().charAt(0);
                if (c == 's') {
                    libro.setPrecio(precio);
                    oos.writeObject(a);
                } else {
                    oos.writeObject(a);
                    System.out.println("No ha sido modificado");
                }
            }
        }
        oos.close();
        fichero.delete();
        ficheroTemp.renameTo(fichero);
    }
}
