package alturasjugadores;

/**
 *
 * @author David
 */
public class Calcular {

    private static float obterAlturaMediaPais(float[] alturasPais) {
        float sumaAlturas = 0;
        for (int i = 0; i < alturasPais.length; i++) {
            sumaAlturas += alturasPais[i];
        }
        return sumaAlturas / alturasPais.length;
    }

    public static void asignarAlturasMediasPaises(float[][] alturas,  float[] alturasMediasPaises) {
        for (int i = 0; i<alturas.length;i++) {
            alturasMediasPaises[i] = obterAlturaMediaPais(alturas[i]);
        }
     
    }
    
    public static float obterAlturaMediaJugadores(float[][] alturas){
        float sumaAlturas = 0;
        for(int i=0;i<alturas.length;i++){
            for(int j=0; j<alturas[i].length;j++){
                sumaAlturas+=alturas[i][j];
            }
        }
        return sumaAlturas/(alturas.length * alturas[0].length);
    }
    
    public static void asignarAlturaMaxima(float [][]alturas, String [][] nombres, String [] paises){
        float alturaMaxima = 0; 
        String nombreAlturaMaxima="";
        String paisAlturaMaxima="";
        for(int i=0; i<alturas.length;i++){
            for(int j=0;j<alturas[i].length;j++){
                if(alturas[i][j]>alturaMaxima){
                    alturaMaxima = alturas[i][j];
                    nombreAlturaMaxima = nombres[i][j];
                    paisAlturaMaxima = paises[i];
                }                
            }           
        }
        Visualizar.verAlturaMaximaJugadores(nombreAlturaMaxima, paisAlturaMaxima, alturaMaxima);        
    }       
}
