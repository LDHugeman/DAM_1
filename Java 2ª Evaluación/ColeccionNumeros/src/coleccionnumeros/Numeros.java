
package coleccionnumeros;

/**
 *
 * @author David
 */
public class Numeros {
    private float [] numerosPositivos;
    private float [] numerosNegativos;
    private float [] numerosNulos;
    
    public Numeros(float[]numerosPositivos, float [] numerosNegativos, float [] numerosNulos){
        this.numerosPositivos = numerosPositivos;
        this.numerosNegativos = numerosNegativos;
        this.numerosNulos = numerosNulos;       
    }

    public float[] getNumerosPositivos() {
        return numerosPositivos;
    }

    public float[] getNumerosNegativos() {
        return numerosNegativos;
    }

    public float[] getNumerosNulos() {
        return numerosNulos;
    }        
}
