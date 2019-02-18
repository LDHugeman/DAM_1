package cochesnuevosusados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import objetos.Coche;
import objetos.Empresa;

/**
 *
 * @author a18luisdvp
 */
public class CochesNuevosUsados {

    public static void main(String[] args) throws IOException, ParseException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;
        Empresa empresa = Crear.nuevaEmpresa(lee);
        ArrayList <Coche> coches = empresa.getCoches();
        do{
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch(opcionSeleccionada){
                case 1:
                    Menu.menuAltas(lee, coches);
                    break;
                case 2:
                    Menu.menuBajas(lee, coches);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        }while(opcionSeleccionada!=0);
    }

}
