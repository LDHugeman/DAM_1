package clientesbancarios2;

/**
 *
 * @author David
 */
public class Buscar {

    public static void imprimirClienteEncontrado(String[] nombreClientes, float[] saldos, String nombreBusqueda) {
        Clasificar.obterOrdenadoNombreDescendenteBurbuja(nombreClientes, saldos);
        int posicionEncontrada = busquedaDicotomicaNombre(nombreClientes, nombreBusqueda);
        if (posicionEncontrada == 0) {
            if (nombreClientes[posicionEncontrada].equalsIgnoreCase(nombreBusqueda)) {
                System.out.printf("Nombre: %s Saldo: %.2f %n",nombreClientes[posicionEncontrada], saldos[posicionEncontrada]);
            } else {
                System.err.printf("No se ha encontrado al cliente %s %n", nombreBusqueda);
            }
        } else {
            System.out.printf("Nombre: %s Saldo: %.2f %n",nombreClientes[posicionEncontrada], saldos[posicionEncontrada]);
        }
    }

    public static int busquedaDicotomicaNombre(String[] nombreClientes, String nombreBusqueda) {
        int low = 0;
        int puntoMedio;
        int high = nombreClientes.length - 1;
        while (low <= high) {
            puntoMedio = (low + high) / 2;
            if (nombreClientes[puntoMedio].compareToIgnoreCase(nombreBusqueda) > 0) {
                low = puntoMedio + 1;
            } else if (nombreClientes[puntoMedio].compareToIgnoreCase(nombreBusqueda) < 0) {
                high = puntoMedio - 1;
            } else {
                return puntoMedio;
            }
        }
        return 0;
    }
}
