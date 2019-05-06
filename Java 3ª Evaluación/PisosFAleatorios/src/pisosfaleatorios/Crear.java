
package pisosfaleatorios;

import java.io.BufferedReader;
import objetos.Atico;
import objetos.Duplex;

/**
 *
 * @author David
 */
public class Crear {
    
    public static Atico nuevoAtico(BufferedReader lee){
        String referencia = obtenerReferencia(lee);
        String nombrePropietario = obtenerNombrePropietario(lee);
        System.out.printf("Cuota fija: ");
        float cuotaFija = Pedir.numeroRealFloat(lee);
        System.out.printf("Consumo de agua caliente: ");
        float consumoAguaCaliente = Pedir.numeroRealFloat(lee);
        System.out.printf("Consumo de calefacción: ");
        float consumoCalefaccion = Pedir.numeroRealFloat(lee);       
        System.out.printf("Metros de terraza: ");
        float metrosTerraza = Pedir.numeroRealFloat(lee);     
        return new Atico(referencia, 'A', nombrePropietario, cuotaFija, consumoAguaCaliente, consumoCalefaccion, metrosTerraza);
    }
    
    public static Duplex nuevoDuplex(BufferedReader lee){
        String referencia = obtenerReferencia(lee);
        String nombrePropietario = obtenerNombrePropietario(lee);
        System.out.printf("Cuota fija: ");
        float cuotaFija = Pedir.numeroRealFloat(lee);
        System.out.printf("Consumo de agua caliente: ");
        float consumoAguaCaliente = Pedir.numeroRealFloat(lee);
        System.out.printf("Consumo de calefacción: ");
        float consumoCalefaccion = Pedir.numeroRealFloat(lee);       
        System.out.printf("Cuota extra: ");
        float cuotaExtra = Pedir.numeroRealFloat(lee);     
        return new Duplex(referencia, 'D', nombrePropietario, cuotaFija, consumoAguaCaliente, consumoCalefaccion, cuotaExtra);
    }
    
    public static String obtenerReferencia(BufferedReader lee){
        System.out.printf("Referencia: ");
        return Pedir.texto(lee);
    }
    
    public static String obtenerNombrePropietario(BufferedReader lee){
        System.out.printf("Nombre del propietario: ");
        return Pedir.texto(lee);
    }
}
