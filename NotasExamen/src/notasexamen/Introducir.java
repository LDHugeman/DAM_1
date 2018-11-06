package notasexamen;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {

    private static String obterAlumno(BufferedReader lee) throws IOException {
        System.out.printf("Nombre del alumno: ");
        return lee.readLine();
    }

    private static float obterNota(String alumno, BufferedReader lee) throws IOException {
        System.out.printf("Nota de " + alumno+ ": ");
        return Byte.parseByte(lee.readLine());
    }

    public static String[] cargarAlumnos(String[] alumnos, BufferedReader lee) throws IOException {
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = obterAlumno(lee);
        }
        return alumnos;
    }
    
    public static float[] cargarNotas(float[] notas, String[] alumnos, BufferedReader lee)throws IOException{
        for (int i=0; i< notas.length; i++) {
            notas[i] = obterNota(alumnos[i], lee);
        }
        return notas;
    }
}
