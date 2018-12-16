
package metodo3sumar;

/**
 *
 * @author user
 */
public class Suma {
    
    //Sobrecarga de métodos
     public static double sumar(double x,double y)
     {        
        double resultado=0;
        resultado= x + y;
        return  resultado;
    }
     public static float sumar(double x,int y)
     
      {        
        float resultado=0;
        resultado= (float)(x + y);
        return  resultado;
    }
     
     
     
    public static double sumar(byte y)
     
      {        
        double resultado=0;
        resultado= 60+ y;
        return  resultado;
    } 
}
