package db4ovehiculo;

import java.io.BufferedReader;
import java.util.Date;
import objetos.Camion;
import objetos.Coche;

/**
 *
 * @author David
 */
public class Crear {

    public static Coche nuevoCoche(String matricula, BufferedReader lee) {
        String propietario = obtenerPropietario(lee);
        float precio = obtenerPrecio(lee);
        System.out.printf("Modelo: ");
        String modelo = Pedir.texto(lee);
        return new Coche(matricula, propietario, precio, modelo);
    }

    public static Camion nuevoCamion(String matricula, BufferedReader lee) {
        String propietario = obtenerPropietario(lee);
        float precio = obtenerPrecio(lee);
        System.out.printf("Numero de años: ");
        int numeroDeAnos = Pedir.numeroEntero(lee);
        System.out.printf("Potencia: ");
        float potencia = Pedir.numeroRealFloat(lee);
        System.out.printf("Fecha de alta(dd/MM/yyyy): ");
        Date fechaDeAlta = Pedir.fecha(lee);
        return new Camion(matricula, propietario, precio, numeroDeAnos, potencia, fechaDeAlta);
    }

    public static String obtenerMatricula(BufferedReader lee) {
        System.out.printf("Matrícula: ");
        return Pedir.texto(lee);
    }

    public static String obtenerPropietario(BufferedReader lee) {
        System.out.printf("Propietario: ");
        return Pedir.texto(lee);
    }

    public static float obtenerPrecio(BufferedReader lee) {
        System.out.printf("Precio: ");
        return Pedir.numeroRealFloat(lee);
    }
}
