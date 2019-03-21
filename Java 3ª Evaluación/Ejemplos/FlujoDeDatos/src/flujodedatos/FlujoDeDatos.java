

package flujodedatos;
import java.io.*;
/**
 *
 * @author Usuario
 */
public class FlujoDeDatos {

   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int op;
        File fichero=null;
        fichero=new File("datos.dat");
         File ficheroTemp=null;
        ficheroTemp=new File("temporal");
        
        do
        {
            System.out.println ("1-Grabar campos");
            System.out.println ("2-Leer campos");
            System.out.println ("3-Borrado fisico");
            System.out.println ("4-Buscar");
            System.out.println ("5-Salir");
            System.out.println  (         "Elegir opción:");
            
            op=Integer.parseInt(lee.readLine());
            
            switch(op)
            {
                case 1: EscribirDatos.escribirDatos(fichero);
                    break;
                case 2: LeerDatos.leerDatos(fichero);
                    break;
                case 3: BorradoFisico.Borrar(fichero,ficheroTemp);
                    break;
                case 4: Buscar.Buscar(fichero);
                    break;   
                
            }  
        }while (op ==1 |op ==2 | op==3 | op==4);                                                                                                                              
    }
}
