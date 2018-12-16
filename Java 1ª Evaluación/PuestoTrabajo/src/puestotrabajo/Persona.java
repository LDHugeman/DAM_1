
package puestotrabajo;

/**
 *
 * @author a18luisdvp
 */
public class Persona {
    private byte edad;
    private String estudios;
    private byte nota;
    private boolean acceso;
    
    public Persona (byte edad, String estudios, byte nota){
        this.edad = edad;
        this.estudios = estudios;
        this.nota = nota;
    }
    
    public static boolean eMaiorDeIdade(byte edad){
        return edad>=18; //Isto retorna true ou false en función de edad
    }
    
    public static boolean tenBachillerOuCiclo(String estudios){
        /*Nun compareToIgnoreCase retornase un int que nos di 
        se os strings son iguais, maiores ou menores según a tabla ASCII.
        Neste caso quero comprobar se son iguais.
        */
        return estudios.compareToIgnoreCase("bachillerato")==0 || estudios.compareToIgnoreCase("ciclo superior")==0; 
           
    }
    
    private boolean tenNotaApta(){
        if(nota>=7){
            acceso = true;
        }else{
            System.err.println("No tiene una nota apta.");
            acceso = false;
        }
        return acceso;
    }

    public boolean tenAcceso() {
        
       return tenNotaApta();
    }   
}
