package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;
import objetos.CuentaPlazo;
import objetos.Movimiento;

/**
 *
 * @author a18luisdvp
 */
public class Menu {

    public static void menuAltas(File fichero, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    byte opcionCuenta = 0;
                    do {
                        CuentaCorriente cuentaCorriente = Crear.nuevaCuentaCorriente(fichero, lee);
                        System.out.println("--- Inserte un nuevo cliente para la cuenta ---");
                        Cliente cliente = Consultar.obtenerCliente(lee, fichero, cuentaCorriente);
                        cuentaCorriente.getClientes().add(cliente);
                        cliente.getCuentas().add(cuentaCorriente);
                        byte opcionCliente = 0;
                        byte opcionMovimiento = 0;
                        byte opcionMasMovimientos = 0;
                        do {
                            System.out.println("¿Desea añadir más clientes a esta cuenta?");
                            System.out.println("[1] Sí");
                            System.out.println("[2] No");
                            System.out.printf("Seleccione una opción: ");
                            opcionCliente = Pedir.numeroByte(lee);
                            if (opcionCliente == 1) {
                                Cliente clienteNuevo = Consultar.obtenerCliente(lee, fichero, cuentaCorriente);
                                clienteNuevo.getCuentas().add(cuentaCorriente);
                                cuentaCorriente.getClientes().add(clienteNuevo);
                            }
                        } while (opcionCliente == 1);
                        System.out.println("¿Desea añadir un movimiento a esta cuenta?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcionMovimiento = Pedir.numeroByte(lee);
                        if (opcionMovimiento == 1) {
                            cuentaCorriente.agregarNuevoMovimiento(lee);
                            do {
                                System.out.println("¿Desea añadir más movimientos a esta cuenta?");
                                System.out.println("[1] Sí");
                                System.out.println("[2] No");
                                System.out.printf("Seleccione una opción: ");
                                opcionMasMovimientos = Pedir.numeroByte(lee);
                                if (opcionMasMovimientos == 1) {
                                    cuentaCorriente.agregarNuevoMovimiento(lee);
                                }
                            } while (opcionMasMovimientos == 1);
                        }
                        Altas.cuenta(fichero, cuentaCorriente);
                        System.out.println("Cuenta creada");
                        System.out.println("¿Desea añadir más cuentas corriente?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcionCuenta = Pedir.numeroByte(lee);
                    } while (opcionCuenta == 1);
                    break;
                case 2:
                    byte opcionCuentaPlazo = 0;
                    do {
                        CuentaPlazo cuentaPlazo = Crear.nuevaCuentaPlazo(fichero, lee);
                        System.out.println("--- Inserte un nuevo cliente para la cuenta ---");
                        Cliente primerCliente = Consultar.obtenerCliente(lee, fichero, cuentaPlazo);
                        cuentaPlazo.getClientes().add(primerCliente);
                        primerCliente.getCuentas().add(cuentaPlazo);
                        byte opcionClientes = 0;
                        do {
                            System.out.println("¿Desea añadir más clientes a esta cuenta?");
                            System.out.println("[1] Sí");
                            System.out.println("[2] No");
                            System.out.printf("Seleccione una opción: ");
                            opcionClientes = Pedir.numeroByte(lee);
                            if (opcionClientes == 1) {
                                Cliente clienteNuevo = Consultar.obtenerCliente(lee, fichero, cuentaPlazo);
                                cuentaPlazo.getClientes().add(clienteNuevo);
                                clienteNuevo.getCuentas().add(cuentaPlazo);
                            }
                        } while (opcionClientes == 1);
                        Altas.cuenta(fichero, cuentaPlazo);
                        System.out.println("Cuenta creada");
                        System.out.println("¿Desea añadir más cuentas a plazo?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcionCuentaPlazo = Pedir.numeroByte(lee);
                    } while (opcionCuentaPlazo == 1);
                    break;
                case 3:
                    CuentaCorriente cuenta = Consultar.encontrarCuentaCorrientePorNumero(fichero, Crear.pedirNumeroCuentaExistente(fichero, lee));
                    if (cuenta != null) {
                        Modificar.agregarMovimiento(fichero, cuenta, lee);
                    } else {
                        System.out.println("No se ha encontrado ninguna cuenta corriente con ese número de cuenta");
                    }
                    break;
                case 4:
                    System.out.println("--- Inserte el número de cuenta a la que desea añadir clientes ---");
                    Cuenta cuentaEncontrada = Consultar.encontrarCuentaPorNumero(fichero, Crear.pedirNumeroCuentaExistente(fichero, lee));
                    Visualizar.mostrarCuenta(cuentaEncontrada);
                    byte opcion = 0;
                    do {
                        System.out.println("¿Desea añadir más clientes a esta cuenta?");
                        System.out.println("[1] Sí");
                        System.out.println("[2] No");
                        System.out.printf("Seleccione una opción: ");
                        opcion = Pedir.numeroByte(lee);
                        if (opcion == 1) {
                            Modificar.agregarCliente(fichero, cuentaEncontrada, lee);
                        }
                    } while (opcion == 1);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuBajas(File fichero, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuBajas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Cuenta cuentaEncontrada = Consultar.encontrarCuentaPorNumero(fichero, Crear.pedirNumeroCuentaExistente(fichero, lee));
                    Visualizar.mostrarCuenta(cuentaEncontrada);
                    System.out.println("¿Es esta la cuenta que desea eliminar?");
                    System.out.println("[1] Sí");
                    System.out.println("[2] No");
                    System.out.printf("Seleccione una opción: ");
                    byte opcion = Pedir.numeroByte(lee);
                    if (opcion == 1) {
                        Bajas.cuenta(fichero, cuentaEncontrada);
                        System.out.println("Cuenta eliminada");
                    } else {
                        System.out.println("Operación cancelada");
                    }
                    break;
                case 2:
                    Bajas.cliente(fichero, Crear.pedirDniExistente(fichero, lee), lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuConsultas(File fichero, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuConsultas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Cuenta cuentaEncontrada = Consultar.encontrarCuentaPorNumero(fichero, Crear.pedirNumeroCuentaExistente(fichero, lee));
                    Visualizar.mostrarClientes(cuentaEncontrada.getClientes());
                    break;
                case 2:
                    ArrayList<Cuenta> cuentas = Consultar.encontrarCuentasDeCliente(fichero, Consultar.encontrarClientePorDni(fichero, Crear.pedirDniExistente(fichero, lee)));
                    Visualizar.mostrarCuentas(cuentas);
                    break;
                case 3:
                    System.out.println("--- Introduzca el número de cuenta ---");
                    String numero = Crear.pedirNumeroCuentaExistente(fichero, lee);
                    CuentaCorriente cuentaCorrienteEncontrada = Consultar.encontrarCuentaCorrientePorNumero(fichero, numero);
                    ArrayList<Movimiento> movimientosEncontrados = Consultar.obtenerMovimientosEntreFechas(cuentaCorrienteEncontrada.getMovimientos(), lee);
                    if (!movimientosEncontrados.isEmpty()) {
                        Visualizar.mostrarMovimientos(movimientosEncontrados);
                    } else {
                        System.out.println("No hay ningún movimiento entre esas dos fechas");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Crear fichero");
        System.out.println("[2] Altas");
        System.out.println("[3] Bajas");
        System.out.println("[4] Modificar dirección de un cliente");
        System.out.println("[5] Consultar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarOpcionMenuAltas(BufferedReader lee) {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Cuenta corriente");
        System.out.println("[2] Cuenta a plazo");
        System.out.println("[3] Añadir movimientos a una cuenta corriente");
        System.out.println("[4] Añadir clientes a una cuenta existente");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarOpcionMenuBajas(BufferedReader lee) {
        System.out.println("------- BAJAS -------");
        System.out.println("[1] Eliminar cuenta corriente");
        System.out.println("[2] Eliminar cliente de una determinada cuenta");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarOpcionMenuConsultas(BufferedReader lee) {
        System.out.println("------- CONSULTAS -------");
        System.out.println("[1] Visualizar clientes de una cuenta");
        System.out.println("[2] Visualizar cuentas de un cliente");
        System.out.println("[3] Visualizar movimientos entre dos fechas");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    public static byte seleccionarTipoMovimiento(BufferedReader lee) {
        System.out.println("--- Elija el tipo de movimiento ---");
        System.out.println("[1] Ingreso");
        System.out.println("[2] Retirada");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }
}
