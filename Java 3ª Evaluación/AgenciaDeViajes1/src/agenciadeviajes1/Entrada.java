package agenciadeviajes1;

import java.io.*;

public class Entrada {
    public int numeroPersonas;
    public int tipoReserva;
    public float precioDia;
    public int dias;
    public float precioFinal=0;
    
    public void Entrar()throws IOException{
        BufferedReader lee = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Tipo de vivienda a reservar? \n"
                + "1. Apartamento \n"
                + "2. Vivienda");
        tipoReserva = Integer.parseInt(lee.readLine());
        System.out.println("Número de personas: ");
        numeroPersonas = Integer.parseInt(lee.readLine());
        System.out.println("Días que durará la estancia: ");
        dias = Integer.parseInt(lee.readLine());

        
    }
}
