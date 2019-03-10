package ensaladaslista;

import java.io.BufferedReader;
import java.util.Date;
import objetos.Ensalada;

/**
 *
 * @author David
 */
public class Crear {

    public static Ensalada listaEnsaladas(Ensalada cabecera, BufferedReader lee) {
        System.out.println("¿Desea eliminar la lista actual y crear una nueva?");
        System.out.println("[1] Sí");
        System.out.println("[2] No");
        System.out.printf("Seleccione una opción: ");
        byte opcion = Pedir.numeroByte(lee);
        if (opcion == 1) {
            cabecera = null;
            System.out.println("Nueva lista creada");
        } else {
            System.out.println("No se ha creado una nueva lista");
        }
        return cabecera;
    }

    public static Ensalada nuevaEnsalada(BufferedReader lee) {
        System.out.printf("Código: ");
        String codigo = Pedir.texto(lee);
        System.out.printf("Marca: ");
        String marca = Pedir.texto(lee);
        System.out.printf("Fecha(dd/MM/yyyy): ");
        Date fecha = Pedir.fecha(lee);
        return new Ensalada(codigo, marca, fecha);
    }
}
