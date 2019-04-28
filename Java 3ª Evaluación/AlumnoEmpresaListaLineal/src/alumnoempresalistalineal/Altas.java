
package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @author 
 */
public class Altas {
    
    public static void altas (BufferedReader lee, File fDatos) throws IOException {
        
        int op, opFichero;

        if (!fDatos.exists())
            System.out.println("El fichero no existe");
        else {
            opFichero = Menu.fichero(lee, "SOBRESCRIBIR O AÑADIR NUEVOS REGISTROS");

            if (opFichero == 1) { // Sobrescribir fichero
                Fichero.sobrescribirFichero(fDatos);
            }

            do {
                op = Menu.menuAltasBajasModificaciones(lee, "ALTAS");

                switch (op) {
                    case 1: // Altas Empresas
                        altasEmpresa(lee, fDatos);
                    break;
                    case 2: // Altas Alumnos
                        altasAlumnos(lee, fDatos);
                    break;
                }
            } while (op != 3);
        }
    }
    
    public static void altasAlumnos (BufferedReader lee, File fDatos) {
        
        Alumno alumno;
        Empresa empresa;
        
        String cif;
        int codigo;
        char conf;
        
        try {
            System.out.println("Introduzca el codigo del Alumno: ");
            codigo = Integer.parseInt (lee.readLine());
            
            // Comprobar si el dni existe
            alumno = LeerFichero.comprobarCodigo(fDatos, codigo);
            
            if (alumno == null) { // el Alumno no existe
                alumno = altaObjetoAlumno(lee, codigo);
                
                conf = Menu.confirmacion(lee, "Desea registrar la empresa?");
                
                if (conf == 'S') {

                    System.out.println("Introduzca el el cif de la Empresa: ");
                    cif = lee.readLine();

                    // Comprobar si la asignatura existe
                    empresa = LeerFichero.comprobarCif(fDatos, cif);

                    if (empresa == null) {
                        System.out.println("La empresa no esta registrada");
                    } 
                    else {
                        System.out.println("La empresa ya está registrada en la base de datos");

                        alumno.setE(empresa);
                    }
                }
                GuardarEnFichero.guardar(fDatos, alumno);
            } 
            else {
                System.out.println("El alumno ya esta registrado");    
            }
        } 
        catch (IOException e) {}
    }
    
    public static void altasEmpresa (BufferedReader lee, File fDatos) {
        
        Empresa empresa;
        Alumno alumno;
        
        String cif;
        int codigo, b = 0;
        char conf;
        
        try {
            System.out.println("Introduzca el cif de la Empresa: ");
            cif = lee.readLine();
            
            // Comprobar si el cif existe
            empresa = LeerFichero.comprobarCif(fDatos, cif);
            
            if (empresa == null) { // la Empresa no existe
                empresa = altaObjetoEmpresa(lee, cif);
                
                conf = Menu.confirmacion(lee, "Desea registrar los alumnos que van asistir a la empresa?");
                
                if (conf == 'S') {
                    do {
                        System.out.println("Introduzca el codigo del Alumno: ");
                        codigo = Integer.parseInt (lee.readLine());

                        // Comprobar si la asignatura existe
                        alumno = LeerFichero.comprobarCodigo(fDatos, codigo);

                        if (alumno == null) {
                            System.out.println("El alumno no esta registrado");
                        } 
                        else {
                            System.out.println("El alumno esta registrado");

                            if (!empresa.getAlumnos().isEmpty()) {
                                for (int i = 0; i < empresa.getAlumnos().size(); i++) {
                                    if (empresa.getAlumnos().get(i).getCodigo() == codigo) {
                                        System.out.println("El alumno ya tiene registrada esta asignatura");
                                        b = 1;
                                        break;
                                    }
                                }
                                if (b == 0) { // La empresa no tiene registrado este alumno
                                    empresa.getAlumnos().add(alumno);
                                    GuardarEnFichero.guardarEmpresaModificada(fDatos, empresa);
                                }
                            }
                            else { // La empresa no tiene guardada ninguna asignatura
                                empresa.getAlumnos().add(alumno);
                                GuardarEnFichero.guardarEmpresaModificada(fDatos, empresa);
                            }
                        }
                        
                        conf = Menu.confirmacion(lee, "Desea registrar más alumnos?");

                    } while (conf == 'S');
                }
                GuardarEnFichero.guardar(fDatos, empresa);
            } 
            else 
                System.out.println("La empresa ya esta registrada");    
        }  
        catch (IOException e) {}
    }
    
    public static Alumno altaObjetoAlumno (BufferedReader lee, int codigo) throws IOException {
        
        Alumno alumno;
        
        String nombre;
        
        System.out.println("Introduzca el nombre del Alumno: ");
        nombre = lee.readLine();
        
        alumno = new Alumno (codigo, nombre, null, null);
        
        return alumno;
    }
    
    public static Empresa altaObjetoEmpresa (BufferedReader lee, String cif) throws IOException {
        
        Empresa empresa;
        
        String razonSocial, direccion;
        
        System.out.println("Introduzca la razón social de la Empresa: ");
        razonSocial = lee.readLine();
        
        System.out.println("Introduzca la direccion de la Empresa");
        direccion = lee.readLine();
        
        empresa = new Empresa (cif, razonSocial, direccion);
        
        return empresa;
    }
}
