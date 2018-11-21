package clientesbancarios2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class ClientesBancarios2 {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String[] nombreClientes = new String[4];
        float[] saldos = new float[4];
        String[] nombreClientesSaldoPositivo = new String[4];
        float[] saldosPositivos = new float[4];;
        String[] nombreClientesSaldoNegativo = new String[4];
        float[] saldosNegativos = new float[4];
        String[] nombreClientesSaldoNulo = new String[4];
        float[] saldosNulos = new float[4];
        byte opcionSeleccionada = 0;
        boolean datosCargados = false;
        boolean datosSeparados = false;
        do {
            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Introducir.obterClientes(lee, nombreClientes, saldos);
                    datosSeparados = false;
                    datosCargados = true;
                    break;
                case 2:
                    if (datosCargados) {
                        Separar.obterClientesSaldoPositivo(nombreClientes, saldos, nombreClientesSaldoPositivo, saldosPositivos);
                        Separar.obterClientesSaldoNegativo(nombreClientes, saldos, nombreClientesSaldoNegativo, saldosNegativos);
                        Separar.obterClientesSaldoNulo(nombreClientes, saldos, nombreClientesSaldoNulo, saldosNulos);
                        System.out.printf("CLIENTES SEPARADOS.%n");
                        datosSeparados = true;
                    } else {
                        System.err.printf("No hay datos introducidos.%n");
                    }
                    break;
                case 3:
                    if (datosSeparados) {
                        Clasificar.obterOrdenadoNombreDescendenteBurbuja(nombreClientesSaldoPositivo, saldosPositivos);
                        Clasificar.obterOrdenadoNombreDescendenteBurbuja(nombreClientesSaldoNulo, saldosNulos);
                        Clasificar.obterOrdenadoNombreAscendenteIntercambio(nombreClientesSaldoNegativo, saldosNegativos);
                        System.out.printf("CLIENTES ORDENADOS.%n");
                    } else {
                        System.err.printf("No hay datos separados o introducidos.%n");
                    }
                    break;
                case 4:
                    if (datosCargados) {
                        String nombreBusqueda = Introducir.obterNombreBusqueda(lee);
                        Buscar.imprimirClienteEncontrado(nombreClientes, saldos, nombreBusqueda);
                    } else {
                        System.err.printf("No hay datos introducidos.%n");
                    }
                    break;
                case 5:
                    Visualizar.verTodo(nombreClientes, saldos, nombreClientesSaldoPositivo, saldosPositivos, nombreClientesSaldoNegativo, saldosNegativos, nombreClientesSaldoNulo, saldosNulos);
                    break;
                case 6:
                    break;
                default:
                    System.err.printf("Esa opción non existe.%n");
            }
        } while (opcionSeleccionada != 6);
    }
}
