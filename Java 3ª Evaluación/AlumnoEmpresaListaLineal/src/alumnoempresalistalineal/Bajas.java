
package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @author 
 */
public class Bajas {
    
    public static void bajas (BufferedReader lee, File fDatos) throws IOException {
        
        int op;
        
        do {
            op = Menu.menuAltasBajasModificaciones(lee, "BAJAS");
            
            switch (op) {
                case 1: // Bajas Empresas
                    Bajas.bajaEmpresa(lee, fDatos);
                break;
                case 2: // Bajas Alumnos
                    Bajas.bajaAlumnos(lee, fDatos);
                break;
            }
        } while (op != 3);
    }
    
    public static void bajaEmpresa (BufferedReader lee, File fDatos) throws IOException {
        
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File temporalDatos = new File ("TemporalDatos.dat");
        
        Object obj;
        Empresa empresa = null;
        
        char conf;
        String cif; int v = 1, b = 0;
        
        if (fDatos.exists()) {
//            Leer
            try {
                oos = new ObjectOutputStream (new FileOutputStream (temporalDatos));
                ois = new ObjectInputStream (new FileInputStream (fDatos));
                
//                do {
                    System.out.println("Introduzca el cif de la Empresa que desea borrar: ");
                    cif = lee.readLine();
//                    v = Validar.validarDni(cif);
//                } while (v == 1);

                do {
                    obj = (Object) ois.readObject();
                    if (obj instanceof Empresa) {
                        if (((Empresa)obj).getCif().compareToIgnoreCase(cif) == 0) {
                            conf = Menu.confirmacion(lee, "Desea borrar la Empresa?");
                            if (conf == 'N')
                                oos.writeObject(obj);
                            else {
                                System.out.println("Empresa borrada");
                                // Borrar la empresa en los alumnos  
                                empresa = (Empresa)obj;
                                b = 1;
                            }
                        }
                        else
                            oos.writeObject(obj);
                    }
                    else
                        oos.writeObject(obj);

                } while (true);
                
            }
            catch (EOFException e) {
            }
            catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }

                fDatos.delete();
                temporalDatos.renameTo(fDatos);
            }
        }
        else
            System.out.println("El fichero no existe");
        
        if (b == 1) { // Borrar en los alumnos la empresa
            Bajas.bajaEmpresaAlumno(lee, fDatos, empresa);
            System.out.println("Ir alumno a borrar la empresa");
        }
    }
    
    public static void bajaEmpresaAlumno (BufferedReader lee, File fDatos, Empresa empresa) throws IOException {
        
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File temporal = new File ("TemporalDatos.dat");
        
        Object obj;
        
        if (fDatos.exists()) {
            try {
                oos = new ObjectOutputStream (new FileOutputStream (temporal));
                ois = new ObjectInputStream (new FileInputStream (fDatos));

                do {
                    obj = (Object) ois.readObject();
                    
                    if (obj instanceof Alumno) {
                        if (((Alumno)obj).getE().getCif().compareToIgnoreCase(empresa.getCif()) == 0) {
                            ((Alumno)obj).setE(null);
                            oos.writeObject(obj);
                            System.out.println("Empresa a null");
                        }
                        else
                            oos.writeObject(obj);
                    }
                    else
                        oos.writeObject(obj);

                } while (true);
                
            }
            catch (EOFException e) {
            }
            catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }

                fDatos.delete();
                temporal.renameTo(fDatos);
            }
        }
        else
            System.out.println("El fichero no existe");
    }
    
    public static void bajaAlumnos (BufferedReader lee, File fDatos) throws IOException {
        
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File temporal = new File ("TemporalDatos.dat");
        
        Object obj;
        Alumno alumno = null;
        
        char conf;
        int v = 1, b = 0, codigo;
        
        if (fDatos.exists()) {
//            Leer;
            try {
                oos = new ObjectOutputStream (new FileOutputStream (temporal));
                ois = new ObjectInputStream (new FileInputStream (fDatos));
                
//                do {
                    System.out.println("Introduzca el codigo del Alumno que desea borrar: ");
                    codigo = Integer.parseInt (lee.readLine());
//                    v = Validar.validarDni(dni);
//                } while (v == 1);

                do {
                    obj = (Object) ois.readObject();
                    
                    if (obj instanceof Alumno) {
                        if (((Alumno)obj).getCodigo() == codigo) {
                            conf = Menu.confirmacion(lee, "Desea borrar al Alumno?");
                            if (conf == 'N')
                                oos.writeObject(obj);
                            else {
                                System.out.println("Alumno borrado");
                                // Borrar en las Empresas el alumno
                                alumno = (Alumno)obj;
                                b = 1;
                            }
                        }
                        else
                            oos.writeObject(obj);
                    }
                    else
                        oos.writeObject(obj); 
                    
                } while (true);
                
            }
            catch (EOFException e) {
            }
            catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }

                fDatos.delete();
                temporal.renameTo(fDatos);
            }
        }
        else
            System.out.println("El fichero no existe");
        
        if (b == 1) { // Borrar el alumno de las empresas
            Bajas.borrarAlumnoEmpresa(fDatos, alumno);
            System.out.println("Ir al metodo borrar alumno");
        }
    }
    
    public static void borrarAlumnoEmpresa (File fDatos, Alumno alumno) throws IOException {
        
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        File temporal = new File ("TemporalDatos.dat");
        
        Object obj;
        
        if (fDatos.exists()) {
            try {
                oos = new ObjectOutputStream (new FileOutputStream (temporal));
                ois = new ObjectInputStream (new FileInputStream (fDatos));
                
                do {
                    obj = (Object) ois.readObject();
                    
                    if (obj instanceof Empresa) {
                        if (!((Empresa)obj).getAlumnos().isEmpty()) {
                            for (int i = 0; i < ((Empresa)obj).getAlumnos().size(); i++) {
                               if (((Empresa)obj).getAlumnos().get(i).getCodigo() == alumno.getCodigo()) {
                                   ((Empresa)obj).getAlumnos().remove(i); 
                                   System.out.println("Alumno borrado");
                                }     
                            }
                            oos.writeObject(obj);
                        }
                        else
                            oos.writeObject(obj);
                    }
                    else
                        oos.writeObject(obj);

                } while (true);
                
            }
            catch (EOFException e) {
            }
            catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            finally {
                if (oos != null)
                    oos.close();
                if (ois != null) 
                    ois.close();

                fDatos.delete();
                temporal.renameTo(fDatos);
            }
        }
        else
            System.out.println("El fichero no existe");
    }
}
