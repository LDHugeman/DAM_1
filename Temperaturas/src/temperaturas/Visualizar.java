package temperaturas;

/**
 *
 * @author David
 */
public class Visualizar {

    public static void visualizarDiasSuperiorMedia(String[] diasSuperiorMedia) {
        System.out.printf("Estos son los días con temperaturas superiores a la media:%n");
        for (int i = 0; i < diasSuperiorMedia.length; i++) {
            System.out.printf(diasSuperiorMedia[i] + "%n");
        }
    }

    public static void visualizarTemperaturasDias(byte[] temperaturas, String[] diasSemana) {
        System.out.println("Días y temperaturas:%n");
        for (int i=0;i<temperaturas.length;i++) {
            System.out.printf("%s: %dºC%n",diasSemana[i], temperaturas[i]);
        }
    }
}
