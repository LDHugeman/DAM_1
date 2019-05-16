package estructurasrepetitivas4;
import java.io.*;

public class Entrada {
    public String pregunta;
    public byte seleccion;
    public String opcion;
    public int numeroSi;
    public int numeroNo;
    public int numeroNs;
    public float porcenSi;
    public float porcenNo;
    public float porcenNs;
    int i=0;
    
    public void Entrar()throws IOException{
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        for(i=1;i<6;i++){
            System.out.println("Su pregunta: ");
            pregunta = lee.readLine();
            System.out.println("Seleccione una opcion: \n"
                    + "1) Si\n"
                    + "2) No\n"
                    + "3) Ns/Nc");
            seleccion = Byte.parseByte(lee.readLine());
            
            switch(seleccion){
                case 1:
                    opcion = "Si";
                    numeroSi++;
                    porcenSi = (numeroSi * 5)/100;  
                    break;
                case 2 : 
                    opcion = "No";
                    numeroNo++;
                    porcenNo = (numeroNo * 5)/100;
                    break;
                case 3 : 
                    opcion = "No sabe no contesta";
                    numeroNs++;
                    porcenNs = (numeroNs * 5)/100;
                    break;
            }

        }
    }
}
