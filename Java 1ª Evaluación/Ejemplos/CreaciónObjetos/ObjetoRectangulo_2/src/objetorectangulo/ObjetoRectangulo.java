package objetorectangulo;

import java.util.*;

/**
 *
 * @author clara
 */
public class ObjetoRectangulo {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);  
        Rectangulo rec2 = new Rectangulo(obterBase(sc), obterAltura(sc));
        
        Rectangulo rectangulo = new Rectangulo();
        */
        
        exemploFarolas();
        
        /*
        //Visualización
        Visualizar.visual(rec2);

        System.out.println("dame base :");
        int base1 = sc.nextInt();
        System.out.println("dame altura :");
        float altura1 = sc.nextFloat();
        //Constructor sin parámetros
        Rectangulo rec = new Rectangulo();
        int chourizo = 5;
        float aLtura = obterAltura(sc);
        rec.setBase(base1);
        rec.setAltura(altura1);
        //Visualización
        Visualizar.visual(rec);
*/
    }
    
    private static float obterAltura (Scanner leer){
        System.out.println("Altura: ");
        return leer.nextFloat();
    }
    
   public static int obterBase (Scanner leer){
       System.out.println("Base: ");
       int base = leer.nextInt();
       return base;
   }
   
      public static void exemploFarolas (){
        Farola.cousa= 4000;
        Farola farola = new Farola(3, 0, "color");
        Farola farola1 = new Farola(34, 1, "color1");
        Farola farola2 = new Farola(56, 2, "color2");
        Farola farola3 = new Farola(70, 3, "color3");
        Farola.escribir();
        Visualizar visual = new Visualizar();
        System.out.println(farola.cousa);
        farola1.cousa = 5000;
        farola2.setLumenes(1000);

   }
   
   
   
}
    
