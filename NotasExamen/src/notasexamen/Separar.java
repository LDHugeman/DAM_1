package notasexamen;

/**
 *
 * @author David
 */
public class Separar {

    public static void cargarAlumnosNotasSuspensas(String[] alumnos, float[] notas, String[] alumnosSuspensos, float[] notasSuspensos) {
        byte notasInferiores = (byte)(notas.length - obterNumeroAprobados(notas));
        alumnosSuspensos = new String[notasInferiores];
        notasSuspensos = new float[notasInferiores];
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
        byte notasSuperiores = obterNumeroAprobados(notas);
        alumnosAprobados = new String[notasSuperiores];
        notasAprobados = new float[notasSuperiores];
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
