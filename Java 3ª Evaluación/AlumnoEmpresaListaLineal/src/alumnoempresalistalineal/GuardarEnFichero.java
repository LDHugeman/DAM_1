
package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @author 
 */
public class GuardarEnFichero {
    
    public static void guardar (File fDatos, Object ob) throws IOException {
        
        ObjectOutputStream oos = null;
        
        try {
            oos = new ObjectOutputStreamSincabecera (new FileOutputStream (fDatos, true));
            oos.writeObject(ob);
        } catch (IOException e) {}
        finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
    
    public static void guardarAlumnoModificada (File fDatos, Alumno alumno) throws IOException {
        
        ObjectOutputStream oosAlumno = null;
        ObjectInputStream oisAlumno = null;
        File temporalDatos = new File ("TemporalDatos.dat");
        
        Object aluFichero;
        
        if (fDatos.exists()) {
            try {
                oosAlumno = new ObjectOutputStream (new FileOutputStream (temporalDatos));
                oisAlumno = new ObjectInputStream (new FileInputStream (fDatos));
                
                do {
                    aluFichero = (Object) oisAlumno.readObject();
                    if (aluFichero instanceof Alumno) {
                       if (((Alumno)aluFichero).getCodigo() == alumno.getCodigo()) {
                        oosAlumno.writeObject((Object)alumno);
                        } 
                       else
                        oosAlumno.writeObject(aluFichero);
                    } 
                    else
                        oosAlumno.writeObject(aluFichero);

                } while (true);
                
            }
            catch (EOFException e) {
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (oosAlumno != null)
                    oosAlumno.close();
                if (oisAlumno != null) 
                    oisAlumno.close();

                fDatos.delete();
                temporalDatos.renameTo(fDatos);
            }
        }
        else
            System.out.println("El fichero no existe");
    }
    
    public static void guardarEmpresaModificada (File fDatos, Empresa empresa) throws IOException {
        
        ObjectOutputStream oosEmpresa = null;
        ObjectInputStream oisEmpresa = null;
        File temporalDatos = new File ("TemporalDatos.dat");
        
        Object empresaFichero;
        
        if (fDatos.exists()) {
            try {
                oosEmpresa = new ObjectOutputStream (new FileOutputStream (temporalDatos));
                oisEmpresa = new ObjectInputStream (new FileInputStream (fDatos));
                
                do {
                    empresaFichero = (Object) oisEmpresa.readObject();
                        if (empresaFichero instanceof Empresa) {
                            if (((Empresa)empresaFichero).getCif().compareToIgnoreCase(empresa.getCif()) == 0) {
                            oosEmpresa.writeObject((Object)empresa);
                        }
                        else
                            oosEmpresa.writeObject(empresaFichero);
                    }
                    else
                        oosEmpresa.writeObject(empresaFichero);

                } while (true);
                
            }
            catch (EOFException e) {
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (oosEmpresa != null)
                    oosEmpresa.close();
                if (oisEmpresa != null) 
                    oisEmpresa.close();

                fDatos.delete();
                temporalDatos.renameTo(fDatos);
            }
        }
        else
            System.out.println("El fichero no existe");
    }
}
