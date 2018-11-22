/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraybidimensionalprecios;

/**
 *
 * @author a18luisdvp
 */
public class EJEMPLO {

    public static void sumarFilas(float[][] precios, float[] pm) {
        for (int i = 0; i < precios.length; i++) {
            float sf = 0;
            for (int j = 0; j < precios[i].length; j++) {
                sf += precios[i][j]; //sf= sf+ precios[i][j];
            }
            pm[i]=sf/precios[i].length; 
        }
    } 
}
