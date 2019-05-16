package agenciadeviajes1;
import java.io.*;

public class AgenciaDeViajes1 {

    public static void main(String[] args)throws IOException {
        Entrada entrada = new Entrada();
        entrada.Entrar();
        Salidas salir = new Salidas();
        salir.Salir(entrada.numeroPersonas, entrada.tipoReserva, entrada.precioFinal, entrada.dias, entrada.precioDia);
    }
    
}
