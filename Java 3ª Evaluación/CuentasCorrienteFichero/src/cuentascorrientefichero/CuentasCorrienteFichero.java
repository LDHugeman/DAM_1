package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.CuentaCorriente;

/**
 *
 * @author a18luisdvp
 */
public class CuentasCorrienteFichero {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        File fichero = new File("cuentas.dat");
        byte opcionSeleccionada = 0;
        //test();
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Archivo.nuevoFichero(fichero, lee);
                    break;
                case 2:
                    Menu.menuAltas(fichero, lee);
                    break;
                case 3:
                    Menu.menuBajas(fichero, lee);
                    break;
                case 4:
                    Modificar.direccionCliente(fichero, Crear.pedirDniExistente(fichero, lee), lee);
                    System.out.println("Dirección modificada correctamente");
                    break;
                case 5:
                    Menu.menuConsultas(fichero, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void test() {
        Cuenta cuenta = new CuentaCorriente("12", "dena", 100);
        Cuenta cuenta2 = new CuentaCorriente("12", "dena", 100);
        Cliente cliente = new Cliente("a", "Jose", "Vigo");
        cuenta.getClientes().add(cliente);
        cuenta2.getClientes().add(cliente);
        cliente.setDireccion("Coruuña");
        for (Cliente cliente1 : cuenta.getClientes()){
            System.out.println(cliente1.getDireccion());
            String texto = cuenta.getClientes().contains(cliente) ? "true" : "false";
            System.out.println(texto);
        }
        for (Cliente cliente1 : cuenta.getClientes()){
            System.out.println(cliente1.getDireccion());
        }
        
        File fichero = new File("test.dat");
        ObjectOutputStream flujo = Archivo.crearFichero(fichero);
        try {
            flujo.writeObject(cuenta);
        } catch (IOException ex) {
        } finally {
            Archivo.cerrarFlujo(flujo);
        }
        ObjectInputStream lectura = Archivo.abrirLecturaFichero(fichero);
        try {
            cliente.setDireccion("Madrid");
            Cuenta cuentaArchivo = (Cuenta)lectura.readObject();
            String texto = cuentaArchivo.getClientes().contains(cliente) ? "true" : "false";
            System.out.println(texto);
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } finally {
            Archivo.cerrarFlujo(lectura);
        }
    }    
}
