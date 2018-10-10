package ejemplosdecondicional;

/**
 *
 * @author David
 */
public class EjemplosDeCondicional {

    public static void main(String[] args) {
        ejemplo1();
        ejemplo2();
        ejemplo3();
        ejemplo4();
        ejemplo5();
        ejemplo6();
        ejemplo7();
        ejemplo8();
    }

    public static void ejemplo1() {
        int EdadJuan = 20, EdadAna = 25;
        if (EdadJuan < EdadAna) {
            System.out.println("Juan es mas joven que Ana");
        }
    }

    public static void ejemplo2() {
        int EdadJuan = 20, EdadAna = 25;
        if (EdadJuan < EdadAna) {
            System.out.println("Juan es mas joven que Ana");
        } else {
            System.out.println("Juan no es mas joven que Ana");
        }
    }

    public static void ejemplo3() {
        float Presion = 2.3f;
        if (Presion > 2f) {
            System.out.println("Abrir valvula de seguridad");
            System.out.println("Reducir la temperatura");
        } else {
            System.out.println("Todo en orden");

        }
    }

    public static void ejemplo4() {
        float Presion = 2.3f, Temperatura = 90f;
        if (Presion > 2f && Temperatura > 200f) {
            System.out.println("Abrir valvula de seguridad");
            System.out.println("Reducir la temperatura");
            System.out.println("Llamar a los bomberos");
        } else {
            System.out.println("Todo en orden");
        }
    }

    public static void ejemplo5() {
        int EdadJuan = 30, EdadAna = 25;
        if (EdadJuan < EdadAna) {
            System.out.println("Juan es mas joven que Ana");
        } else if (EdadJuan == EdadAna) {
            System.out.println("Juan tiene la edad de Ana");
        } else {
            System.out.println("Juan es mayor que Ana");
        }
    }

    public static void ejemplo6() {
        int EdadJuan = 30, EdadAna = 25;
        if (EdadJuan < EdadAna) {
            System.out.println("Juan es mas joven que Ana");
        }
        if (EdadJuan > EdadAna) {
            System.out.println("Juan es mayor que Ana");
        }
        if (EdadJuan == EdadAna) {
            System.out.println("Juan tiene la edad de Ana");
        }
    }

    public static void ejemplo7() {
        int A = 10, B = 5, C = 20;
        if (A < B) {
            if (A < C) {
                System.out.println("A es el menor");
            } else {
                System.out.println("B es el menor");
            }
        } else if (C < B) {
            System.out.println("C es el menor");
        } else {
            System.out.println("B es el menor");
        }

    }

    public static void ejemplo8() {
        int A = 10, B = 5, C = 20;
        if (A <= B && A <= C) {
            System.out.println("A es el menor");
        }
        if (B <= A && B <= C) {
            System.out.println("B es el menor");
        }
        if (C <= A && C <= B) {
            System.out.println("C es el menor");
        }
    }

}
