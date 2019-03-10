package ensaladaslista;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import objetos.Ensalada;

/**
 *
 * @author David
 */
public class EnsaladasLista {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Ensalada cabecera = null;
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenu(lee);
            switch (opcionSeleccionada) {
                case 1:
                    cabecera = Crear.listaEnsaladas(cabecera, lee);
                    break;
                case 2:
                    byte opcion = 0;
                    do {
                        Ensalada nuevaEnsalada = Crear.nuevaEnsalada(lee);
                        cabecera = Altas.nuevaEnsalada(cabecera, nuevaEnsalada);
                        System.out.println("¿Desea introducir una nueva ensalada?");
                        System.out.println("[1] Si");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcion = Pedir.numeroByte(lee);
                    } while (opcion == 1);
                    break;
                case 3:
                    Visualizar.mostrarEnsaladasCaducadas(cabecera);
                    System.out.println("¿Desea eliminar las ensaladas caducadas?");
                    System.out.println("[1] Si");
                    System.out.println("[2] No");
                    System.out.printf("Seleccione una opción: ");
                    opcion = Pedir.numeroByte(lee);
                    if (opcion == 1) {
                        cabecera = Bajas.eliminarEnsaladasCaducadas(cabecera);
                        System.out.println("Todas las ensaldas caducadas han sido borradas");
                    } else {
                        System.out.println("No se han borrado las ensaladas caducadas");
                    }
                    break;
                case 4:
                    Visualizar.mostrarEnsaladas(cabecera);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opción %n");
            }
        } while (opcionSeleccionada != 0);

    }

}
