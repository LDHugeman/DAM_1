package alumnoscamiones;

import interfaces.I_Nexo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import objetos.Alumno;

/**
 *
 * @author David
 */
public class AlumnosCamiones {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<I_Nexo> listado = new ArrayList<>();
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Menu.menuAltas(listado, lee);
                    break;
                case 2:
                    String dni = Crear.pedirDniExistente(lee, listado);
                    Alumno alumno = Consultar.encontrarAlumnoPorDni(dni, listado);
                    if (alumno != null) {
                        Altas.añadirAsignaturasAlumno(alumno, listado, lee);
                    } else {
                        System.err.printf("No se ha encontrado al alumno con Dni %s %n", dni);
                    }
                    break;
                case 3:
                    Menu.menuBajas(listado, lee);
                    break;
                case 4:
                    Menu.menuModificaciones(listado, lee);
                    break;
                case 5:
                    Menu.menuVisualizar(listado, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe. %n");
            }
        } while (opcionSeleccionada != 0);
    }

}
