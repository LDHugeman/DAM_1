
package articulospilas;
import clases.*;
import java.io.*;

// @author 

public class ArticulosPilas {


    
    public static void main(String[] args) throws IOException {
    
        byte op=0;
        BufferedReader leer=new BufferedReader(new InputStreamReader (System.in));
        Articulo p=null;
        
        
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
