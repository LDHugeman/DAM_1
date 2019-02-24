package alumnospila;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import objetos.Alumno;

/**
 *
 * @author a18luisdvp
 */
public class AlumnosPila {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;
        Alumno cabecera = null;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenu(lee);
            switch (opcionSeleccionada) {
                case 1:
                    cabecera = Crear.crearNuevaPilaAlumnos(cabecera, lee);
                    break;
                case 2:
                    do {
                        Alumno nuevoAlumno = Crear.crearNuevoAlumno(cabecera, lee);
                        cabecera = Altas.altaNuevoAlumno(nuevoAlumno, cabecera, lee);
                        System.out.println("¿Desea añadir un nuevo alumno?");
                        System.out.println("[1] Si");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                    } while (Pedir.numeroByte(lee) == 1);
                    break;
                case 3:
                    if (cabecera != null) {
                        String codigo = Crear.pedirCodigoExistente(lee, cabecera);
                        Alumno alumnoEncontrado = Consultar.obtenerAlumnoPorCodigo(codigo, cabecera);
                        cabecera = Bajas.eliminarAlumno(alumnoEncontrado, cabecera);
                        System.out.printf("Alumno eliminado %n");
                    } else {
                        System.err.printf("No hay alumnos en la pila %n");
                    }
                    break;
                case 4:
                    if (cabecera != null) {
                        String codigo = Crear.pedirCodigoExistente(lee, cabecera);
                        Alumno alumnoEncontrado = Consultar.obtenerAlumnoPorCodigo(codigo, cabecera);
                        Modificar.notaAlumno(alumnoEncontrado, lee);
                    } else {
                        System.err.printf("No hay alumnos en la pila %n");
                    }
                    break;
                case 5:
                    if (cabecera != null) {
                        Visualizar.mostrarAlumnosSuperioresNota(6, cabecera);
                    } else {
                        System.err.printf("No hay alumnos en la pila %n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("No existe esa opcion %n");
            }
        } while (opcionSeleccionada != 0);
    }

}
