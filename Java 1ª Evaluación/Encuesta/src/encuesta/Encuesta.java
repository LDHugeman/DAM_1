package encuesta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David
 */
public class Encuesta {

    public static void main(String[] args) throws IOException {
        int numeroRespostasA = 0;
        int numeroRespostasB = 0;
        int numeroRespostasC = 0;
        for (int i = 0; i < 5; i++) {
            switch (obtenerRespuesta(i+1)) {
                case 'a':
                    numeroRespostasA++;
                    break;
                case 'b':
                    numeroRespostasB++;
                    break;
                case 'c':
                    numeroRespostasC++;
                    break;
                case 0:
                    System.err.println("Respuesta no válida.");
                    
            }
        }       
        calcularPorcentaje(numeroRespostasA, numeroRespostasB, numeroRespostasC);
    }
    
    private static void calcularPorcentaje(int numeroRespostasA, int numeroRespostasB, int numeroRespostasC){
        float porcentajeA = 100/5 * numeroRespostasA;
        float porcentajeB = 100/5 * numeroRespostasB;
        float porcentajeC = 100/5 * numeroRespostasC;
        mostrarPorcentajes(porcentajeA, porcentajeB, porcentajeC);
    }
    
    private static void mostrarPorcentajes(float porcentajeA, float porcentajeB, float porcentajeC){
        System.out.printf("Porcentaje de respuestas A: %.2f%% %n", porcentajeA);
        System.out.printf("Porcentaje de respuestas B: %.2f%% %n", porcentajeB);
        System.out.printf("Porcentaje de respuestas C: %.2f%% %n", porcentajeC);
        
    }
            
    private static void mostrarPregunta(int numero) {
        System.out.printf("Pregunta %d %n", numero);
        System.out.printf("a)Si %n"
                + "b)No %n"
                + "c)No sabe/No contesta %n");
    }

    private static char obtenerRespuesta(int numeroPregunta) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        mostrarPregunta(numeroPregunta);
        boolean repetir;
        char resposta = 0;
        do {
            repetir = false;
            System.out.printf("Respuesta: ");
            resposta = Character.toLowerCase(lee.readLine().charAt(0));
            switch (resposta) {
                case 'a':
                    resposta = 'a';
                    break;
                case 'b':
                    resposta = 'b';
                    break;
                case 'c':
                    resposta = 'c';
                    break;
                default:
                    System.out.println("");
                    System.err.printf("Esa respuesta no es válida, inserte una nueva.%n");
                    repetir = true;
            }
        } while (repetir);
        return resposta;
    }
}
