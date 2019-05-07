
package bdmedenfsegbd4o;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author
 */
public class Menu {
    
    public static int menu (BufferedReader lee) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---**************** MENU PRINCIPAL ****************---"
                        + "\n\033[34m1.- Altas"
                        + "\n\033[34m2.- Añadir enfermo nuevo a un medico ya existente"
                        + "\n\033[34m3.- Añadir seguro nuevo a un enfermo ya esxistente"
                        + "\n\033[34m4.- Bajas"
                        + "\n\033[34m5.- Consultas"
                        + "\n\033[34m6.- Visualizar"
                        + "\n\033[34m7.- Borrar BD y salir"
                        + "\n\033[34m8.- Salir"
                        + "\n---************************************************---"); 
                menu = Integer.parseInt(lee.readLine());
                
                if (menu < 0 || menu > 8)
                    System.out.println("\033[31m'Error', elija una opción porfavor");
                
            } catch (NumberFormatException e) {
                System.out.println("\033[31m'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {}
            
        } while (menu < 0 || menu > 8);
        
        return menu;
    }
    
    public static int menu (BufferedReader lee, String mensaje) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---**************** " + mensaje + " ****************---"
                        + "\n\033[34m1.- Medico"
                        + "\n\033[34m2.- Enfermo"
                        + "\n\033[34m3.- Seguro"
                        + "\n\033[34m4.- Salir"
                        + "\n---************************************************---"); 
                menu = Integer.parseInt(lee.readLine());
                
                if (menu < 0 || menu > 4)
                    System.out.println("\033[31m'Error', elija una opción porfavor");
                
            } catch (NumberFormatException e) {
                System.out.println("\033[31m'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {}
            
        } while (menu < 0 || menu > 4);
        
        return menu;
    }
    
    public static int menuConsulta (BufferedReader lee, String mensaje) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---**************** " + mensaje + " ****************---"
                        + "\n\033[34m1.- Los médicos cuya especialidad sea “Dermatología”"
                        + "\n\033[34m2.- Los enfermos con su seguro del medico"
                        + "\n\033[34m3.- Salir"
                        + "\n---************************************************---"); 
                menu = Integer.parseInt(lee.readLine());
                
                if (menu < 0 || menu > 3)
                    System.out.println("\033[31m'Error', elija una opción porfavor");
                
            } catch (NumberFormatException e) {
                System.out.println("\033[31m'Error', introduzca numeros no letras porfavor");
            } catch (IOException e) {}
            
        } while (menu < 0 || menu > 3);
        
        return menu;
    }
    
    public static char confirmacion (BufferedReader lee, String mensaje) {
        
        char menu = 'a';
        
        do {
            try {
                System.out.println(mensaje
                        + "\nS - Si"
                        + "\nN - No");
                menu = lee.readLine().toUpperCase().charAt(0);

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("\033[31m'Error', solo puede introducir una letra");
            } catch (IOException e) {}
            
        } while (menu != 'S' && menu != 'N');
        
        return menu;
    }
}
