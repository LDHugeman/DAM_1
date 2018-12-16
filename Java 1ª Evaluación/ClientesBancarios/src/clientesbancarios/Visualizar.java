package clientesbancarios;

/**
 *
 * @author David
 */
public class Visualizar {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void verTodo(
            Cliente[] clientes,
            Cliente[] clientesSaldoPositivo,
            Cliente[] clientesSaldoNegativo,
            Cliente[] clientesSaldoNulo
    ) {
        System.out.printf(ANSI_BLUE + "Clientes y saldos iniciales:%n" + ANSI_RESET);
        visualizarClientes(clientes);
        if (clientesSaldoPositivo != null) {
            System.out.printf(ANSI_BLUE + "Clientes con saldo positivo:%n" + ANSI_RESET);
            visualizarClientes(clientesSaldoPositivo);
        }
        if (clientesSaldoNegativo != null) {
            System.out.printf(ANSI_BLUE + "Clientes con saldo negativo:%n" + ANSI_RESET);
            visualizarClientes(clientesSaldoNegativo);
        }
        if (clientesSaldoNulo != null) {
            System.out.printf(ANSI_BLUE + "Clientes con saldo nulo:%n" + ANSI_RESET);
            visualizarClientes(clientesSaldoNulo);
        }
    }

    private static void visualizarClientes(Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            visualizarCliente(clientes[i]);
        }
    }
    
    public static void visualizarCliente(Cliente cliente){
        System.out.printf("Nombre: %s   Saldo: %.2f %n", cliente.getNombre(), cliente.getSaldo());
    }
}
