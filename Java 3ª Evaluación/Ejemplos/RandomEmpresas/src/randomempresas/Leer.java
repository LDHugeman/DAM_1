
package randomempresas;
import java.io.*;

 // @author 

public class Leer {
    
    public static int leer (File fDatos) throws IOException {
        
        int nRegs=0;
        if(fDatos.exists())
        {
            
            RandomAccessFile rafDatos=new RandomAccessFile(fDatos,"r");
            nRegs=(int)Math.ceil((float)rafDatos.length()/140);
            rafDatos.close();
            
        }
        return nRegs;
        
    }
    
}
