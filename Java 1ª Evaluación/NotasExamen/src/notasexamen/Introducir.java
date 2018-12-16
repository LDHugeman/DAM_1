package notasexamen;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author a18luisdvp
 */
public class Introducir {

    private static String obterAlumno(int numeroAlumno, BufferedReader lee) throws IOException {
        System.out.printf("Nombre del alumno "+(numeroAlumno+1)+": ");
        return lee.readLine();
    }

    private static float obterNota(String alumno, BufferedReader lee) throws IOException {
        System.out.printf("Nota de " + alumno+ ": ");
        boolean eNotaCorrecta = false;
        byte nota = 0;
        while(!eNotaCorrecta){
            nota = Byte.parseByte(lee.readLine());
            if(nota<=10 && nota>=0){
                eNotaCorrecta = true;
            }else{
                System.err.printf("Esa nota es incorrecta.");
            }
        }
        return nota;
    }

    public static String[] cargarAlumnos(String[] alumnos, BufferedReader lee) throws IOException {
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = obterAlumno(i, lee);
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
