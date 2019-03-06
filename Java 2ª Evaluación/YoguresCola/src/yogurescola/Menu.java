package yogurescola;

import java.io.BufferedReader;
import java.io.IOException;
import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Menu {

    public static void menuModificaciones(Yogourt cabecera, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuModificaciones(lee);
            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("--- Introduzca el código del yogur a modificar ---");
                    String codigo = Crear.pedirCodigoExistente(cabecera, lee);
                    Yogourt yogur = Consultar.encontrarYogurPorCodigo(codigo, cabecera);
                    Modificar.codigoYogur(cabecera, yogur, lee);
                    break;
                case 2:
                    System.out.println("--- Introduzca el código del yogur a modificar ---");
                    String codigo1 = Crear.pedirCodigoExistente(cabecera, lee);
                    Yogourt yogur1 = Consultar.encontrarYogurPorCodigo(codigo1, cabecera);
                    Modificar.marcaYogur(cabecera, yogur1, lee);
                    break;
                case 3:
                    System.out.println("--- Introduzca el código del yogur a modificar ---");
                    String codigo2 = Crear.pedirCodigoExistente(cabecera, lee);
                    Yogourt yogur2 = Consultar.encontrarYogurPorCodigo(codigo2, cabecera);
                    Modificar.tipoYogur(yogur2, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuVisualizar(Yogourt cabecera, BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuVisualizar(lee);
            switch (opcionSeleccionada) {
                case 1:
                    String marca = Crear.pedirMarcaExistente(cabecera, lee);
                    Visualizar.mostrarYoguresPorMarca(marca, cabecera);
                    break;
                case 2:
                    Visualizar.mostrarYogures(cabecera);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuModificaciones(BufferedReader lee) throws IOException {
        System.out.println("------- MODIFICACIONES -------");
        System.out.println("[1] Código");
        System.out.println("[2] Marca");
        System.out.println("[3] Tipo");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuVisualizar(BufferedReader lee) throws IOException {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("[1] Yogur por marca");
        System.out.println("[2] Todos los yogures");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Crear nueva cola");
        System.out.println("[2] Insertar nuevos yogures");
        System.out.println("[3] Borrar un yogur");
        System.out.println("[4] Modificar datos de un yogur");
        System.out.println("[5] Visualizar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Byte.parseByte(lee.readLine());
    }
}
