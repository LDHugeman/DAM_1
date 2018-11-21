package clientesbancarios2;

/**
 *
 * @author David
 */
public class Clasificar {

    public static void obterOrdenadoNombreDescendenteBurbuja(String[] nombreClientes, float[] saldos) {
        float aux;
        String aux2;
        for (int i = 0; i < nombreClientes.length - 1; i++) {
            for (int j = 0; j < nombreClientes.length - 1; j++) {
                if (nombreClientes[j].compareToIgnoreCase(nombreClientes[j + 1]) < 0) {
                    aux2 = nombreClientes[j];
                    nombreClientes[j] = nombreClientes[j + 1];
                    nombreClientes[j + 1] = aux2;
                    aux = saldos[j];
                    saldos[j] = saldos[j + 1];
                    saldos[j + 1] = aux;
                }
            }
        }
    }

    public static void obterOrdenadoNombreAscendenteIntercambio(String[] nombreClientes, float[] saldos) {
        float aux;
        String aux2;
        boolean estaOrdenado = false;
        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < nombreClientes.length - 1; i++) {
                if (nombreClientes[i].compareToIgnoreCase(nombreClientes[i + 1]) > 0) {
                    aux2 = nombreClientes[i];
                    nombreClientes[i] = nombreClientes[i + 1];
                    nombreClientes[i + 1] = aux2;
                    aux = saldos[i];
                    saldos[i] = saldos[i + 1];
                    saldos[i + 1] = aux;

                    estaOrdenado = false;
                }
            }
        }
    }

}
