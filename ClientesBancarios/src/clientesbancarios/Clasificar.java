package clientesbancarios;

/**
 *
 * @author David
 */
public class Clasificar {

    public static Cliente[] obterOrdenadoNombreDescendenteBurbuja(Cliente[] clientes) {
        Cliente aux;
        for (int i = 0; i < clientes.length - 1; i++) {
            for (int j = 0; j < clientes.length - 1; j++) {
                if (clientes[j].getNombre().compareToIgnoreCase(clientes[j + 1].getNombre()) < 0) {
                    aux = clientes[j];
                    clientes[j] = clientes[j + 1];
                    clientes[j + 1] = aux;
                }
            }
        }
        return clientes;
    }

    public static Cliente[] obterOrdenadoNombreDescendenteIntercambio(Cliente[] clientes) {
        Cliente aux;
        boolean estaOrdenado = false;
        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < clientes.length - 1; i++) {
                if (clientes[i].getNombre().compareToIgnoreCase(clientes[i + 1].getNombre()) < 0) {
                    aux = clientes[i];
                    clientes[i] = clientes[i + 1];
                    clientes[i + 1] = aux;

                    estaOrdenado = false;
                }
            }
        }
        return clientes;
    }

    public static Cliente[] obterOrdenadoSalarioDescendenteIntercambio(Cliente[] clientes) {
        Cliente aux;
        boolean estaOrdenado = false;
        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < clientes.length - 1; i++) {
                if (clientes[i].getSaldo() < clientes[i + 1].getSaldo()) {
                    aux = clientes[i];
                    clientes[i] = clientes[i + 1];
                    clientes[i + 1] = aux;

                    estaOrdenado = false;
                }
            }
        }
        return clientes;
    }
}
