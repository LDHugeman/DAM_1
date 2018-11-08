
package notasexamen;

/**
 *
 * @author David
 */
public class Modificar {
    
    private static float[]  subirUnPuntoNotasSuspensas(float [] notas){
        float [] notasNovas = new float [notas.length];
        for(int i = 0;i<notas.length;i++){
            if (notas[i]<5){
                notasNovas[i]= notas[i] + 1;
            }
        }
        return notasNovas;
    }
    
    public static float[] subirNotasSuspensas (float [] notas){
        float [] notasFinales;
        if(!estanMetadeAprobados(notas)){
            notasFinales = subirUnPuntoNotasSuspensas(notas);
        }else {
            notasFinales = notas;
        }
        while(!estanMetadeAprobados(notasFinales)){
            notasFinales = subirUnPuntoNotasSuspensas(notasFinales);
        }
        return notasFinales;
    }
    
    private static boolean estanMetadeAprobados(float [] notas){
        return Separar.obterNumeroAprobados(notas) >= 3;
    }
    
}
