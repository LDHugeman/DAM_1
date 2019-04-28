
package alumnoempresalistalineal;
import java.io.*;
/**
 *
 * @aut
 */
public class Menu {
    
    public static int menu (BufferedReader lee) {
        int menu = 0;
        
        do {
            try {
                System.out.println("---****************** BIENVENIDO ******************---"
                        + "\n\033[34m1.- Crear fichero"
                        + "\n\033[34m2.- Altas"
                        + "\n\033[34m3.- Bajas"
                        + "\n\033[34m4.- Modificaciones"
                        + "\n\033[34m5.- Lista de alumnos (ord. codigo)"
                        + "\n\033[34m6.- Lista de alumnos y empresas (TODO FICHERO)"
                        + "\n\033[34m7.- Borrar fichero"
                        + "\n\033[34m8.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt(lee.readLine());
                
                if (menu < 1 || menu > 8)
                    System.out.println("\033[31m'Error', elija una opción porfavor");
                
            } catch (IOException | NumberFormatException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
        } while (menu < 1 || menu > 8);
        
        return menu;
    }
    
    public static char confirmacion (BufferedReader lee, String mensaje) {
        
        char menu = 'a';
        
        do {
            try {
                System.out.println("\n\033[34m"+mensaje
                        + "\n\033[34mS.- Si"
                        + "\n\033[34mN.- No");
                menu = lee.readLine().toUpperCase().charAt(0);
            }
            catch (IOException | StringIndexOutOfBoundsException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
            
        } while (menu != 'S' && menu != 'N');
        
        return menu;
    }
    
    public static int fichero (BufferedReader lee, String mensaje) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---**** "+mensaje+ " ****---"
                        + "\n\033[34m1.- Sobrescribir fichero"
                        + "\n\033[34m2.- Añadir nuevos registros al fichero"
                        + "\n---************************************************---");
                menu = Integer.parseInt (lee.readLine());
                
                if (menu < 1 || menu > 2)
                    System.out.println("\033[31m'Error', elija una opción porfavor");
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
        } while (menu < 1 || menu > 2);
        
        return menu;
    }
    
    public static int menuAltasBajasModificaciones (BufferedReader lee, String mensaje) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---******************** "+mensaje+ " *********************---"
                        + "\n\033[34m1.- Empresa"
                        + "\n\033[34m2.- Alumno"
                        + "\n\033[34m3.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt (lee.readLine());
                
                if (menu < 1 || menu > 3)
                    System.out.println("\033[31m'Error', elija una opcion porfavor");
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
            
        } while (menu < 1 || menu > 3);
        
        return menu;
    }
    
    public static int menuModiEmpresa (BufferedReader lee) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---******************** ----- *********************---"
                        + "\n\033[34m1.- Razon social"
                        + "\n\033[34m2.- Direccion"
                        + "\n\033[34m3.- Alumnos"
                        + "\n\033[34m4.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt (lee.readLine());
                
                if (menu < 1 || menu > 4)
                    System.out.println("\033[31m'Error', elija una opcion porfavor");
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
            
        } while (menu < 1 || menu > 4);
        
        return menu;
    }
    
    public static int menuModiEmpresaAlu (BufferedReader lee) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---******************** ----- *********************---"
                        + "\n\033[34m1.- Añadir Alumno"
                        + "\n\033[34m2.- Borrar Alumno"
                        + "\n\033[34m3.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt (lee.readLine());
                
                if (menu < 1 || menu > 3)
                    System.out.println("\033[31m'Error', elija una opcion porfavor");
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
            
        } while (menu < 1 || menu > 3);
        
        return menu;
    }
    
    public static int menuModiAlumno (BufferedReader lee) {
        
        int menu = 0;
        
        do {
            try {
                System.out.println("---******************** ----- *********************---"
                        + "\n\033[34m1.- Nombre"
                        + "\n\033[34m2.- Empresa"
                        + "\n\033[34m3.- Salir"
                        + "\n---************************************************---");
                menu = Integer.parseInt (lee.readLine());
                
                if (menu < 1 || menu > 3)
                    System.out.println("\033[31m'Error', elija una opcion porfavor");
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("\033[31m"+e.getMessage());
            }
            
        } while (menu < 1 || menu > 3);
        
        return menu;
    }
}
