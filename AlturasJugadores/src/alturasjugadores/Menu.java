
package alturasjugadores;

/**
 *
 * @author a18luisdvp
 */
public class Menu {
    
    public static byte seleccionarOpcion(){
        mostrarMenu();
        
    }
    private static void mostrarMenu(){
        System.out.printf("---------- Menú ----------%n"
                + "1. Introducir%n"
                + "2. Altura media de cada selección%n"
                + "3. Altura media de cada jugador%n"
                + "4. Altura máxima%n"
                + "5. Buscar%n"
                + "6: Salir%n"
                + "Seleccione una opción: ");
    }
}
