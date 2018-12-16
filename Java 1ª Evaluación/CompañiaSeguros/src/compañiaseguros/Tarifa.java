
package compañiaseguros;

/**
 *
 * @author David
 */
public class Tarifa {
    
    private String nombreAsegurado;
    private byte edad;
    private byte añosCarnet;
    private double precioCoche;
    private final short tarifaBase = 300;
    private float precio;
    
    public Tarifa(String nombreAsegurado, byte edad, byte añosCarnet, double precioCoche ){
        this.nombreAsegurado = nombreAsegurado;
        this.edad = edad;
        this.añosCarnet = añosCarnet;
        this.precioCoche = precioCoche;
        
    }
   
    
    @Override
    public String toString(){
        return "El nombre del asegurado es " + nombreAsegurado + " y tiene "+ edad +
                " años.\nTiene el carnet desde hace " + añosCarnet +" años.\nSu coche ha costado "+ precioCoche+" €.\n"+ 
                "El precio de su seguro será de "+calcularPrecio()+" €."; 
        
        }
    
    private float calcularPrecio (){
        precio = tarifaBase;
        if(edad<28 || añosCarnet<5){
           precio = precio +100;
        }        
        if (precioCoche>15000){
            precio = precio + 12 * tarifaBase / 100;
        }
        return precio;
    }
}
