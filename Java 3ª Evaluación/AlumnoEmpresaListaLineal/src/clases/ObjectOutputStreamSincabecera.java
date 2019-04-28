
package clases;

import java.io.*;

/**
 *
 * @author 
 */
public class ObjectOutputStreamSincabecera extends ObjectOutputStream {
    
    public ObjectOutputStreamSincabecera(OutputStream out) throws IOException {
        super (out);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
        this.reset();
    }
}
