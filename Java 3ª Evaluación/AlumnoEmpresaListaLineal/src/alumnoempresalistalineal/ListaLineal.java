
package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @author 
 */
public class ListaLineal {
    
    public static Alumno listaLineal (File fDatos) throws IOException {
        
        ObjectInputStream ois = null;
        
        Object aFichero;
        Alumno p = null;
        
        try {
            ois = new ObjectInputStream(new FileInputStream (fDatos));

            do {
                aFichero = (Object) ois.readObject();
                
                if (aFichero instanceof Alumno) {
                    Alumno anterior = p;
                    Alumno actual = p;
                    if (p == null) {
                        p = (Alumno)aFichero;
                    }
                    else {
                        while (actual != null && ((Alumno)aFichero).getCodigo() > actual.getCodigo()) {
                            anterior = actual;
                            actual = actual.getSiguiente();
                        }
                        if (anterior == actual) {
                            ((Alumno) aFichero).setSiguiente(p);
                            p = (Alumno)aFichero;
                        }
                        else {
                            ((Alumno) aFichero).setSiguiente(actual);
                            anterior.setSiguiente((Alumno)aFichero);
                        } 
                    }
                }
            } while (true);
        }
        catch (EOFException e) {}
        catch (ClassNotFoundException e) {
            System.out.println("\033[31m"+e.getMessage());
        }
        finally {
            if (ois != null) {
                ois.close();
            }
        }
        return p;
    }
    
    public static void visualizarListaLineal (Alumno p) {
        
        Alumno q = p;
        
        if (q != null) {
            System.out.println("\033[34m                   LISTA DE ALUMNOS");
            System.out.println(" ────────────────────────────────");
            System.out.printf(" \033[34m%s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%n", "|","-----CODIGO-----", "-----NOMBRE-----", "-----EMPRESA----");
            while (q != null) {
                System.out.printf(" \033[35m%s%-16d%1$s%1$s%-16s%1$s", "|",q.getCodigo(), q.getNombre());
                if (q.getE() != null)
                    System.out.printf("\033[35m%s%-16s%1$s%n", "|", q.getE().getCif());
                else
                    System.out.printf("\033[35m%s%-16s%1$s%n", "|", "No asignado");
                q = q.getSiguiente();
            }
            System.out.println(" ────────────────────────────────");
        }
        else
            System.out.println("No hay ningun Alumno registrado en la base de datos");
    }
}
