package clientesbancarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class ClientesBancarios {

    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Cliente[] clientes = null;
        Cliente[] clientesSaldoPositivo = null;
        Cliente[] clientesSaldoNegativo = null;
        Cliente[] clientesSaldoNulo = null;
        byte opcionSeleccionada = 0;
        boolean datosCargados = false;
        boolean datosSeparados = false;
        do {

            opcionSeleccionada = Menu.seleccionarOpcion(lee);
            switch (opcionSeleccionada) {
                case 1:
                    clientes = Introducir.obterClientes(lee);
                    //Poño os datos a null para que se reseteen os valores en caso de que queira introducir novos.
                    clientesSaldoPositivo = null;   
                    clientesSaldoPositivo = null;
                    clientesSaldoNulo = null;
                    datosSeparados = false;
                    datosCargados = true;
                    break;
                case 2:
                    if (datosCargados) {
                        clientesSaldoPositivo = Separar.obterClientesSaldoPositivo(clientes);
                        clientesSaldoNegativo = Separar.obterClientesSaldoNegativo(clientes);
                        clientesSaldoNulo = Separar.obterClientesSaldoNulo(clientes);
                        System.out.printf("CLIENTES DIVIDIDOS.%n");
                        datosSeparados = true;
                    } else {
                        System.err.printf("No hay datos introducidos.%n");
                    }
                    break;
                case 3:
                    if (datosSeparados) {
                        clientesSaldoPositivo = Clasificar.obterOrdenadoNombreDescendenteBurbuja(clientesSaldoPositivo);
                        clientesSaldoNulo = Clasificar.obterOrdenadoNombreDescendenteBurbuja(clientesSaldoNulo);
                        clientesSaldoNegativo = Clasificar.obterOrdenadoNombreDescendenteIntercambio(clientesSaldoNegativo);
                        System.out.printf("CLIENTES ORDENADOS.%n");
                    } else {
                        System.err.printf("No hay datos separados o introducidos.%n");
                    }
                    break;
                case 4:
                    if (datosCargados) {
                        Visualizar.verTodo(clientes, clientesSaldoPositivo, clientesSaldoNegativo, clientesSaldoNulo);
                    } else {
                        System.err.printf("No hay datos introducidos.%n");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.err.printf("Esa opción non existe.%n");
            }
        } while (opcionSeleccionada != 5);
    }   
}
