
package alumnoempresalistalineal;
import java.io.*;
import clases.*;
/**
 *
 * @autho
 */
public class Modificaciones {
    
    public static void modi (BufferedReader lee, File fDatos) throws IOException {
        
        int op;
        
        do {
            op = Menu.menuAltasBajasModificaciones(lee, "MODI.");
            
            switch (op) {
                case 1: // Modificacion Empresa
                    modiEmpresa(lee, fDatos);
                break;
                case 2: // Modificacion Alumno
                    modiAlumno(lee, fDatos);
                break;
            }
        } while (op != 3);
    }
    
    public static void modiEmpresa (BufferedReader lee, File fDatos) throws IOException {
        
        Empresa empresa;
        Alumno alumno;
        
        String cif, razonSocial, direccion;
        int codigo;
        int op, op2, b = 0;
        char conf;
        
        try {
            System.out.println("Introduce el cif de la Empresa que desea modificar: ");
            cif = lee.readLine();
            
            // Comprobar si el cif existe
            empresa = LeerFichero.comprobarCif(fDatos, cif);
            
            if (empresa == null)
                System.out.println("La Empresa no esta registrada");
            else {
                do {
                    op = Menu.menuModiEmpresa(lee);
                    
                    switch (op) {
                        case 1: // Modificar Razon social
                            System.out.println("Introduzca la razon social de la Empresa: ");
                            razonSocial = lee.readLine();
                            empresa.setRazonSocial(razonSocial);
                            System.out.println("Razon social modificada");
                        break;
                        case 2: // Modificar Direccion
                            System.out.println("Introduzca la Direccion de la Empresa: ");
                            direccion = lee.readLine();
                            empresa.setDireccion(direccion);
                            System.out.println("Direccion modificada");
                        break;
                        case 3: // Modificar Alumnos
                            do {
                                op2 = Menu.menuModiEmpresaAlu(lee);
                                
                                if (op2 != 3) {
                                    System.out.println("Introduzca el codigo del Alumno");
                                    codigo = Integer.parseInt (lee.readLine());

                                    // Comprar si la asignatura existe
                                    alumno = LeerFichero.comprobarCodigo(fDatos, codigo);

                                    if (alumno == null) {
                                        System.out.println("El alumno no esta registrado");
                                    }
                                    else {
                                        switch (op2) {
                                            case 1:
                                                if (empresa.getAlumnos().isEmpty()) {
                                                    empresa.getAlumnos().add(alumno);
                                                    System.out.println("Alumno registrado");
                                                }
                                                else {
                                                    for (int i = 0; i < empresa.getAlumnos().size(); i++) {
                                                        if (empresa.getAlumnos().get(i).getCodigo() == alumno.getCodigo()) {
                                                            System.out.println("La empresa ya tiene registrado este alumno");
                                                            b = 1;
                                                        }
                                                    }
                                                if (b == 0) { // No tiene registrada la asignatura
                                                    empresa.getAlumnos().add(alumno);
                                                    System.out.println("Alumno registrado");
                                                }
                                            }
                                        break;
                                        case 2:
                                            // Borrar la asignatura del fichero, y la asignatura de los alumnos
                                            Bajas.borrarAlumnoEmpresa(fDatos, alumno);
                                        break;
                                        }
                                    }
                                }
                            } while (op2 != 3);
                        break;
                    }
                } while (op != 4);
                GuardarEnFichero.guardarEmpresaModificada(fDatos, empresa);
            }
        } catch (Exception e) {
        }
    }
    
    public static void modiAlumno (BufferedReader lee, File fDatos) throws IOException {
        
        Empresa empresa;
        Alumno alumno;
        
        String cif, nombre;
        int codigo;
        int op, op2;
        
        try {
            System.out.println("Introduce el codigo del Alumno que desea modificar: ");
            codigo = Integer.parseInt (lee.readLine());
            
            // Comprobar si el alumno existe
            alumno = LeerFichero.comprobarCodigo(fDatos, codigo);
            
            if (alumno == null)
                System.out.println("El alumno no esta registrada");
            else {
                do {
                    op = Menu.menuModiAlumno(lee);
                    
                    switch (op) {
                        case 1: // Modificar Nombre
                            System.out.println("Introduzca el nombre del Alumno: ");
                            nombre = lee.readLine();
                            alumno.setNombre(nombre);
                            System.out.println("Nombre modificado");
                        break;
                        case 2: // Modificar Empresa
                            
                            System.out.println("Introduzca el cif de la Empresa");
                            cif = lee.readLine();

                            // Comprar si la empresa existe
                            empresa = LeerFichero.comprobarCif(fDatos, cif);

                            if (empresa == null) {
                                System.out.println("La Empresa no esta registrada");
                            }
                            else {
                                alumno.setE(empresa);
                                System.out.println("Empresa modificada");
                            }

                        break;
                    }
                } while (op != 3);
                GuardarEnFichero.guardarAlumnoModificada(fDatos, alumno);
            }
        } catch (Exception e) {
        }
    }
    
}
