package pisosfaleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objetos.Atico;
import objetos.Duplex;
import objetos.Piso;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void pisos(File fichero) {
        RandomAccessFile flujoLectura = Archivo.abrirLecturaFichero(fichero);
        int numeroRegistros = Archivo.obtenerNumeroRegistros(fichero);
        for (int i = 0; i < numeroRegistros; i++) {
            try {
                flujoLectura.seek(i * Archivo.TAMAÑO_MAXIMO_REGISTRO);
                Piso piso = Archivo.getPiso(flujoLectura);
                System.out.println("-------------------------------------------");
                System.out.println("Referencia: " + piso.getReferencia());
                System.out.println("Nombre del propietario " + piso.getNombrePropietario());
                System.out.println("Cuota fija: " + piso.getCuotaFija());
                System.out.println("Consumo de agua caliente: " + piso.getConsumoAguaCaliente());
                System.out.println("Consumo de calefacción: " + piso.getConsumoCalefaccion());
                if (piso instanceof Atico) {
                    System.out.println("Metros de terraza: " + ((Atico) piso).getMetrosTerraza());
                } else {
                    System.out.println("Cuota extra: " + ((Duplex) piso).getCuotaExtra());
                }
            } catch (IOException ex) {
                System.out.println("Error posicionarse en el registro");
            }
            System.out.println("-------------------------------------------");
        }
    }
    
    public static void recibos (File fichero){
        RandomAccessFile flujoLectura = Archivo.abrirLecturaFichero(fichero);
        int numeroRegistros = Archivo.obtenerNumeroRegistros(fichero);
        for (int i = 0; i < numeroRegistros; i++) {
            try {
                flujoLectura.seek(i * Archivo.TAMAÑO_MAXIMO_REGISTRO);
                Piso piso = Archivo.getPiso(flujoLectura);
                System.out.println("-------------------------------------------");
                System.out.println("Consumo de agua caliente: " + piso.getConsumoAguaCaliente());
                System.out.println("Consumo de calefacción: " + piso.getConsumoCalefaccion());         
                System.out.println("Importe total: "+piso.totalRecibo());     
                System.out.println("-------------------------------------------");
            } catch (IOException ex) {
                System.out.println("Error posicionarse en el registro");
            }           
        }
    }
    
    public static void pisosDeUnPropietario(ArrayList<Piso> pisosPropietario){
        for(Piso piso:pisosPropietario){
            System.out.println("-------------------------------------------");
                System.out.println("Referencia: " + piso.getReferencia());
                System.out.println("Nombre del propietario " + piso.getNombrePropietario());
                System.out.println("Cuota fija: " + piso.getCuotaFija());
                System.out.println("Consumo de agua caliente: " + piso.getConsumoAguaCaliente());
                System.out.println("Consumo de calefacción: " + piso.getConsumoCalefaccion());
                if (piso instanceof Atico) {
                    System.out.println("Metros de terraza: " + ((Atico) piso).getMetrosTerraza());
                } else {
                    System.out.println("Cuota extra: " + ((Duplex) piso).getCuotaExtra());
                }         
            System.out.println("-------------------------------------------");
        }
    }
}
