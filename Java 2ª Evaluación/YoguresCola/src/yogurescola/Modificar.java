
package yogurescola;

import java.io.BufferedReader;
import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Modificar {
    
    public static void codigoYogur(Yogourt cabecera,Yogourt yogur, BufferedReader lee){
        System.out.println("--- Elija el nuevo código para el yogur ---");
        yogur.setCodigo(Crear.pedirNuevoCodigo(cabecera, lee));
        System.out.println("Código del yogur modificado");
    }
    
    public static void marcaYogur(Yogourt cabecera, Yogourt yogur, BufferedReader lee){
        System.out.println("--- Elija la nueva marca para el yogur ---");
        yogur.setMarca(Crear.pedirNuevaMarca(cabecera, lee));
        System.out.println("Marca del yogur modificada");
    }
    
    public static void tipoYogur(Yogourt yogur, BufferedReader lee){
        System.out.println("--- Elija el nuevo tipo para el yogur ---");
        yogur.setTipo(Crear.pedirTipo(lee));
        System.out.println("Tipo del yogur modificado");
    }
}
