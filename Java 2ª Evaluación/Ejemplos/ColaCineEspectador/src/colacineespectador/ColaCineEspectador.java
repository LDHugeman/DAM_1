
package colacineespectador;
import java.io.*;
import Clases.*;

// @author 

public class ColaCineEspectador {

    public static void main(String[] args) throws IOException {
        
        
        byte op=0;
        BufferedReader leer = new BufferedReader (new InputStreamReader(System.in));
        C_Espectador p = null;
        
        
        
        do{
            
            op=Menu.menu(op, leer);
            
            switch(op){
                case 1:
                    p=Crear.crear(p, leer);
                    break;
                case 2:
                    p=Insertar.insertar(p, leer);
                    break;
                case 3:
                    p=Borrar.borrar(p, leer);
                    break;
                case 4:
                    Buscar.buscar(p, leer);
                    break;
                case 5:
                    Modificar.buscar(p, leer);
                    break;
                case 6:
                    Visualizar.visualizarListado(p);
                    break;
                case 0:
                    System.out.println("---FIN DEL PROGRAMA---");
                    break;
                default:
                    System.out.println("Opción incorrecta");
        }
        }while(op!=0);
        
        
        
        
        
        
        
        
        
        
    }
}
