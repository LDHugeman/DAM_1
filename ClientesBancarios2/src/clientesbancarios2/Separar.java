package clientesbancarios2;

/**
 *
 * @author a18luisdvp
 */
public class Separar {

    public static void asignarClientesSaldoPositivo(
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
    
    public static void asignarClientesSaldoNegativo(
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
    
    public static void asignarClientesSaldoNulo(
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
    
}
