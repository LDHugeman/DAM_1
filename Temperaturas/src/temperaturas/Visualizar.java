package temperaturas;

/**
 *
 * @author David
 */
public class Visualizar {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void visualizarDiasSuperiorMedia(String[] diasSuperiorMedia) {
        System.out.printf(ANSI_BLUE + "Estos son los días con temperaturas superiores a la media:%n" + ANSI_RESET);
        for (int i = 0; i < diasSuperiorMedia.length; i++) {
            System.out.printf(diasSuperiorMedia[i] + "%n");
        }
    }

    public static void visualizarTemperaturasDias(byte[] temperaturas, String[] diasSemana) {
        System.out.println("");
        System.out.printf(ANSI_BLUE + "Días y temperaturas:%n" + ANSI_RESET);
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.printf("%s: %dºC%n", diasSemana[i], temperaturas[i]);
        }
    }

    public static void visualizarTemperaturaMedia(int temperaturaMedia) {
        System.out.println(ANSI_BLUE + "Temperatura media:" + ANSI_RESET);
        System.out.println(temperaturaMedia+"ºC");
    }
}
