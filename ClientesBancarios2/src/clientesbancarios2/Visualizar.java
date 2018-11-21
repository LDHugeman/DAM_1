package clientesbancarios2;

/**
 *
 * @author a18luisdvp
 */
public class Visualizar {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void verTodo(
            String[] nombreClientes,
            float[] saldos,
            String[] nombreClientesSaldoPositivo,
            float[] saldosPositivos,
            String[] nombreClientesSaldoNegativo,
            float[] saldosNegativos,
            String[] nombreClientesSaldoNulo,
            float[] saldosNulos
    ) {
        System.out.printf(ANSI_BLUE + "Clientes y saldos iniciales:%n" + ANSI_RESET);
        visualizarClientesYSaldos(nombreClientes, saldos);
        System.out.printf(ANSI_BLUE + "Clientes con saldo positivo:%n" + ANSI_RESET);
        visualizarClientesYSaldos(nombreClientesSaldoPositivo, saldosPositivos);

        System.out.printf(ANSI_BLUE + "Clientes con saldo negativo:%n" + ANSI_RESET);
        visualizarClientesYSaldos(nombreClientesSaldoNegativo, saldosNegativos);

        System.out.printf(ANSI_BLUE + "Clientes con saldo nulo:%n" + ANSI_RESET);
        visualizarClientesYSaldos(nombreClientesSaldoNulo, saldosNulos);

    }

    private static void visualizarClientesYSaldos(String[] nombreClientes, float[] saldos) {
        for (int i = 0; i < nombreClientes.length; i++) {
           /* if (nombreClientes[i] != null) { */
                visualizarCliente(nombreClientes[i], saldos[i]);
          /*  }*/
        }
    }

    public static void visualizarCliente(String nombreCliente, float saldo) {
        System.out.printf("Nombre: %s   Saldo: %.2f %n", nombreCliente, saldo);
    }
}
