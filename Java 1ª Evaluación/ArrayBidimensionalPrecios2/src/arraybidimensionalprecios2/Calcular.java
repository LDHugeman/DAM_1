package arraybidimensionalprecios2;

/**
 *
 * @author Luis David
 */
public class Calcular {

    public static void obtenerPrecioMedioPorCiudad(float[][] precios, float [] preciosMediosCiudad) {
        for (int j = 0; j < precios[0].length; j++) {
            float sumaPrecios = 0;
            for(int i=0; i < precios.length; i++){
                sumaPrecios += precios[i][j];
            }
            preciosMediosCiudad[j]=sumaPrecios/precios.length;
        }
    }
    
    public static void obtenerPrecioMedioPorProducto (float [][] precios, float [] preciosMediosProducto, float [] copiaPreciosMediosProducto){
        for(int i=0; i<precios.length; i++){
            float sumaPrecios =0;
            for(int j=0; j<precios[i].length; j++){
                sumaPrecios += precios[i][j];
            }
            preciosMediosProducto[i] = sumaPrecios/precios[i].length;
            copiaPreciosMediosProducto[i]= sumaPrecios/precios[i].length;
        }
    }
}
