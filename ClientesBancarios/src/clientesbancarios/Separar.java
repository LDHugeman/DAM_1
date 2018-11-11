package clientesbancarios;

/**
 *
 * @author David
 */
public class Separar {

    public static Cliente[] obterClientesSaldoPositivo(Cliente[] clientes) {
        int clientesPositivos = obterNumeroClientesPositivos(clientes);
        Cliente[] clientesSaldoPositivo = new Cliente[clientesPositivos];
        int gardados = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getSaldo() > 0) {
                clientesSaldoPositivo[gardados] = clientes[i];
                gardados++;
            }
        }
        return clientesSaldoPositivo;
    }

    public static Cliente[] obterClientesSaldoNegativo(Cliente[] clientes) {
        int clientesNegativos = clientes.length - (obterNumeroClientesPositivos(clientes)+ obterNumeroClientesNulos(clientes));
        Cliente[] clientesSaldoNegativo = new Cliente[clientesNegativos];
        int gardados = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getSaldo() < 0) {
                clientesSaldoNegativo[gardados] = clientes[i];
                gardados++;
            }
        }
        return clientesSaldoNegativo;
    }
    
    public static Cliente[] obterClientesSaldoNulo(Cliente[] clientes) {
        int clientesNulos = obterNumeroClientesNulos(clientes);
        Cliente[] clientesSaldoNulo = new Cliente[clientesNulos];
        int gardados = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getSaldo() == 0) {
                clientesSaldoNulo[gardados] = clientes[i];
                gardados++;
            }
        }
        return clientesSaldoNulo;
    }

    private static int obterNumeroClientesPositivos(Cliente[] clientes) {
        int clientesPositivos = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getSaldo() > 0) {
                clientesPositivos++;
            }
        }
        return clientesPositivos;
    }

    private static int obterNumeroClientesNulos(Cliente[] clientes) {
        int clientesNulos = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getSaldo() == 0) {
                clientesNulos++;
            }
        }
        return clientesNulos;
    }
}
