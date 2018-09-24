
package consumocamion;

/**
 *
 * @author a18luisdvp
 */
public class ConsumoCamion {

    
    public static void main(String[] args) {
       String Propietario="Luis",Matricula="1234_PO";
       float Litros=40.12f;
       float c1=1000f,c2=1200f;
       float Consumo=Litros*100/(c2-c1);
       System.out.printf("el propietario  %s %n",Propietario);
       System.out.printf("la matrícula es  %s%n",Matricula);
       System.out.printf("el consumo es %.2f%n",Consumo);
       
    }
    
}
