
package randomempresas;
import java.io.*;

 // @author 

public class Leer {
    
    public static int obtenerNumeroRegistros (File fichero) throws IOException {
        
        int numeroRegistros=0;
        final int TAMAÑO_MAXIMO_REGISTRO = 140;
        if(fichero.exists())
        {
            RandomAccessFile datosArchivo=new RandomAccessFile(fichero,"r");
            numeroRegistros=(int)Math.ceil(datosArchivo.length()/TAMAÑO_MAXIMO_REGISTRO);
            datosArchivo.close();
        }
        return numeroRegistros;
        
    }
    
}
