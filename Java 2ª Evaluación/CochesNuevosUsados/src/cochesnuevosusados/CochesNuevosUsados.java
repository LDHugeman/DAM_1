package cochesnuevosusados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import objetos.Coche;
import objetos.CocheAlquiler;
import objetos.Empresa;

/**
 *
 * @author a18luisdvp
 */
public class CochesNuevosUsados {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;
        Empresa empresa = Crear.nuevaEmpresa(lee);
        ArrayList<Coche> coches = empresa.getCoches();
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Menu.menuAltas(lee, coches);
                    break;
                case 2:
                    Menu.menuBajas(lee, coches);
                    break;
                case 3:
                    System.out.printf("--- Introduzca el código del coche en alquiler al que desea modificar el precio por día ---%n");
                    String codigo = Crear.pedirCodigoExistente(lee, coches);
                    CocheAlquiler coche = Consultar.encontrarCocheAlquilerPorCodigo(codigo, coches);
                    if (coche != null) {
                        Modificar.modificarPrecioDiaAlquiler(coche, lee);
                        System.out.printf("Precio por día del coche con código %s modificado.%n", ((Coche) coche).getCodigo());
                    } else {
                        System.err.println("No existe ningún coche con ese código o no corresponde a un coche en alquiler.%n");
                    }
                    break;
                case 4:
                    Menu.menuVisualizar(lee, coches);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }
}
