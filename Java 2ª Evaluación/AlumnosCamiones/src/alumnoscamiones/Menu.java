package alumnoscamiones;

import interfaces.I_Nexo;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import objetos.Alumno;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Menu {

    public static void menuAltas(ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Altas.altaNuevoCamion(listado, lee);
                    break;
                case 2:
                    Altas.altaNuevoAlumno(listado, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuBajas(ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuBajas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    String dni = Crear.pedirDniExistente(lee, listado);
                    Alumno alumno = Consultar.encontrarAlumnoPorDni(dni, listado);
                    if (alumno != null) {
                        if (eliminacionAlumnoConfirmada(alumno, lee)) {
                            Bajas.eliminarAlumno(alumno, listado);
                            System.out.printf("El alumno %s ha sido borrado. %n", alumno.getNombre());
                        }                     
                    } else {
                        System.err.printf("No existe un alumno con dni %s%n ", dni);
                    }
                    break;
                case 2:
                    String matricula = Crear.pedirMatricula(lee);
                    Camion camion = Consultar.encontrarCamionPorMatricula(matricula, listado);
                    if(camion!=null){
                        if(eliminacionCamionConfirmada(camion, lee)){
                            Bajas.eliminarCamion(camion, listado);
                            System.out.printf("El camión con matrícula %s ha sido borrado. %n", camion.getMatricula());
                        }
                    }else{
                        System.err.printf("No existe un camión con matrícula %s%n ", matricula);
                    }                   
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void menuModificaciones(ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuModificaciones(lee);
            switch (opcionSeleccionada) {
                case 1:
                    String matricula = Crear.pedirMatricula(lee);
                    Camion camion = Consultar.encontrarCamionPorMatricula(matricula, listado);
                    if(camion!=null){
                        Modificar.modificarPropietarioCamion(camion, lee);
                        System.out.printf("Propietario del camión %s modificado.%n",camion.getMatricula());
                    }else{
                        System.err.printf("No existe un camión con matrícula %s%n ", matricula);
                    }
                    break;
                case 2:
                    String dni = Crear.pedirDniExistente(lee, listado);
                    Alumno alumno = Consultar.encontrarAlumnoPorDni(dni, listado);
                    if(alumno!=null){
                        Modificar.modificarCicloAlumno(alumno, lee);
                        System.out.printf("Ciclo del alumno %s modificado.%n",alumno.getNombre());
                    }else{
                        System.err.printf("No existe un alumno con Dni %s%n ", dni);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void menuVisualizar(ArrayList<I_Nexo> listado, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuVisualizar(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Visualizar.mostrarCamiones(Consultar.encontrarCamionesMatriculaEmpiezaPorE(listado));                  
                    break;
                case 2:
                    Visualizar.mostrarAlumnos(Consultar.obtenerAlumnos(listado));
                    break;
                case 3:
                    Visualizar.mostrarAlumnos(Consultar.encontrarAlumnosSuspensos(2, listado));
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Altas");
        System.out.println("[2] Añadir asignaturas a alumnos existentes");
        System.out.println("[3] Bajas");
        System.out.println("[4] Modificaciones");
        System.out.println("[5] Visualizar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());

    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) throws IOException {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Camiones");
        System.out.println("[2] Alumnos");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuBajas(BufferedReader lee) throws IOException {
        System.out.println("------- BAJAS -------");
        System.out.println("[1] Alumnos");
        System.out.println("[2] Camiones");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }
    
    public static byte seleccionarOpcionMenuModificaciones(BufferedReader lee) throws IOException {
        System.out.println("------- MODIFICACIONES -------");
        System.out.println("[1] Propietario de un camión");
        System.out.println("[2] Ciclo de un alumno");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }
    
    public static byte seleccionarOpcionMenuVisualizar(BufferedReader lee) throws IOException {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("[1] Camiones con matrícula que comienza por 'E'");
        System.out.println("[2] Alumnos con sus asignaturas");
        System.out.println("[3] Alumnos con 2 o más asignaturas suspensas");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static boolean eliminacionAlumnoConfirmada(Alumno alumno, BufferedReader lee) throws IOException {
        Visualizar.mostrarAlumno(alumno);
        System.out.println("Es " + alumno.getNombre() + " el alumno que desea eliminar?");
        System.out.println("[1] Sí.");
        System.out.println("[2] No.");
        System.out.printf("Seleccione una opción: ");
        byte opcionSeleccionada = Byte.parseByte(lee.readLine());
        if (opcionSeleccionada == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean eliminacionCamionConfirmada(Camion camion, BufferedReader lee) throws IOException {
        Visualizar.mostrarCamion(camion);
        System.out.println("Es el camión con matrícula " + camion.getMatricula()+ " el camión que desea eliminar?");
        System.out.println("[1] Sí.");
        System.out.println("[2] No.");
        System.out.printf("Seleccione una opción: ");
        byte opcionSeleccionada = Byte.parseByte(lee.readLine());
        if (opcionSeleccionada == 1) {
            return true;
        } else {
            return false;
        }
    }
}
