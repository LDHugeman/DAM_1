
package funciones;

import bdmedenfsegbd4o.Menu;
import clases.Enfermo;
import clases.Medico;
import clases.Seguro;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author
 */
public class Consultas {
    
    public static void consultas (BufferedReader lee, ObjectContainer baseDatos) {
        
        int menu;
        
        do  {
            menu = Menu.menuConsulta(lee, "CONSULTAS");
            
            switch (menu) {
                case 1: // Los médicos cuya especialidad sea “Dermatología”
                    medicosDermatologia(lee, baseDatos);
                break;
                case 2: // Los enfermos con su seguro del medico
                    enfermosSegurosMedico(lee, baseDatos);
                break;
            }
        } while (menu != 3);
    }
    
    public static void medicosDermatologia (BufferedReader lee, ObjectContainer baseDatos) {
        
        Medico medico;
        
        Query consulta = baseDatos.query();
        consulta.constrain(Medico.class);
        consulta.descend("especialidad").constrain("dermatologia").like();
        consulta.descend("nombre").orderAscending();
        ObjectSet resultado = consulta.execute();
        
        Visualizar.titulo("LISTA DE MEDICOS", 50, 53);
        Visualizar.cabecera(new String [] {"--idMedico--", "---NOMBRE---", "ESPECIALIDAD", 
            "--DIRECCION-", "--TELEFONO--", "--ENFERMOS--"}, 12);
        
        while (resultado.hasNext()) {
            medico = (Medico) resultado.next();
            System.out.println(medico);
        }
        Visualizar.separacion(53);
    }
    
    public static void enfermosSegurosMedico (BufferedReader lee, ObjectContainer baseDatos) {
       
        Medico medico = null; int idMedico; ObjectSet resultado;
        
        try {
            do {
                Visualizar.visuMedicos(baseDatos);
                System.out.println("Introduzca el id del medico que desea buscar: ");
                idMedico = Integer.parseInt(lee.readLine());
                
                Query consulta = baseDatos.query();
                consulta.constrain(Medico.class);
                consulta.descend("idMedico").constrain(idMedico);
                resultado = consulta.execute();

                if (resultado.isEmpty()) 
                    System.out.println("\033[31m'Error', ese medico no existe");
                else
                    medico = (Medico) resultado.next();

            } while (resultado.isEmpty());
            
            Visualizar.titulo("LISTA DE ENFERMOS Y SEGUROS DE UN MEDICO", 64, 54);
            Visualizar.cabecera(new String [] {"--IDMEDICO--", "---NOMBRE---", "ESPECIALIDAD", 
                "--DIRECCION-", "--TELEFONO--", "--ENFERMOS--"}, 12);

            System.out.println(medico);

            for (Enfermo enfermo : medico.getEnfermos()) {
                Visualizar.separadorEnTabla("ENFERMO", 73, 36);
                Visualizar.cabecera(new String [] {"----DNI-----", "---NOMBRE---", "--PATOLOGIA-", 
                        "---SEGUROS--", "------------", "------------"}, 12);
            
                Visualizar.contenido(new String [] {enfermo.getDni(), enfermo.getNombre(),
                        enfermo.getPatologia(), String.valueOf(enfermo.getSeguros().size()),
                        "   ------   ", "   ------   "}, 12);
                
                Visualizar.separadorEnTabla("SEGUROS", 73, 36);
                Visualizar.cabecera(new String [] {"--IDSEGURO--", "---PRECIO---", "PRESTACIONES",
                    "------------", "------------", "------------"}, 12);
                
                for (Seguro seguro : enfermo.getSeguros()) {
                    Visualizar.contenido(new String [] {String.valueOf(seguro.getIdSeguro()), 
                        String.valueOf(seguro.getPrecio()), seguro.getPrestaciones(),
                        "   ------   ", "   ------   ", "   ------   "}, 12);
                }
            }
            Visualizar.separacion(54);
            
        } catch (IOException e) {}
        
    }
}
