package yogurescola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import objetos.Yogourt;

/**
 *
 * @author David
 */
public class YoguresCola {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Yogourt cabecera = null;
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    cabecera = Crear.crearNuevaColaYogures(cabecera, lee);
                    break;
                case 2:
                    byte opcion = 0;
                    do {
                        Yogourt nuevoYogur = Crear.crearNuevoYogur(cabecera, lee);
                        cabecera = Altas.altaNuevoYogur(cabecera, nuevoYogur);
                        System.out.println("¿Desea introducir un nuevo yogur?");
                        System.out.println("[1] Si");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcion = Pedir.numeroByte(lee);
                    } while (opcion == 1);
                    break;
                case 3:
                    if (cabecera != null) {
                        String codigo = Crear.pedirCodigoExistente(cabecera, lee);
                        Yogourt yogur = Consultar.encontrarYogurPorCodigo(codigo, cabecera);
                        cabecera = Bajas.eliminarYogur(cabecera, yogur);
                        System.out.printf("Yogur eliminado %n");
                    } else {
                        System.err.printf("No hay yogures en la cola %n");
                    }
                    break;
                case 4:
                    if (cabecera != null) {
                        Menu.menuModificaciones(cabecera, lee);
                    } else {
                        System.err.printf("No hay yogures en la cola %n");
                    }
                    break;
                case 5:
                    if (cabecera != null) {
                        Menu.menuVisualizar(cabecera, lee);
                    } else {
                        System.err.printf("No hay yogures en la cola %n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

}
