package notasexamen;

import java.util.Arrays;

/**
 *
 * @author David
 */
public class Separar {

    public static void cargarAlumnosNotasSuspensas(String[] alumnos, float[] notas, String[] alumnosSuspensos, float[] notasSuspensos) {
        int contadorSuspensos = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 5) {
                notasSuspensos[contadorSuspensos] = notas[i];
                alumnosSuspensos[contadorSuspensos] = alumnos[i];
                contadorSuspensos++;
            }
        }
    }
    
    public static void cargarAlumnosNotasAprobadas(String[] alumnos, float[] notas, String[] alumnosAprobados, float[] notasAprobados) {
        int contadorAprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 5) {
                notasAprobados[contadorAprobados] = notas[i];
                alumnosAprobados[contadorAprobados] = alumnos[i];
                contadorAprobados++;
            }
        }
    }

    public static byte obterNumeroAprobados(float[] notas) {
        byte notasSuperiores = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 5) {
                notasSuperiores++;
            }
        }
        return notasSuperiores;
    }
}
