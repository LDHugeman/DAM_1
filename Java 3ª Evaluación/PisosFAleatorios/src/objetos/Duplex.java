package objetos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author a18luisdvp
 */
public class Duplex extends Piso {

    private float cuotaExtra;

    public Duplex(
            String referencia,
            char tipo,
            String nombrePropietario,
            float cuotaFija,
            float consumoAguaCaliente,
            float consumoCalefaccion,
            float cuotaExtra) {
        super(referencia, tipo, nombrePropietario, cuotaFija, consumoAguaCaliente, consumoCalefaccion);
        this.cuotaExtra = cuotaExtra;
    }

    public float getCuotaExtra() {
        return cuotaExtra;
    }

    public void setCuotaExtra(float cuotaExtra) {
        this.cuotaExtra = cuotaExtra;
    }

    @Override
    public float totalRecibo() {
        float totalRecibo;
        return totalRecibo = super.getCuotaFija() + super.getConsumoAguaCaliente()
                * 0.40f + super.getConsumoCalefaccion() * 0.70f + cuotaExtra;
    }

    @Override
    public int getTamañoReal() {
        final int TAMAÑO_CABECERA_REGISTRO = 2;
        final int TAMAÑO_FINAL_REGISTRO = 2;
        final int NUMERO_DE_FLOATS = 5;
        final int NUMERO_DE_CHARS = 1;
        final int TAMAÑO_FLOATS = NUMERO_DE_FLOATS * Float.BYTES;
        final int TAMAÑO_CHARS = NUMERO_DE_CHARS * Character.BYTES;
        final int TAMAÑO_STRINGS = (super.getReferencia().length() + super.getNombrePropietario().length()) * Character.BYTES;
        return TAMAÑO_STRINGS + TAMAÑO_CHARS + TAMAÑO_FLOATS + TAMAÑO_CABECERA_REGISTRO + TAMAÑO_FINAL_REGISTRO;
    }

    @Override
    public void guardarEnArchivo(RandomAccessFile flujoArchivo) {
        try {
            flujoArchivo.writeUTF(super.getReferencia());
            flujoArchivo.writeChar(super.getTipo());
            flujoArchivo.writeUTF(super.getNombrePropietario());
            flujoArchivo.writeFloat(super.getCuotaFija());
            flujoArchivo.writeFloat(super.getConsumoAguaCaliente());
            flujoArchivo.writeFloat(super.getConsumoCalefaccion());
            flujoArchivo.writeFloat(cuotaExtra);          
        } catch (IOException excepcion) {
            System.out.println("Error al guardar en el archivo");
        }
    }   
}
