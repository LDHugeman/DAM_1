package temperaturas;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Introducir {

    private static byte obterTemperatura(String dia, BufferedReader lee) throws IOException{        
        System.out.printf("¿Qué temperatura hizo el " + dia + "?");
        return Byte.parseByte(lee.readLine());         
    }
    
    public static int cargarTemperaturas(byte [] temperaturas, String [] dias, BufferedReader lee)throws IOException{
        for(int i=0;i<temperaturas.length;i++){
            temperaturas[i] = obterTemperatura(dias[i], lee);            
        }
        return obterTemperaturaMedia(temperaturas);
    }
    
    private static int obterTemperaturaMedia(byte [] temperaturas){
        int resultado =0;
        for(int i=0;i<temperaturas.length;i++){
                resultado =resultado + temperaturas[i];
        }
        return resultado/temperaturas.length;
    }
}
