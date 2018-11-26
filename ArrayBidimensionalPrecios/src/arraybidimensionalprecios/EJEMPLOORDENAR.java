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
public class EJEMPLOORDENAR {
    public static void ordenar(String [] Cprod, float []Cpm){ //precio medio fila/productos
        String auxNombre="";
        float aux=0;
        for(int i=0;i<Cpm.length-1;i++){
            for(int j=i+1;j<Cpm.length;j++){
                if(Cprod[i].compareToIgnoreCase(Cprod[j])>0){
                    auxNombre = Cprod[i];
                    Cprod[i]=Cprod[j];
                    Cprod[j]= auxNombre;
                    aux=Cpm[i];
                   Cpm[i]=Cpm[j];
                    Cpm[j]=aux;
                }
            }
        }
    }
}
