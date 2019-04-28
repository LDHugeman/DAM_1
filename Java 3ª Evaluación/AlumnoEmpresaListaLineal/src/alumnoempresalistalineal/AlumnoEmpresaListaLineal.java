

package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @author 
 */
public class AlumnoEmpresaListaLineal {

    public static void main(String[] args) {
        
        BufferedReader lee = new BufferedReader (new InputStreamReader (System.in));
        
        File fDatos = new File ("fDatos.dat");
        
        Alumno p;
        
        int menu = 0;
        
        do {
            try {
                menu = Menu.menu(lee);
                
                switch (menu) {
                    case 1:
                        Fichero.crear(fDatos);
                    break;
                    case 2:
                        Altas.altas(lee, fDatos);
                    break;
                    case 3:
                        Bajas.bajas(lee, fDatos);
                    break;
                    case 4:
                        Modificaciones.modi(lee, fDatos);
                    break;
                    case 5:
                        p = ListaLineal.listaLineal(fDatos);
                        ListaLineal.visualizarListaLineal(p);
                    break;
                    case 6:
                        LeerFichero.leer(fDatos);
                    break;
                    case 7:
                        Fichero.borrarFichero(lee, fDatos);
                    break;
                }
            } catch (Exception e) {}
        } while (menu != 8);
        
        System.out.println("---*************** FIN DEL PROGRAMA ***************---");
    }
    
}
