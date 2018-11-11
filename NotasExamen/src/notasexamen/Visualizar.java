package notasexamen;

/**
 *
 * @author David
 */
public class Visualizar {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static void verAlumnosConNotas(String[] alumnos, float[] notas) {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println(alumnos[i] + ": " + notas[i]);
        }
        System.out.println("");
    }

    public static void verTodo(
            String[] alumnos,
            float[] notas,
            String[] alumnosAprobados,
            float[] notasAprobados,
            String[] alumnosSuspensos,
            float[] notasSuspensos,
            float[] notasFinales
    ) {
        System.out.println(ANSI_BLUE + "Notas iniciales: " + ANSI_RESET);
        verAlumnosConNotas(alumnos, notas);
        if (notasAprobados != null || notasSuspensos !=null) {
            System.out.println(ANSI_BLUE + "Notas Aprobadas: " + ANSI_RESET);
            verAlumnosConNotas(alumnosAprobados, notasAprobados);
            System.out.println(ANSI_BLUE + "Notas Suspensas: " + ANSI_RESET);
            verAlumnosConNotas(alumnosSuspensos, notasSuspensos);
        } else {
            System.err.printf("No se han separado las notas. %n");
        }
        if (notasFinales != null) {
            System.out.println(ANSI_BLUE + "Notas finales: " + ANSI_RESET);
            verAlumnosConNotas(alumnos, notasFinales);
        } else {
            System.err.printf("No se han subido las notas.%n");
        }
    }
}
