/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puestotrabajo;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class IntroducirDatos {

    public static Persona obterPersona(BufferedReader lee) throws IOException {
        byte edad = introducirEdad(lee);
        if (eNumeroPositivo(edad)) {
            if (Persona.eMaiorDeIdade(edad)) {
                String estudios = introducirEstudios(lee);
                if (Persona.tenBachillerOuCiclo(estudios)) {
                    byte notaExamen = introducirNota(lee);
                    if(eNumeroPositivo(notaExamen)){
                        return new Persona(edad, estudios, notaExamen);    
                    }else{
                        System.err.printf("La nota introducida no es válida. %n");
                    }                   
                } else {
                    System.err.printf("No puede acceder al puesto, ya que no tiene bachiller o Ciclo Superior. %n");
                }
            } else {
                System.err.printf("No puede acceder al puesto por ser menor de edad. %n");
            }
        }else{
            System.err.printf("La edad introducida no es válida. %n"); 
        }
        return null;
    }

    private static byte introducirEdad(BufferedReader lee) throws IOException {
        System.out.printf("Edad: ");
        return Byte.parseByte(lee.readLine());

    }

    private static boolean eNumeroPositivo(byte numero) {
        return numero >= 0;
    }

    private static String introducirEstudios(BufferedReader lee) throws IOException {
        System.out.printf("Estudios: ");
        return lee.readLine();
    }

    private static byte introducirNota(BufferedReader lee) throws IOException {
        System.out.printf("Nota del examen de ingreso: ");
        return Byte.parseByte(lee.readLine());

    }
}
