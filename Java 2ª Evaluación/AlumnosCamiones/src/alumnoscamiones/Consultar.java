package alumnoscamiones;

import interfaces.I_Nexo;
import java.util.ArrayList;
import objetos.Alumno;
import objetos.Asignatura;
import objetos.Camion;

/**
 *
 * @author David
 */
public class Consultar {

    public static Alumno encontrarAlumnoPorDni(String dni, ArrayList<I_Nexo> listado) {
        Alumno alumnoEncontrado = null;
        for (I_Nexo objeto : listado) {
            if (objeto instanceof Alumno) {
                if (((Alumno) objeto).getDni().equals(dni)) {
                    alumnoEncontrado = (Alumno) objeto;
                }
            }
        }
        return alumnoEncontrado;
    }

    public static boolean existeAlumnoPorDni(String dni, ArrayList<I_Nexo> listado) {
        return encontrarAlumnoPorDni(dni, listado) != null;
    }

    public static Camion encontrarCamionPorMatricula(String matricula, ArrayList<I_Nexo> listado) {
        Camion camionEncontrado = null;
        for (I_Nexo objeto : listado) {
            if (objeto instanceof Camion) {
                if (((Camion) objeto).getMatricula().equals(matricula)) {
                    camionEncontrado = (Camion) objeto;
                }
            }
        }
        return camionEncontrado;
    }

    public static boolean existeCamionPorDni(String dni, ArrayList<I_Nexo> listado) {
        return encontrarCamionPorMatricula(dni, listado) != null;
    }

    public static ArrayList<Camion> encontrarCamionesMatriculaEmpiezaPorE(ArrayList<I_Nexo> listado) {
        ArrayList<Camion> camiones = obtenerCamiones(listado);
        ArrayList<Camion> camionesMatriculaE = new ArrayList<>();
        for (Camion camion : camiones) {
            if (camion.getMatricula().startsWith("E") || camion.getMatricula().startsWith("e")) {
                camionesMatriculaE.add(camion);
            }
        }
        if(camionesMatriculaE.isEmpty()){
            System.out.printf("No hay ningún camión con una matrícula que empiece por 'E'.%n");
        }
        return camionesMatriculaE;
    }

    public static ArrayList<Alumno> encontrarAlumnosSuspensos(int numeroSuspensos, ArrayList<I_Nexo> listado) {
        ArrayList<Alumno> alumnos = obtenerAlumnos(listado);
        ArrayList<Alumno> alumnosSuspensos = new ArrayList<>();       
        for (Alumno alumno : alumnos) {
            int numeroAsignaturasSuspensas = 0;
            for (Asignatura asignatura : alumno.getAsignaturas()) {
                if (asignatura.getNotaMediaAsignatura()<5) {
                    numeroAsignaturasSuspensas++;                   
                }
            }
            if(numeroAsignaturasSuspensas>=numeroSuspensos){
                alumnosSuspensos.add(alumno);
            }
        }
        if(alumnosSuspensos.isEmpty()){
            System.err.printf("No hay ningún alumno con 2 o más asignaturas suspensas");
        }
        return alumnosSuspensos;
    }

    public static ArrayList<Alumno> obtenerAlumnos(ArrayList<I_Nexo> listado) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for (I_Nexo objeto : listado) {
            if (objeto instanceof Alumno) {
                alumnos.add((Alumno) objeto);
            }
        }
        return alumnos;
    }

    public static ArrayList<Camion> obtenerCamiones(ArrayList<I_Nexo> listado) {
        ArrayList<Camion> camiones = new ArrayList<>();
        for (I_Nexo objeto : listado) {
            if (objeto instanceof Camion) {
                camiones.add((Camion) objeto);
            }
        }
        return camiones;
    }
}
