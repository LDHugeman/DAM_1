package agenciaviajesswitch;

import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class AgenciaViajesSwitch {

    public static void main(String[] args) throws IOException {
        visualizar(Introducir.novaReserva());
    }

    public static void visualizar(Reserva reserva) {
        if (reserva != null) {
            if (reserva.getTipoVivienda().equals("Apartamento")) {
                System.out.printf("Apartamento reservado para %d personas. %n", reserva.getNumeroPersonas());
            } else if (reserva.getTipoVivienda().equals("Vivienda")) {
                System.out.printf("Vivienda reservada para %d personas. %n", reserva.getNumeroPersonas());
            }

            System.out.printf("Precio total a pagar %.2f euros. %n", reserva.getPrecio());
        }

    }

}
