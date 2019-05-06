
package randomempresas;
import java.io.*;

 // @author 

public class RandomEmpresas {

    
    public static void main(String[] args) throws IOException{
        
        
        File fDatos=new File ("Datos.dat");
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        int nRegs=Leer.obtenerNumeroRegistros(fDatos);
        byte op=0;
        
        
        do{
            try{
                
                op=Menu.menup(op, leer);
                
                switch(op){
                    
                    case 1:
                        nRegs=Altas.alta(fDatos,nRegs, leer);
                        break;
                    case 2:
                        nRegs=Bajas.bajas(fDatos,nRegs, leer);
                        break;
                    case 3:
                        Modificar.modificar(fDatos,nRegs, leer);
                        break;
                    case 4:
                        Buscar.buscar(fDatos, nRegs, leer);
                        break;
                    case 5:
                        Visualizar.visualizar(fDatos,nRegs);
                        break;
                    case 6:
                        System.out.println("--- FIN DEL PROGRAMA ---");
                        break;
                }
            }catch (RuntimeException e){
                
                System.out.println(e.getMessage());
                
            }catch (Exception e) {
                
                System.out.println(e.getMessage());
                
            }
            
        }while(op!=6);
        
        
    }
}
