package db4oempleadosfijostemporales;

import com.db4o.ObjectContainer;
import java.io.BufferedReader;
import objetos.Empleado;
import objetos.EmpleadoFijo;
import objetos.EmpleadoTemporal;
import objetos.Empresa;
import objetos.Producto;
import objetos.Venta;

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
                    Altas.altaEmpresa(baseDatos, Crear.nuevaEmpresa(lee));
                    break;
                case 2:
                    menuAltasEmpleados(baseDatos, lee);
                    break;
                case 3:
                    Producto producto = Crear.nuevoProducto(baseDatos, lee);
                    System.out.println("--- Introduzca el cif de la empresa a la que desea añadir el producto ---");
                    String cifEmpresa = Crear.obtenerCifEmpresa(baseDatos, lee);
                    Empresa empresa = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresa);
                    Altas.producto(baseDatos, producto, empresa);
                    break;
                case 4:
                    System.out.println("--- Introduzca el código del producto del que desea registrar ventas ---");
                    String codigo = Crear.obtenerCodigoProducto(lee);
                    Producto productoBuscado = Consultar.obtenerProductoPorCodigo(baseDatos, codigo);
                    if (productoBuscado != null) {
                        System.out.println("--- Introduzca el cif de la empresa que tiene este producto en el almacén ---");
                        String cifEmpresaP = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaBuscada = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaP);
                        Venta venta = Crear.nuevaVenta(baseDatos, productoBuscado, lee);
                        String dniEmpleadoTemporal = "";
                        do {
                            System.out.printf("Dni del empleado temporal al que desea añadir la venta: ");
                            dniEmpleadoTemporal = Pedir.texto(lee);
                            if (!Consultar.existeEmpleadoTemporalPorDni(baseDatos, dniEmpleadoTemporal)) {
                                System.err.println("No existe ningun empleado temporal con ese dni");
                            }
                        } while (!Consultar.existeEmpleadoTemporalPorDni(baseDatos, dniEmpleadoTemporal));
                        EmpleadoTemporal empleadoTemporalBuscado = Consultar.obtenerEmpleadoTemporalPorDni(baseDatos, dniEmpleadoTemporal);
                        Altas.venta(baseDatos, venta, empleadoTemporalBuscado, empresaBuscada);
                    } else {
                        System.err.println("No existe ningún producto con el código " + codigo);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuAltasEmpleados(ObjectContainer baseDatos, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuAltasEmpleados(lee);
            switch (opcionSeleccionada) {
                case 1:
                    EmpleadoFijo empleadoFijo = Crear.nuevoEmpleadoFijo(baseDatos, lee);
                    System.out.println("--- Introduzca el cif de la empresa a la que desea añadir el empleado ---");
                    String cifEmpresaEF = Crear.obtenerCifEmpresa(baseDatos, lee);
                    Empresa empresaEF = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaEF);
                    Altas.empleado(baseDatos, empleadoFijo, empresaEF);
                    break;
                case 2:
                    EmpleadoTemporal empleadoTemporal = Crear.nuevoEmpleadoTemporal(baseDatos, lee);
                    System.out.println("--- Introduzca el cif de la empresa a la que desea añadir el empleado ---");
                    String cifEmpresaET = Crear.obtenerCifEmpresa(baseDatos, lee);
                    Empresa empresaET = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaET);
                    Altas.empleado(baseDatos, empleadoTemporal, empresaET);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuBajas(ObjectContainer baseDatos, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuBajas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    String dniEmpleadoFijo = Crear.obtenerDniEmpleado(lee);
                    EmpleadoFijo empleadoFijo = Consultar.obtenerEmpleadoFijoPorDni(baseDatos, dniEmpleadoFijo);
                    if (empleadoFijo != null) {
                        System.out.println("--- Introduzca el cif de la empresa de la que desea eliminar el empleado ---");
                        String cifEmpresaEF = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaEF = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaEF);
                        Bajas.empleado(baseDatos, empleadoFijo, empresaEF);
                    } else {
                        System.err.println("No existe ningún empleado fijo con el dni " + dniEmpleadoFijo);
                    }
                    break;
                case 2:
                    String dniEmpleadoTemporal = Crear.obtenerDniEmpleado(lee);
                    EmpleadoTemporal empleadoTemporal = Consultar.obtenerEmpleadoTemporalPorDni(baseDatos, dniEmpleadoTemporal);
                    if (empleadoTemporal != null) {
                        System.out.println("--- Introduzca el cif de la empresa de la que desea eliminar el empleado ---");
                        String cifEmpresaET = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaET = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaET);
                        Bajas.empleado(baseDatos, empleadoTemporal, empresaET);
                    } else {
                        System.err.println("No existe ningún empleado temporal con el dni " + dniEmpleadoTemporal);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuModificaciones(ObjectContainer baseDatos, BufferedReader lee) {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarOpcionMenuModificaciones(lee);
            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("--- Introduzca el código del producto del que desea modificar el precio ---");
                    String codigo = Crear.obtenerCodigoProducto(lee);
                    Producto producto = Consultar.obtenerProductoPorCodigo(baseDatos, codigo);
                    if (producto != null) {
                         System.out.println("--- Introduzca el cif de la empresa que tiene este producto en el almacén ---");
                        String cifEmpresaP = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaP = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaP);
                        Modificar.precioProducto(baseDatos, empresaP, producto, lee);
                    } else {
                        System.err.println("No existe ningún producto con el código " + codigo);
                    }
                    break;
                case 2:
                    System.out.println("--- Introduzca el dni del empleado fijo al que desea modificar el sueldo base ---");
                    String dniEmpleadoFijo = Crear.obtenerDniEmpleado(lee);
                    EmpleadoFijo empleadoFijo = Consultar.obtenerEmpleadoFijoPorDni(baseDatos, dniEmpleadoFijo);
                    if (empleadoFijo != null) {
                        System.out.println("--- Introduzca el cif de la empresa la que pertenece el empleado ---");
                        String cifEmpresaEF = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaEF = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaEF);
                        Modificar.sueldoBaseEmpleadoFijo(baseDatos, empresaEF, empleadoFijo, lee);
                    } else {
                        System.err.println("No existe ningún empleado fijo con el dni " + dniEmpleadoFijo);
                    }
                    break;
                case 3:
                    System.out.println("--- Introduzca el empleado al que desea modificar el porcentaje de retención ---");
                    String dniEmpleado = Crear.obtenerDniEmpleado(lee);
                    Empleado empleado = Consultar.obtenerEmpleadoPorDni(baseDatos, dniEmpleado);
                    if (empleado != null) {
                        System.out.println("--- Introduzca el cif de la empresa la que pertenece el empleado ---");
                        String cifEmpresaE = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaE = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaE);
                        Modificar.porcentajeRetencionEmpleado(baseDatos, empresaE, empleado, lee);
                    } else {
                        System.err.println("No existe ningún empleado con el dni " + dniEmpleado);
                    }
                    break;
                case 4:
                    System.out.println("--- Introduzca el dni del empleado temporal al que desea modificar el precio por día ---");
                    String dniEmpleadoTemporal = Crear.obtenerDniEmpleado(lee);
                    EmpleadoTemporal empleadoTemporal = Consultar.obtenerEmpleadoTemporalPorDni(baseDatos, dniEmpleadoTemporal);
                    if (empleadoTemporal != null) {
                        System.out.println("--- Introduzca el cif de la empresa la que pertenece el empleado ---");
                        String cifEmpresaET = Crear.obtenerCifEmpresa(baseDatos, lee);
                        Empresa empresaET = Consultar.obtenerEmpresaPorCif(baseDatos, cifEmpresaET);
                        Modificar.pagoDiaEmpleadoTemporal(baseDatos, empresaET, empleadoTemporal, lee);
                    } else {
                        System.err.println("No existe ningún empleado temporal con el dni " + dniEmpleadoTemporal);
                    }
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
                    Visualizar.mostrarEmpresas(Consultar.obtenerEmpresas(baseDatos));
                    break;
                case 2:
                    System.out.println("--- Introduzca el cif de la empresa de la que desea ver sus productos ---");
                    String cif = Crear.obtenerCifEmpresa(baseDatos, lee);
                    Empresa empresa = Consultar.obtenerEmpresaPorCif(baseDatos, cif);
                    if (empresa != null) {
                        Visualizar.mostrarProductos(empresa);
                    } else {
                        System.err.println("No hay ninguna empresa con cif " + cif);
                    }
                    break;
                case 3:
                    System.out.println("--- Introduzca el dni del empleado temporal del que desea ver su nómina ---");
                    String dni = Crear.obtenerDniEmpleado(lee);
                    EmpleadoTemporal empleadoTemporal = Consultar.obtenerEmpleadoTemporalPorDni(baseDatos, dni);
                    if (empleadoTemporal != null) {
                        final float SUPLEMENTO = 100;
                        float nomina = 0;
                        float importeVentas = Consultar.obtenerImporteVentasEmpleadoTemporalEntreFechas(empleadoTemporal.getVentas(), empleadoTemporal);
                        if(importeVentas>100.000){
                            nomina = empleadoTemporal.calculoNomina() + SUPLEMENTO;
                        } else {
                            nomina = empleadoTemporal.calculoNomina();
                        }
                        Visualizar.mostrarEmpleado(empleadoTemporal);
                        System.out.println("A este empleado le corresponde una nómina de " + nomina + "€");
                    } else {
                        System.err.println("No existe ningún empleado con el dni " + dni);
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
        System.out.printf("Seleccione una opcion: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuAltas(BufferedReader lee) {
        System.out.println("------- ALTAS -------");
        System.out.println("[1] Empresas");
        System.out.println("[2] Empleados");
        System.out.println("[3] Productos");
        System.out.println("[4] Ventas de Empleados Temporales");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuBajas(BufferedReader lee) {
        System.out.println("------- BAJAS -------");
        System.out.println("[1] Empleados Fijos");
        System.out.println("[2] Empleados Temporales");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuAltasEmpleados(BufferedReader lee) {
        System.out.println("------- ALTAS EMPLEADOS -------");
        System.out.println("[1] Fijos");
        System.out.println("[2] Temporales");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuModificaciones(BufferedReader lee) {
        System.out.println("------- MODIFICACIONES -------");
        System.out.println("[1] Precio de un producto");
        System.out.println("[2] Sueldo base de un empleado fijo");
        System.out.println("[3] Porcentaje de retención");
        System.out.println("[4] Importe por día del empleado temporal");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }

    private static byte seleccionarOpcionMenuVisualizar(BufferedReader lee) {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("[1] Empresas con sus empleados fijos y temporales");
        System.out.println("[2] Productos de una empresa determinada");
        System.out.println("[3] Nómina de un empleado temporal");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opción: ");
        return Pedir.numeroByte(lee);
    }
}
