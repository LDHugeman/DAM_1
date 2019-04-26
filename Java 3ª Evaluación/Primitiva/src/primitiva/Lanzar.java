
package primitiva;

/**
 *
 * @author a18luisdvp
 */
public class Lanzar {
    
    public static int [] boleto(){      
        int [] numeros = new int [6];
        for(int i=0; i<numeros.length; i++){
            int numero = (int)Math.floor(Math.random()*49+1);
            if(numeros[0]!=numero && numeros[1]!=numero
               && numeros[2]!=numero && numeros[3]!=numero
               && numeros[4]!=numero && numeros[5]!=numero){
                numeros[i] = numero;
            }
            
        }
        return numeros;
    }
    
    public static void mostrarBoleto(int [] numeros){
        System.out.println("--- Números premiados ---");
        for(int i=0; i<numeros.length; i++){          
            System.out.println(numeros[i]);
        }
    }
}
