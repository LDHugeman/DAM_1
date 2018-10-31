
package practicaarrays;

/**
 *
 * @author David
 */
public class PracticaArrays {

    public static void main(String[] args) {
                float[] cantidades = getArray();
    }

    public static float[] getArray() {
        float[] cantidades = new float[20];
        String[] nombres = new String[12];
        nombres[0] = "Jose";
        cantidades[1] = 45f;

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres.length);
            System.out.println(nombres[i]);
        }

        return cantidades;
    }
    
    public static int [] [] getDimension (){
        int [][] ajedrez = new int [4][5];
        ajedrez [0][0] = 100;
        int numero = ajedrez[0][3];
        
        
        
        int [] array = ajedrez [0];
        int numero2 = array[2];
        
        int numero3 = ajedrez [0][2];
        
        
        
        
        
        for(int i = 0; i < ajedrez.length; i++){
            System.out.println(ajedrez.length);
            for(int j = 0;j < ajedrez[i].length;j++){
                System.out.println(ajedrez[i].length);
                System.out.println(ajedrez[i][j]);
            }
        }
        return ajedrez;
        
    }
    
    
}
