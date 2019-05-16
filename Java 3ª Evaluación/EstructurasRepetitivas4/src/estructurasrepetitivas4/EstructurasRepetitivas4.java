package estructurasrepetitivas4;
import java.io.*;

public class EstructurasRepetitivas4 {
    
    public static void main(String[] args)throws IOException {
        Entrada entrada = new Entrada();
        entrada.Entrar();
        Visualizar visualiza = new Visualizar();
        visualiza.Visual(entrada.pregunta, entrada.seleccion, entrada.opcion, entrada.numeroSi, entrada.numeroNo, entrada.numeroNs, entrada.porcenNo, entrada.porcenNs, entrada.porcenSi);
    }
    
}
