package pisosfaleatorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import objetos.Atico;
import objetos.Duplex;
import objetos.Piso;
import static pisosfaleatorios.Crear.obtenerReferencia;

/**
 *
 * @author David
 */
public class Modificar {

    public static void modificar(File fichero, String referencia, BufferedReader lee) {
        Piso piso = Consultar.buscarPisoPorReferencia(fichero, referencia);
        int numeroRegistroPiso = Consultar.obtenerNumeroRegistroDelPiso(fichero, referencia);
        modificarPiso(piso, lee);
        RandomAccessFile flujoArchivoRW = Archivo.abrirLecturaEscrituraFichero(fichero);
        try {
            flujoArchivoRW.seek(numeroRegistroPiso * Archivo.TAMAÑO_MAXIMO_REGISTRO);
            piso.guardarEnArchivo(flujoArchivoRW);
        } catch (IOException excepcion) {
            System.out.println("Error al posicionarse en el registro");
        } finally {
            Archivo.cerrarFlujo(flujoArchivoRW);
        }

    }

    private static Piso modificarPiso(Piso piso, BufferedReader lee) {
        System.out.println("¿Qué desea modificar?");
        System.out.println("[1] Referencia");
        System.out.println("[2] Nombre del propietario");
        System.out.println("[3] Cuota fija");
        System.out.println("[4] Consumo de agua caliente");
        System.out.println("[5] Consumo de calefacción");
        System.out.println("[6] Metros terraza");
        System.out.println("[7] Cuota extra");
        System.out.println("[0] Salir");
        System.out.printf("Seleccione una opcion: ");
        byte opcion = Pedir.numeroByte(lee);
        switch (opcion) {
            case 1:
                piso.setReferencia(obtenerReferencia(lee));
                System.out.println("Referencia modificada correctamente");
                break;
            case 2:
                System.out.printf("Nombre del propietario: ");
                piso.setNombrePropietario(Pedir.texto(lee));
                System.out.println("Nombre del propietario modificado correctamente");
                break;
            case 3:
                System.out.printf("Cuota fija: ");
                piso.setCuotaFija(Pedir.numeroRealFloat(lee));
                System.out.println("Cuota fija modificada correctamente");
                break;
            case 4:
                System.out.printf("Consumo de agua caliente: ");
                piso.setConsumoAguaCaliente(Pedir.numeroRealFloat(lee));
                System.out.println("Consumo de agua caliente modificado correctamente");
                break;
            case 5:
                System.out.printf("Consumo de calefacción: ");
                piso.setConsumoCalefaccion(Pedir.numeroRealFloat(lee));
                System.out.println("Consumo de calefacción modificado correctamente");
                break;
            case 6:
                if (piso instanceof Atico) {
                    System.out.printf("Metros de terraza: ");
                    ((Atico) piso).setMetrosTerraza(Pedir.numeroRealFloat(lee));
                    System.out.println("Metros de terraza modificados correctamente");
                } else {
                    System.err.println("No puede modificar esta propiedad porque la referencia del piso introducida no es de un ático");
                }
                break;
            case 7:
                if (piso instanceof Duplex) {
                    System.out.printf("Cuota extra: ");
                    ((Duplex) piso).setCuotaExtra(Pedir.numeroRealFloat(lee));
                    System.out.println("Cuota extra modificada correctamente");
                } else {
                    System.err.println("No puede modificar esta propiedad porque la referencia del piso introducida no es de un dúplex");
                }
                break;
            case 0:
                System.out.println("No se ha modificado nada");
                break;
        }
        return piso;
    }
}
