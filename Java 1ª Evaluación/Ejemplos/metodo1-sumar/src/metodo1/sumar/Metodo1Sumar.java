

package metodo1.sumar;

/**
 *
 * @author clara
 */
public class Metodo1Sumar {

    /*Metodo sumar recibe dos parametros y retorna el valor de la suma ,
     * se ejecuta siempre que se invoque
     * 
     */
    public static double sumar(double x, double y)
    {
        System.out.println("********dentro de  sumar = "); 
        System.out.println("valor de x y de a="+x+" valor de y  y de b="+y);
        double resultado=0;
        resultado= x + y;
         System.out.println("suma = " +resultado);
        return  resultado;
    }
    public static void main(String[] args) 
    {
        double a=10, b=20, r=0;
        r=sumar(a,b);//llamada al m´todo
       System.out.println("********dentro de main = "); 
        System.out.println("suma = " +r);
        double e=50,f=60;
       r=sumar(e,f);
         System.out.println("********dentro de main = "); 
        System.out.println("********Nueva  suma = " +r); 

    }
}
