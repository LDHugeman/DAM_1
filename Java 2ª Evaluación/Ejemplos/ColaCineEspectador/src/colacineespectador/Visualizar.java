
package colacineespectador;
import Clases.*;

// @author 

public class Visualizar {
    
    public static void visualizar(C_Espectador p) {
        
        
        System.out.printf("%n%n--Espectador:"
                + "%nNombre:%5s"
                + "%nPelicula:%-5s"
                + "%nAsiento:%-5d"
                + "%n%n",p.getNombre(),p.getPelicula(),p.getAsiento());

    }
    
    public static void visualizarListado(C_Espectador p) {
        
        System.out.printf("--LISTA DE ESPECTADORES--"
                +"%n%n    Nombre       Pelicula       Asiento"
                +"%n________________________________________");
        
        while (p != null) 
        {
            System.out.printf("%n%-10s %-10s %14d", p.getNombre(),p.getPelicula(),p.getAsiento());
            p=p.getSiguiente();
        }

    }
    
    public static void visualizar() {
        
        System.out.printf("%n--Espectador no encontrado--%n");
    }
    
}
