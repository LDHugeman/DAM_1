
package funciones;

import bdmedenfsegbd4o.Menu;
import clases.Enfermo;
import clases.Medico;
import clases.Seguro;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.*;

/**
 *
 * @author
 */
public class Altas {
    
    public static void altas (BufferedReader lee, ObjectContainer baseDatos) {
        
        int menu;
        
        do  {
            menu = Menu.menu(lee, "ALTAS");
            
            switch (menu) {
                case 1: // alta medicos
                    altasMedicos(lee, baseDatos);
                break;
                case 2: // alta enfermos
                    altasEnfermos(lee, baseDatos);
                break;
                case 3: // alta seguro
                    altasSeguros(lee, baseDatos);
                break;
            }
        } while (menu != 4);
    }
    
    public static void altasMedicos (BufferedReader lee, ObjectContainer baseDatos) {
        
        Medico medico; Enfermo enfermo; Seguro seguro;
        
        // alta medico
        medico = nuevoMedico(lee, baseDatos);
        
        char op = Menu.confirmacion(lee, "Desea dar de alta los enfermos del medico: ");
        if (op == 'S') {
            // crear enfermos nuevos al medico
            do {
                // nuevo enfermo
                enfermo = nuevoEnfermo(lee, baseDatos);
                do {
                    // nuevo seguro
                    seguro = nuevoSeguro(lee, baseDatos);
                    enfermo.getSeguros().add(seguro);

                    op = Menu.confirmacion(lee, "Desea dar de alta mas seguros al enfermo?");

                } while (op == 'S');

                medico.getEnfermos().add(enfermo);

                op = Menu.confirmacion(lee, "Desea dar de alta mas enfermos al medico?");

            } while (op == 'S');
        }
        
        baseDatos.store(medico); // guardando el medico guardamos el resto
        baseDatos.commit();
        System.out.println("Medico guardado"); 
    }
    
    public static void altasEnfermos (BufferedReader lee, ObjectContainer baseDatos) {
        
        Enfermo enfermo; Seguro seguro; char op;

        // nuevo enfermo
        enfermo = nuevoEnfermo(lee, baseDatos);
        do {
            // nuevo seguro
            seguro = nuevoSeguro(lee, baseDatos);
            enfermo.getSeguros().add(seguro);

            op = Menu.confirmacion(lee, "Desea dar de alta mas seguros al enfermo?");

        } while (op == 'S');
        
        baseDatos.store(enfermo); // guardando el enfermo guardamos los seguros
        baseDatos.commit();
        System.out.println("Enfermo guardado");
    }
    
    public static void altasSeguros (BufferedReader lee, ObjectContainer baseDatos) {
        
        Seguro seguro; char op;

        // nuevo seguro
        seguro = nuevoSeguro(lee, baseDatos);
        baseDatos.store(seguro);
        baseDatos.commit();
        System.out.println("Seguro guardado");
    }
    
    public static Medico nuevoMedico (BufferedReader lee, ObjectContainer baseDatos) {
        
        int idMedico = -1; String nombre = "", especialidad = "", direccion = "", telefono = "";
        ObjectSet resultado;
        
        try {
            do {
                System.out.println("Introduzca el id del medico: ");
                idMedico = Integer.parseInt(lee.readLine());

                Medico medico = new Medico (idMedico, null, null, null, null);
                resultado = baseDatos.queryByExample(medico);

                if (!resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese medico ya existe");
                
            } while (!resultado.isEmpty());
            
            System.out.println("Introduzca el nombre del medico: ");
            nombre = lee.readLine();
            
            System.out.println("Introduzca la especialidad del medico: ");
            especialidad = lee.readLine();
            
            System.out.println("Introduzca la direccion del medico: ");
            direccion = lee.readLine();
            
            System.out.println("Introduzca el telefono del medico: ");
            telefono = lee.readLine();
            
        } catch (IOException e) {}
        
        return new Medico (idMedico, nombre, especialidad, direccion, telefono);
    }
    
    public static Enfermo nuevoEnfermo (BufferedReader lee, ObjectContainer baseDatos) {
        
        String dni = "", nombre = "", patologia = "";
        ObjectSet resultado;
        
        try {
            do {
                System.out.println("Introduzca el dni del enfermo: ");
                dni = lee.readLine();
                
                Enfermo enfermo = new Enfermo (dni, null, null);
                resultado = baseDatos.queryByExample(enfermo);
                
                if (!resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese enfermo ya existe");
                
            } while (!resultado.isEmpty());
            
            System.out.println("Introduzca el nombre del enfermo: ");
            nombre = lee.readLine();
            
            System.out.println("Introduzca la patologia del enfermo: ");
            patologia = lee.readLine();
            
        } catch (IOException e) {}
        
        return new Enfermo (dni, nombre, patologia);
    }
    
    public static Seguro nuevoSeguro (BufferedReader lee, ObjectContainer baseDatos) {
        
        int idSeguro = 0, precio = 0; String prestaciones = "";
        ObjectSet resultado;
        
        try {
            do {
                System.out.println("Introduzca el id del seguro: ");
                idSeguro = Integer.parseInt(lee.readLine());
                
                Seguro seguro = new Seguro (idSeguro, 0, null);
                resultado = baseDatos.queryByExample(seguro);
                
                if (!resultado.isEmpty())
                    System.out.println("\033[31m'Error', ese seguro ya existe");
                
            } while(!resultado.isEmpty());
            
            System.out.println("Introduzca el precio del seguro: ");
            precio = Integer.parseInt(lee.readLine());
            
            System.out.println("Introduzca las prestaciones del seguro: ");
            prestaciones = lee.readLine();
            
        } catch (IOException e) {}
        
        return new Seguro (idSeguro, precio, prestaciones);
    }
    
    public static void anadirEnfermoMedico (BufferedReader lee, ObjectContainer baseDatos) {
        
        Medico medico; Enfermo enfermo; Seguro seguro; ObjectSet resultado; 
        int idMedico; char op;
        
        try {
            do { 
                Visualizar.visuMedicos(baseDatos);
                System.out.println("Introduzca el id del medico que desea añadir los enfermos: ");
                idMedico = Integer.parseInt(lee.readLine());
                
                medico = new Medico (idMedico, null, null, null, null);
                resultado = baseDatos.queryByExample(medico);

                if (resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese medico no existe");
                else
                    medico = (Medico) resultado.next();
                
            } while (resultado.isEmpty());
            
            // añadir los enfermos al medico existente
            do {
                // nuevo enfermo
                enfermo = nuevoEnfermo(lee, baseDatos);
                do {
                    // nuevo seguro
                    seguro = nuevoSeguro(lee, baseDatos);
                    enfermo.getSeguros().add(seguro);

                    op = Menu.confirmacion(lee, "Desea dar de alta mas seguros al enfermo?");

                } while (op == 'S');
                
                medico.getEnfermos().add(enfermo);
                baseDatos.store(enfermo);
                baseDatos.store(medico);
                baseDatos.commit();
                
                op = Menu.confirmacion(lee, "Desea añadir otro nuevo enfermo al medico?");
                
            } while (op == 'S');
            
//            baseDatos.store(medico);
            System.out.println("Nuevos enfermos guardados");
            
        } catch (IOException e) {}
    }
    
    public static void anadirSeguroEnfermo (BufferedReader lee, ObjectContainer baseDatos) {
        
        Enfermo enfermo; Seguro seguro; ObjectSet resultado; 
        String dni; char op;
        
        try {
            do { 
                Visualizar.visuEnfermos(baseDatos);
                System.out.println("Introduzca el dni del enfermo que desea anadir el seguro: ");
                dni = lee.readLine();
                
                enfermo = new Enfermo (dni, null, null);
                resultado = baseDatos.queryByExample(enfermo);

                if (resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese enfermo no existe");
                else
                    enfermo = (Enfermo) resultado.next();
                
            } while (resultado.isEmpty());
            
            // añadir los seguros al enfermo ya existente
            do {
                // nuevo seguro
                seguro = nuevoSeguro(lee, baseDatos);
                enfermo.getSeguros().add(seguro);

                op = Menu.confirmacion(lee, "Desea dar de alta mas seguros al enfermo?");

            } while (op == 'S');
            
            baseDatos.store(enfermo);
            System.out.println("Nuevos seguros guardados");
            
        } catch (IOException e) {}
    }
}
