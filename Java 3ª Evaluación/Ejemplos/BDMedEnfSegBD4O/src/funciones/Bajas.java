
package funciones;

import bdmedenfsegbd4o.Menu;
import clases.Enfermo;
import clases.Medico;
import clases.Seguro;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author 
 */
public class Bajas {
    
    public static void bajas (BufferedReader lee, ObjectContainer baseDatos) {
        
        int menu;
        
        do  {
            menu = Menu.menu(lee, "BAJAS");
            
            switch (menu) {
                case 1: // baja medicos
                    bajasMedicos(lee, baseDatos);
                break;
                case 2: // baja enfermos
                    bajasEnfermos(lee, baseDatos);
                break;
                case 3: // baja seguro
                    bajasSeguros(lee, baseDatos);
                break;
            }
            
        } while (menu != 4);
    }
    
    public static void bajasMedicos (BufferedReader lee, ObjectContainer baseDatos) {
        
        ObjectSet resultado = baseDatos.queryByExample(new Medico());
        if (resultado.isEmpty()) {
            System.out.println("\033[31mNo hay ningun medico reguistrado en la BD");
            return;
        }
        
        Medico medico; int idMedico;
        
        try {
            do {
                Visualizar.visuMedicos(baseDatos);
                System.out.println("Introduzca el id del medico que desea borrar: ");
                idMedico = Integer.parseInt(lee.readLine());

                medico = new Medico (idMedico, null, null, null, null);
                resultado = baseDatos.queryByExample(medico);

                if (resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese medico no existe");
                else
                    medico = (Medico) resultado.next();

            } while (resultado.isEmpty());
            
            char op = Menu.confirmacion(lee, "Esta seguro de que desea borrar al medico?");
            if (op == 'N') return;

            baseDatos.delete(medico);
            System.out.println("Medico borrado");
            
        } catch (IOException e) {}
    }
    
    public static void bajasEnfermos (BufferedReader lee, ObjectContainer baseDatos) {
        
        ObjectSet resultado = baseDatos.queryByExample(new Enfermo());
        if (resultado.isEmpty()) {
            System.out.println("\033[31mNo hay ningun enfermo reguistrado en la BD");
            return;
        }
        
        Enfermo enfermo; String dni;
        
        try {
            do {
                Visualizar.visuEnfermos(baseDatos);
                System.out.println("Introduzca el dni del enfermo que desea borrar: ");
                dni = lee.readLine();

                enfermo = new Enfermo (dni, null, null);
                resultado = baseDatos.queryByExample(enfermo);

                if (resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese enfermo no existe");
                else {
                    borrarEnfermoMedico (baseDatos, enfermo);
                    enfermo = (Enfermo) resultado.next();
                }
                    

            } while (resultado.isEmpty());
            
            char op = Menu.confirmacion(lee, "Esta seguro de que desea borrar al enfermo?");
            if (op == 'N') return;
            
            baseDatos.delete(enfermo);
            System.out.println("Enfermo borrado");
            
        } catch (IOException e) {}
    }
    
    public static void bajasSeguros (BufferedReader lee, ObjectContainer baseDatos) {
        
        ObjectSet resultado = baseDatos.queryByExample(new Seguro());
        if (resultado.isEmpty()) {
            System.out.println("\033[31mNo hay ningun seguro reguistrado en la BD");
            return;
        }
        
        Seguro seguro; int idSeguro, b;
        
        try {
            do {
                b = 0;
                Visualizar.visuSeguros(baseDatos);
                System.out.println("Introduzca el id del seguro que desea borrar: ");
                idSeguro = Integer.parseInt(lee.readLine());

                seguro = new Seguro (idSeguro, 0, null);
                resultado = baseDatos.queryByExample(seguro);

                if (resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese seguro no existe");
                else { // comprobacion                   
                    if (comprobarSeguro (baseDatos, seguro)) {
                        b = 1;
                        System.out.println("\033[31mHay algun enfermo aun asegurado, no puede borrar este seguro");
                    }
                    else
                        seguro = (Seguro) resultado.next();
                }

            } while (resultado.isEmpty() || b == 1);
            
            char op = Menu.confirmacion(lee, "Esta seguro de que desea borrar el seguro?");
            if (op == 'N') return;
            
            baseDatos.delete(seguro);
            System.out.println("Seguro borrado");
            
        } catch (IOException e) {}
    }
    
    public static boolean comprobarSeguro (ObjectContainer baseDatos, Seguro seguro) {
        
        Enfermo enfermo = new Enfermo ();
        ObjectSet resultado = baseDatos.queryByExample(enfermo);
        
        while(resultado.hasNext()) {
            enfermo = (Enfermo) resultado.next();
            for (Seguro seg : enfermo.getSeguros()) {
                if (seg.getIdSeguro() == seguro.getIdSeguro())
                    return true;
            }
        }
        return false;
    }
    
    public static void borrarEnfermoMedico (ObjectContainer baseDatos, Enfermo enfermo) {
        
        Medico medico = new Medico ();
        ObjectSet resultado = baseDatos.queryByExample(medico);
        
        while(resultado.hasNext()) {
            medico = (Medico) resultado.next();
            for (int i = 0; i < medico.getEnfermos().size(); i++) {
                if (medico.getEnfermos().get(i).getDni().compareToIgnoreCase(enfermo.getDni()) == 0) {
                    medico.getEnfermos().remove(medico.getEnfermos().get(i));
                    break;
                }
            }
            baseDatos.store(medico);
        }
    }
}
