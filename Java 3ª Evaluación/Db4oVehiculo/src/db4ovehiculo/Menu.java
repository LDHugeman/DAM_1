package db4ovehiculo;

import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import java.util.ArrayList;
import objetos.Camion;
import objetos.Coche;
import objetos.Vehiculo;

/**
 *
 * @author David
 */
public class Menu {

    public static void menuAltas(ObjectContainer baseDatos, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    byte opcionCoche = 0;
                    do {
                        String matricula = Crear.obtenerMatricula(lee);
                        if (!Consultar.existeVehiculoPorMatricula(baseDatos, matricula)) {
                            Coche coche = Crear.nuevoCoche(matricula, lee);
                            Altas.vehiculo(baseDatos, coche);
                            System.out.println("Nuevo coche añadido.");
                            System.out.println("¿Desea añadir más coches?");
                            System.out.println("[1] Sí");
                            System.out.println("[2] No");
                            System.out.printf("Seleccione una opción: ");
                            opcionCoche = Pedir.numeroByte(lee);
                        } else {
                            System.err.println("Ya existe un vehículo con esa matrícula");
                        }
                    } while (opcionCoche == 1);
                    break;
                case 2:
                    byte opcionCamion = 0;
                    do {
                        String matricula = Crear.obtenerMatricula(lee);
                        if (!Consultar.existeVehiculoPorMatricula(baseDatos, matricula)) {
                            Camion camion = Crear.nuevoCamion(matricula, lee);
                            Altas.vehiculo(baseDatos, camion);
                            System.out.println("Nuevo camión añadido.");
                            System.out.println("¿Desea añadir más camiones?");
                            System.out.println("[1] Sí");
                            System.out.println("[2] No");
                            System.out.printf("Seleccione una opción: ");
                            opcionCamion = Pedir.numeroByte(lee);
                        } else {
                            System.err.println("Ya existe un vehículo con esa matrícula");
                        }
                    } while (opcionCamion == 1);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuVisualizar(ObjectContainer baseDatos, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuVisualizar(lee);
            switch (opcionSeleccionada) {
                case 1:
                    float precio = Crear.obtenerPrecio(lee);
                    ArrayList<Camion> camiones = Consultar.obtenerCamionesPorPrecio(baseDatos, precio);
                    if (!camiones.isEmpty()) {
                        Visualizar.mostrarCamiones(camiones);
                    } else {
                        System.err.println("No hay camiones con ese precio");
                    }
                    break;
                case 2:
                    String propietario = Crear.obtenerPropietario(lee);
                    ArrayList<Vehiculo> vehiculos = Consultar.obtenerVehiculosDeUnPropietario(baseDatos, propietario);
                    if (!vehiculos.isEmpty()) {
                        Visualizar.mostrarVehiculos(vehiculos);
                    } else {
                        System.err.println("Esta persona no es propietaria de ningún vehículo");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }

    public static byte seleccionarOpcionMenuPrincipal(BufferedReader lee) {
        System.out.println("------- MENÚ -------");
        System.out.println("[1] Altas");
        System.out.println("[2] Bajas");
        System.out.println("[3] Modificaciones");
        System.out.println("[4] Visualizar");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuAltas(BufferedReader lee) {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Coche");
        System.out.println("[2] Camión");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuVisualizar(BufferedReader lee) {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("[1] Camiones con el mismo precio");
        System.out.println("[2] Vehículos de un propietario");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

}
