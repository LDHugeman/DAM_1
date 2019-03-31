package metodos;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class Menu {

    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.-Creacion del fichero\n2.-Altas de libros\n3.-Modificar precio\n4.-Bajas fisicas\n5.-Cosultas");
        return scan.nextInt();
    }

    public static int submenuConsultas() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.-Libros de un autor\n2.-Ver autores de una ciudad\n3.-Visualizar libros de mas de 50€");
        return scan.nextInt();
    }
}
