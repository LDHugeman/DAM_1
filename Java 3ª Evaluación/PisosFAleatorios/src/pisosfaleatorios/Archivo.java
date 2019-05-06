package pisosfaleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import objetos.Atico;
import objetos.Duplex;
import objetos.Piso;

/**
 *
 * @author David
 */
public class Archivo {

    public static final int TAMAÑO_MAXIMO_REGISTRO = 140;

    public static int obtenerNumeroRegistros(File fichero) {
        int numeroRegistros = 0;
        if (fichero.exists()) {
            RandomAccessFile flujoDatos = abrirLecturaFichero(fichero);
            try {
                //Es necesario el casteo a float porque la operación sin castear no daría decimal
                numeroRegistros = (int) Math.ceil((float)flujoDatos.length() / TAMAÑO_MAXIMO_REGISTRO); 
            } catch (IOException excepcion) {
                System.out.println("Error al leer el archivo");
            } finally {
                cerrarFlujo(flujoDatos);
            }
        }
        return numeroRegistros;
    }

    public static RandomAccessFile abrirLecturaEscrituraFichero(File fichero) {
        RandomAccessFile flujoDatos = null;
        try {
            flujoDatos = new RandomAccessFile(fichero, "rw");

        } catch (FileNotFoundException excepcion) {
            System.out.println("Archivo no encontrado");
        }
        return flujoDatos;
    }

    public static RandomAccessFile abrirLecturaFichero(File fichero) {
        RandomAccessFile flujoDatos = null;
        try {
            flujoDatos = new RandomAccessFile(fichero, "r");

        } catch (FileNotFoundException excepcion) {
            System.out.println("Archivo no encontrado");
        }
        return flujoDatos;
    }
    
    public static void cerrarFlujo(RandomAccessFile flujoArchivo) {
        try {
            flujoArchivo.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el archivo");
        }
    }
    
    public static File obtenerTemporal(File original, String referenciaBuscada) {
        boolean pisoEncontrado = false;
        File temporal = new File("temporal.dat");
        int numeroRegistros = obtenerNumeroRegistros(original);
        RandomAccessFile lecturaOriginal = abrirLecturaFichero(original);
        RandomAccessFile escrituraTemporal = abrirLecturaEscrituraFichero(temporal);
        try {
            for (int i = 0; i < numeroRegistros; i++){
                lecturaOriginal.seek(i * TAMAÑO_MAXIMO_REGISTRO);
                Piso piso = getPiso(lecturaOriginal);
                if (!piso.getReferencia().equalsIgnoreCase(referenciaBuscada)){
                    piso.guardarEnArchivo(escrituraTemporal);
                } else {
                    pisoEncontrado = true;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error de lectura");
        }
        if(!pisoEncontrado){
            System.err.println("No se ha encontrado un piso con esa referencia.");
        }
        cerrarFlujo(lecturaOriginal);
        cerrarFlujo(escrituraTemporal);
        return temporal;
    }
    
    public static Piso getPiso(RandomAccessFile flujo) throws IOException{
        Piso resultado = null;
        String referencia = flujo.readUTF();
        char tipo = flujo.readChar();
        String nombrePropietario = flujo.readUTF();
        float cuotaFija = flujo.readFloat();
        float consumoAguaCaliente = flujo.readFloat();
        float consumoCalefaccion = flujo.readFloat();
        if (tipo == Piso.TIPO_ATICO){
            float metrosTerraza = flujo.readFloat();
            resultado = new Atico(referencia, tipo, nombrePropietario, cuotaFija, consumoAguaCaliente, consumoCalefaccion, metrosTerraza);
        } else {
            float cuotaExtra = flujo.readFloat();
            resultado = new Duplex(referencia, tipo, nombrePropietario, cuotaFija, consumoAguaCaliente, consumoCalefaccion, cuotaExtra);
        }
        return resultado;
    }   
}
