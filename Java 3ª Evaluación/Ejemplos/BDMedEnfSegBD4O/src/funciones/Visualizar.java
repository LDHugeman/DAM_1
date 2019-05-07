
package funciones;

import bdmedenfsegbd4o.Menu;
import clases.Enfermo;
import clases.Medico;
import clases.Seguro;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.BufferedReader;

/**
 *
 * @author 
 */
public class Visualizar {
    
    public static void visualizar (BufferedReader lee, ObjectContainer baseDatos) {
        
        int menu;
        
        do  {
            menu = Menu.menu(lee, "VISUALIZAR");
            
            switch (menu) {
                case 1: // Visualizar medicos
                    visuMedicos(baseDatos);
                break;
                case 2: // Visualizar enfermos
                    visuEnfermos(baseDatos);
                break;
                case 3: // Visualizar seguros
                    visuSeguros(baseDatos);
                break;
            }
        } while (menu != 4);
    }
    
    public static void visuMedicos (ObjectContainer baseDatos) {
        
        ObjectSet resultado = baseDatos.queryByExample(new Medico());
        
        titulo("LISTA DE MEDICOS", 50, 53);
        cabecera(new String [] {"--idMedico--", "---NOMBRE---", "ESPECIALIDAD", 
            "--DIRECCION-", "--TELEFONO--", "--ENFERMOS--"}, 12);
        
        while (resultado.hasNext()) {
            Medico medico = (Medico) resultado.next();
            System.out.println(medico);
        }
        separacion(53);  
    }
    
    public static void visuEnfermos (ObjectContainer baseDatos) {
        
        ObjectSet resultado = baseDatos.queryByExample(new Enfermo());
        
        titulo("LISTA DE ENFERMOS", 39, 36);
        cabecera(new String [] {"----DNI-----", "---NOMBRE---", "--PATOLOGIA-", 
                        "---SEGUROS--"}, 12);
        
        while (resultado.hasNext()) {
            Enfermo enfermo = (Enfermo) resultado.next();
            System.out.println(enfermo);
        }
        separacion(36);  
    }
    
    public static void visuSeguros (ObjectContainer baseDatos) {
        
        ObjectSet resultado = baseDatos.queryByExample(new Seguro());
        
        titulo("LISTA DE SEGUROS", 30, 27);
        cabecera(new String [] {"--IDSEGURO--", "---PRECIO---", "PRESTACIONES"}, 12);
        
        while (resultado.hasNext()) {
            Seguro seguro = (Seguro) resultado.next();
            System.out.println(seguro);
        }
        separacion(27);  
    }
    
    // ----------  METODOS PARA LA VISUALIZACION EN UNA TABLA  ---------------//
    
    public static void titulo (String titulo, int n1, int n2) {
        System.out.printf("\033[34m%" + n1 + "s%n", titulo);
        separacion(n2);
    }
    
    public static void cabecera (String [] titulos, int n1) {
        System.out.printf(" ");
        for (String titulo : titulos) {
            System.out.printf("\033[34m%s%-"+ n1 + "s%1$s", "|", titulo);
        }
        System.out.println("");
    }
    
    public static void contenido (String [] contenido, int n1) {
        System.out.printf(" ");
        for (String conten : contenido) {
            System.out.printf("\033[35m%s%-" + n1 + "s%1$s", "|", conten);
        }
        System.out.println("");
    }
    
    public static void separacion (int n1) {
        System.out.printf(" ");
        for (int i = 0; i < n1; i++) {
            System.out.printf("%s", "─");
        }
        System.out.println("");
    }
    
    public static void separadorEnTabla (String nombre, int n1, int n2) {
        System.out.printf(" ");
        for (int i = 0; i < n1; i++) {
            if (i == 0)
                System.out.printf("|");
            
            System.out.printf("%s", "-"); 
           
            if (n2 == i)
                System.out.printf(" %s ", nombre);
            
            if (i == n1 - 1)
                System.out.printf("|");
        }
        System.out.println("");
    }
}
