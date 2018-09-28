
package probasasignacions;

/**
 *
 * @author David
 */
public class ProbasAsignacions {
    
    float numero_f = 3.14f;
    
    public static void main(String[] args) {
        
        final float constante_flotante = 3.14f;
        
        int numero = 4;
        numero = numero + 1;
        System.out.println("O valor de numero é: " +numero);
        int sumador = ++numero; //Primeiro sumase 1 a número e despois iguálase
        System.out.println("O valor do sumador é: " +sumador);
        int igualado = numero++; //Primeiro iguálase e despois súmase
        System.out.println("O valor de igualado é: " +igualado);
        System.out.println("O valor de número é: " +numero);
        System.out.println();
              
        
        //Conversión de caracter a número
        char caracter = '5';
        System.out.println(caracter);
      
        int caracter_numero = caracter; //Conversión implícita
        System.out.println(caracter_numero);
        caracter_numero = (int)caracter; //Conversión explícita
        System.out.println(caracter_numero);
        
        //Conversión de número a caracter (require casteo, conversión explícita)
        char numero_caracter = (char)numero;
        System.out.println(numero_caracter);
        
        //Conversión de texto/string a enteiro
        int texto_enteiro = Integer.parseInt("7000");
        System.out.println(texto_enteiro);
        
        //Conversión de short a enteiro
        short numero_corto = 32000;
        int numeroCorto_enteiro = numero_corto; //Conversión implícita
        System.out.println(numeroCorto_enteiro);
        numeroCorto_enteiro = 1000000;
        numero_corto = (short)numeroCorto_enteiro; //Conversión explícita
        System.out.println(numero_corto);
        
        //Conversión de decimal a enteiro
        int decimal_enteiro = (int) constante_flotante;
        System.out.println(decimal_enteiro);
        
        //Conversión de enteiro a decimal
        float enteiro_decimal = numero; //Fai desaparecer a parte decimal
        System.out.println(enteiro_decimal);
        
        //Conversión de byte a enteiro
        byte numeroPequeno = 125;
        int numeroPequeno_enteiro = numeroPequeno; //Pódese facer tanto de forma implícita como explícita
        System.out.println(numeroPequeno_enteiro);
    }
    
}
