package objetorectangulo;

import java.util.Scanner;

public class Visualizar {

    public static void visual(Rectangulo obj) {
        System.out.println("la altura  del rectangulo es:" + obj.getAltura());
        System.out.println("la base  del rectangulo es:" + obj.getBase());
        System.out.println("el area del rectangulo es:" + obj.calculo());
        int base = ObjetoRectangulo.obterBase(new Scanner(System.in));
    }
    
    public void cousa(){
        
    }
}
