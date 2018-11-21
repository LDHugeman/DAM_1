package clientesbancarios2;

/**
 *
 * @author a18luisdvp
 */
public class Separar {

    public static void obterClientesSaldoPositivo(
            String[] nombreClientes,
            float[] saldos,
            String[] nombreClientesSaldoPositivo,
            float[] saldosPositivos) {
        int gardados = 0;
        for (int i = 0; i < nombreClientes.length; i++) {
            if (saldos[i] > 0) {
                nombreClientesSaldoPositivo[gardados] = nombreClientes[i];
                saldosPositivos[gardados] = saldos[i];
                gardados++;
            }
        }
    }
    
    public static void obterClientesSaldoNegativo(
            String[] nombreClientes,
            float[] saldos,
            String[] nombreClientesSaldoNegativo,
            float[] saldosNegativos) {
        int gardados = 0;
        for (int i = 0; i < nombreClientes.length; i++) {
            if (saldos[i] < 0) {
                nombreClientesSaldoNegativo[gardados] = nombreClientes[i];
                saldosNegativos[gardados] = saldos[i];
                gardados++;
            }
        }
    }
    
    public static void obterClientesSaldoNulo(
            String[] nombreClientes,
            float[] saldos,
            String[] nombreClientesSaldoNulo,
            float[] saldosNulos) {
        int gardados = 0;
        for (int i = 0; i < nombreClientes.length; i++) {
            if (saldos[i] == 0) {
                nombreClientesSaldoNulo[gardados] = nombreClientes[i];
                saldosNulos[gardados] = saldos[i];
                gardados++;
            }
        }
    }  

    private static int obterNumeroClientesPositivos(float[] saldos) {
        int clientesPositivos = 0;
        for (int i = 0; i < saldos.length; i++) {
            if (saldos[i] > 0) {
                clientesPositivos++;
            }
        }
        return clientesPositivos;
    }

    private static int obterNumeroClientesNulos(float[] saldos) {
        int clientesNulos = 0;
        for (int i = 0; i < saldos.length; i++) {
            if (saldos[i] == 0) {
                clientesNulos++;
            }
        }
        return clientesNulos;
    }
}
