package clientesbancarios;

/**
 *
 * @author David
 */
public class Buscar {

    public static Cliente obterClientePorNombre(Cliente[] clientesSinOrdenar, String nombreBusqueda) {
        Cliente[] clientes = Clasificar.obterOrdenadoNombreDescendenteIntercambio(clientesSinOrdenar);
        Cliente clienteEncontrado;
        int posicionEncontrada = busquedaDicotómicaNombre(clientes, nombreBusqueda);
        if (posicionEncontrada == 0) {
            if (clientes[posicionEncontrada].getNombre().equalsIgnoreCase(nombreBusqueda)) {
                clienteEncontrado = clientes[posicionEncontrada];
            } else {
                clienteEncontrado = null;
            }
        } else {
            clienteEncontrado = clientes[posicionEncontrada];
        }
        return clienteEncontrado;
    }

    public static int busquedaDicotómicaNombre(Cliente[] clientes, String nombreBusqueda) {
        int low = 0;
        int puntoMedio;
        int high = clientes.length - 1;
        while (low <= high) {
            puntoMedio = (low + high) / 2;
            if (clientes[puntoMedio].getNombre().compareToIgnoreCase(nombreBusqueda) > 0) {
                low = puntoMedio + 1;
            } else if (clientes[puntoMedio].getNombre().compareToIgnoreCase(nombreBusqueda) < 0) {
                high = puntoMedio - 1;
            } else {
                return puntoMedio;
            }
        }
        return 0;
    }
}
