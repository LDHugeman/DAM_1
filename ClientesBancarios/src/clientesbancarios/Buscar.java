package clientesbancarios;

/**
 *
 * @author David
 */
public class Buscar {

    public static Cliente obterClientePorNombre(Cliente[] clientesSinOrdenar, String nombreBusqueda) {
        Cliente[] clientes = Clasificar.obterOrdenadoSalarioDescendenteIntercambio(clientesSinOrdenar);
        int i = 0;
        int puntoMedio = 0;
        int numeroElementos = clientes.length - 1;

        while (i < numeroElementos) {
            puntoMedio = (int) (i + numeroElementos) / 2;
            System.out.println(puntoMedio);
            if (nombreBusqueda.equalsIgnoreCase(clientes[puntoMedio].getNombre())) {
                i = puntoMedio;
                numeroElementos = puntoMedio;
            } else if (nombreBusqueda.compareToIgnoreCase(clientes[puntoMedio].getNombre()) < 0) {
                numeroElementos = puntoMedio - 1;
            } else {
                i = puntoMedio + 1;
            }
        }
        if (nombreBusqueda.equalsIgnoreCase(clientes[i].getNombre())) {
            return clientes[i];
        } else {
            return null;
        }
    }
}
