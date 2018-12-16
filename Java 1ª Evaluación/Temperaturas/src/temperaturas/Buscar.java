package temperaturas;

/**
 *
 * @author David
 */
public class Buscar {

    private static int[] obterPosicionsSuperiorMedia(byte[] temperaturas, int temperaturaMedia) {
        byte numeroDiasSuperior = obterNumeroDeDiasSuperiorMedia(temperaturas, temperaturaMedia);
        int[] posicionsSuperiorMedia = new int[numeroDiasSuperior];
        int contador = 0;
        for (int j = 0; j < temperaturas.length; j++) {
            if (temperaturas[j] > temperaturaMedia) {
                posicionsSuperiorMedia[contador] = j;
                contador++;
            }
        }
        return posicionsSuperiorMedia;
    }

    private static byte obterNumeroDeDiasSuperiorMedia(byte[] temperaturas, int temperaturaMedia) {
        byte numeroDias = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > temperaturaMedia) {
                numeroDias++;
            }
        }
        return numeroDias;
    }

    public static String[] obterDiasSuperiorMedia(String[] dias, byte[] temperaturas, int temperaturaMedia) {
        int[] posicionsSuperiorMedia = obterPosicionsSuperiorMedia(temperaturas, temperaturaMedia);

        String[] diasSuperiorMedia = new String[posicionsSuperiorMedia.length];
        for (int i = 0; i < posicionsSuperiorMedia.length; i++) {
            diasSuperiorMedia[i] = dias[posicionsSuperiorMedia[i]];
        }
        return diasSuperiorMedia;
    }
}
