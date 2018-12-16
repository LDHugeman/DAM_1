
package metodo3sumar;

/**
 *
 * @author user
 */
public class Metodo3sumar {

    public static void main(String[] args)
        {
        double a=10, b=40, r=0;
        r=Suma.sumar((int)(a),b);
        System.out.println("suma = " +r);
        double e=50.50,f=600;
        r=Suma.sumar(e,f);
        System.out.println("********Nueva  suma = " +r); 
          r  =Restar.resta(a,b);
    System.out.println("********la RESTA = " +r); 
        }
}
