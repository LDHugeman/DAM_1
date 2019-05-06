
package objetos;

import java.io.RandomAccessFile;

/**
 *
 * @author a18luisdvp
 */
public abstract class Piso {
    
    private static final int TAMAÑO_MAXIMO = 140;
    public static final char TIPO_DUPLEX = 'D';
    public static final char TIPO_ATICO = 'A';
    
    private String referencia;
    private char tipo;
    private String nombrePropietario;   
    private float cuotaFija;
    private float consumoAguaCaliente;
    private float consumoCalefaccion;
    
    public Piso (
            String referencia, 
            char tipo, 
            String nombrePropietario, 
            float cuotaFija,
            float librosAguaCaliente,          
            float consumoCalefaccion){
        this.referencia = referencia;
        this.tipo = tipo;
        this.nombrePropietario = nombrePropietario;
        this.cuotaFija = cuotaFija;
        this.consumoAguaCaliente = librosAguaCaliente;       
        this.consumoCalefaccion = consumoCalefaccion;    
    }   

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    
    public float getCuotaFija() {
        return cuotaFija;
    }

    public void setCuotaFija(float cuotaFija) {
        this.cuotaFija = cuotaFija;
    }

    public float getConsumoAguaCaliente() {
        return consumoAguaCaliente;
    }

    public void setConsumoAguaCaliente(float librosAguaCaliente) {
        this.consumoAguaCaliente = librosAguaCaliente;
    }

    public float getConsumoCalefaccion() {
        return consumoCalefaccion;
    }

    public void setConsumoCalefaccion(float consumoCalefaccion) {
        this.consumoCalefaccion = consumoCalefaccion;
    }

    public abstract float totalRecibo();
    
    public abstract int getTamañoReal();
    
    public abstract void guardarEnArchivo(RandomAccessFile flujoArchivo);    
}
