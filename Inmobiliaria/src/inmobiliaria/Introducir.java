package inmobiliaria;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Introducir {

    public static Factura novaFactura(BufferedReader lee) throws IOException {
        String tipoInmueble = seleccionarInmueble(lee);
        if (tipoInmueble != null) {
            System.out.printf("Precio de venta: ");
            double precio = Double.parseDouble(lee.readLine());
            //boolean funcionario = saberSiEFuncionario(lee);
            //return new Factura(tipoInmueble, precio, funcionario);
            return new Factura(tipoInmueble, precio, saberSiEFuncionario(lee)); 
        }
        return null;
    }

    private static void mostrarMenuInmuebles() {
        System.out.println("Seleccione o tipo de inmueble: \n"
                + "1. Fincas\n"
                + "2. Solares\n"
                + "3. Pisos\n"
                + "4. Casas\n"
                + "5. Locales comerciales\n");
    }

    private static String seleccionarInmueble(BufferedReader lee) throws IOException {
        mostrarMenuInmuebles();
        byte opcionSeleccionada = Byte.parseByte(lee.readLine());
        switch (opcionSeleccionada) {
            case 1:
                return "Fincas";
            case 2:
                return "Solares";
            case 3:
                return "Pisos";
            case 4:
                return "Casas";
            case 5:
                return "Locales comerciales";
            default:
                System.err.println("Esa opción non existe.");
                return null;
        }
    }
    
    private static boolean saberSiEFuncionario (BufferedReader lee)throws IOException{
        System.out.println("É funcionario?\n"
                + "1. Sí\n"
                + "2. Non\n");
        byte opcion = Byte.parseByte(lee.readLine());
        return opcion==1;
    }
    
}
