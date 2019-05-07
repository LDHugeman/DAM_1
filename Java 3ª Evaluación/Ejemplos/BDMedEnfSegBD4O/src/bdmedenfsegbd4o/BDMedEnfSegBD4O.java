
package bdmedenfsegbd4o;

import clases.Enfermo;
import clases.Medico;
import clases.Seguro;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.internal.config.EmbeddedConfigurationImpl;
import funciones.Altas;
import funciones.Bajas;
import funciones.Consultas;
import funciones.Visualizar;
import java.io.*;

/**
 *
 * @autho
 */
public class BDMedEnfSegBD4O {

    public static void main(String[] args) {
        
        BufferedReader lee = new BufferedReader (new InputStreamReader (System.in));

        String bd = "bd/BDMedEnfSeg";
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Medico.class).cascadeOnUpdate(true);
        config.common().objectClass(Enfermo.class).cascadeOnUpdate(true);
        config.common().objectClass(Seguro.class).cascadeOnUpdate(true);
        ObjectContainer baseDatos = Db4oEmbedded.openFile(config, bd);
        
        int menu;
        
        do {
            menu = Menu.menu(lee);
            
            switch (menu) {
                case 1: // Altas
                    Altas.altas(lee, baseDatos);
                break;
                case 2: // Añadir enfermo nuevo a un medico ya existente
                    Altas.anadirEnfermoMedico(lee, baseDatos);
                break;
                case 3: // Añadir seguro nuevo a un enfermo ya esxistente
                    Altas.anadirSeguroEnfermo(lee, baseDatos);
                break;
                case 4: // Bajas
                    Bajas.bajas(lee, baseDatos);
                break;
                case 5: // Consultas
                    Consultas.consultas(lee, baseDatos);
                break;
                case 6: // Visualizar
                    Visualizar.visualizar(lee, baseDatos);
                break;
                case 7: // Borrar la BD
                    borrarBD(lee, baseDatos, bd);
                break;
            }
            
        } while (menu != 8);

        baseDatos.close();
        
        System.out.println("---*************** FIN DEL PROGRAMA ***************---");
    }
    
    public static void borrarBD (BufferedReader lee, ObjectContainer baseDatos, String bd) {
        char op = Menu.confirmacion(lee, "Esta seguro de que desea borrar la BD? ");
        if (op == 'S') {
            baseDatos.close();
            File fichero = new File(bd);
            fichero.delete();
            System.out.println("BD borrada");
            System.exit(0);
        }
    }
}

/*

    BASE DE DATOS

    ┌────────┐0,n       0,n┌────────┐
    │   Medico    ├────────┤   Enfermo   │       Relaciones unidireccionales: 
    └────────┘             └────────┘           Array <Enfermo> en Medico
                                        │ 0,n               Array <Seguros> en Enfermos
                                        │  
                                        │ 1,n
                                 ┌────────┐           
                                 │   Seguro    │    
                                 └────────┘ 

    1 Medico    ---->   0 a muchos enfermos
    1 Enfermo   ---->   1 seguro minimo, puede tener varios
    1 Seguro    ---->   0 a muchos enfermos

*/      
