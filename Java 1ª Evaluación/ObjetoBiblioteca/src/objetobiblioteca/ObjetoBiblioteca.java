
package objetobiblioteca;
import java.io.*;
/**
 *
 * @author a18luisdvp
 */
public class ObjetoBiblioteca {

    public static void main(String[] args) throws IOException{
    float Datos=PedirDatos.pedirDatos();
        System.out.printf("La cantidad de libros es: %.2f",Datos);
    }
    
}
