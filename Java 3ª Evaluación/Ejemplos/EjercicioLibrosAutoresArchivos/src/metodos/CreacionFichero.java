package metodos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class CreacionFichero {

    public static void crear(File fichero) throws IOException {
        byte op;
        Scanner scan= new Scanner(System.in);
        ObjectOutputStream oos;

        if (fichero.exists()) {
            System.out.println("¿Desea eliminar el fichero actual y crear uno nuevo?"
                    + "\n1.SI"
                    + "\nPulse otra tecla para salir.");
            op = scan.nextByte();
            if (op == 1) {
                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                oos.close();
                System.out.println("FICHERO CREADO");
            }
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
            oos.close();
            System.out.println("FICHERO CREADO");
        }
    }
}
