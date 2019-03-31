package excepciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.CAutores;

/**
 *
 * @author 
 */
public class Validar {

    public static int validarDni(String dni, File fichero) throws IOException {
        int d = 0;
        CAutores a;
        try {
            if (dni.length() != 9) {
                d = 1;
                throw new MisExcepciones("Longitud incorrecta");
            }
            if (!dni.substring(0, 8).matches("[0-9]*")) {
                d = 1;
                throw new MisExcepciones("Error, los 8 primeros carácteres deben ser números");
            }
            if (!dni.substring(8).matches("[A-Za-z]")) {
                d = 1;
                throw new MisExcepciones("Error, el último caracter debe ser una letra");
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            try{
                do{
                    a = (CAutores)ois.readObject();
                    if(a.getDni().equalsIgnoreCase(dni)){
                        d=1;
                        throw new MisExcepciones("El autor ya existe");
                    }
                }while(true);
            }catch(EOFException e){
                
            } catch (ClassNotFoundException ex) {
                
                        
            }
            ois.close();
        } catch (MisExcepciones e) {
            System.out.println(e.getError());
        }
        return d;
    }
}
