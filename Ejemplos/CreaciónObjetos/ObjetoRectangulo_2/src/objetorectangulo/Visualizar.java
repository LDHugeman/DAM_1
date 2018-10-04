package objetorectangulo;

public class Visualizar {

    public static void visual(Rectangulo obj) {
        System.out.println("la altura  del rectangulo es:" + obj.getAltura());
        System.out.println("la base  del rectangulo es:" + obj.getBase());
        System.out.println("el area del rectangulo es:" + obj.calculo());

    }
}
