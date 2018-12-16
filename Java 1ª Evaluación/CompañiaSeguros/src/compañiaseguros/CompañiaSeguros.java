
package compañiaseguros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class CompañiaSeguros {

    public static void main(String[] args) throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Tarifa tarifa = obterTarifa(lee);
        System.out.println(tarifa.toString());
    }
    
    public static Tarifa obterTarifa(BufferedReader lee) throws IOException{
        System.out.printf("Nombre del asegurado: ");
        String nombre = lee.readLine();
        System.out.printf("Edad: ");
        byte edad = Byte.parseByte(lee.readLine());
        System.out.printf("Antigüedad del carnet: ");
        byte antiguedad = Byte.parseByte(lee.readLine());
        System.out.printf("Precio del vehículo: ");
        double precioCoche = Double.parseDouble(lee.readLine());
        
        return new Tarifa(nombre, edad, antiguedad, precioCoche);
        
            
    }
}
