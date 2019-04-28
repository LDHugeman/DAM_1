
package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @author 
 */
public class LeerFichero {
    
    public static Alumno comprobarCodigo (File fDatos, int codigo) throws IOException {
        
        ObjectInputStream ois = null;
        
        Object aFichero;
        
        try {
            ois = new ObjectInputStream(new FileInputStream (fDatos));

            do {
                aFichero = (Object) ois.readObject();
                if (aFichero instanceof Alumno) {
                    if (((Alumno)aFichero).getCodigo() == codigo)
                        return (Alumno)aFichero;
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
        
        return null;
    }
    
    public static Empresa comprobarCif (File fDatos, String cif) throws IOException {
        
        ObjectInputStream ois = null;
        
        Object eFichero;
        
        try {
            ois = new ObjectInputStream(new FileInputStream (fDatos));

            do {
                eFichero = (Object) ois.readObject();
                if (eFichero instanceof Empresa) {
                    if (((Empresa)eFichero).getCif().compareToIgnoreCase(cif) == 0)
                        return (Empresa)eFichero;
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
        
        return null;
    }
    
    public static void leer (File fDatos) throws IOException {
        
        ObjectInputStream ois = null;
        
        Object obj;
        
        try {
            ois = new ObjectInputStream(new FileInputStream (fDatos));
            
            if (fDatos.exists()) {
                System.out.println("\033[34m                                LISTA DE PROFESORES Y ALUMNOS");
                System.out.println(" ─────────────────────────────────────────────────────");
                do {
                    obj = (Object) ois.readObject();
                    if (obj instanceof Alumno) {
                        System.out.printf(" \033[34m%s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%n", "|", "----------------", "-----CODIGO-----", "-----NOMBRE-----", "-----EMPRESA----", "----------------");
                        System.out.printf(" \033[35m%s%-16s%1$s%1$s%-16d%1$s%1$s%-16s%1$s", "|", "Alumno", ((Alumno)obj).getCodigo(), ((Alumno)obj).getNombre());
                        if (((Alumno)obj).getE() != null)
                            System.out.printf("\033[35m%s%-16s%1$s%1$s%-16s%1$s%n", "|", ((Alumno)obj).getE().getCif(), "      ---       ");
                        else
                            System.out.printf("\033[35m%s%-16s%1$s%1$s%-16s%1$s%n", "|", "No asignado", "      ---       ");
                    }
                        
                    else {
                        System.out.printf(" \033[34m%s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%n", "|", "----------------", "-------CIF------", "--RAZON SOCIAL--", "----DIRECCION---", "-----ALUMNOS----");
                        System.out.printf(" \033[35m%s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%1$s%-16s%1$s%1$s%-16d%1$s%n", "|", "Empresa", ((Empresa)obj).getCif(), ((Empresa)obj).getRazonSocial(), ((Empresa)obj).getDireccion(), ((Empresa)obj).getAlumnos().size());
                    }
                } while (true);
            }
            else
                System.out.println("'Error', el fichero no existe");
        }
        catch (EOFException e) {
            System.out.println(" ─────────────────────────────────────────────────────");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
