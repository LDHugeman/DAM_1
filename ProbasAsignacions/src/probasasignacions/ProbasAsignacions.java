
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
        
        
        char caracter = '5';
        System.out.println(caracter);
        
        //Conversión de caracter a número
        int caracter_numero = caracter;
        System.out.println(caracter_numero);
        caracter_numero = (int)caracter;
        System.out.println(caracter_numero);
        
        //Conversión de texto/string a enteiro
        int enteiro = Integer.parseInt("7000");
        
        //Conversión de short a enteiro
        short numero_corto = 32000;
        int numeroCorto_enteiro = numero_corto;
        System.out.println(numeroCorto_enteiro);
        numeroCorto_enteiro = 1000000;
        numero_corto = (short)numeroCorto_enteiro;
        System.out.println(numero_corto);
        
        
        int numero_decimal = (int) constante_flotante;
        System.out.println(numero_decimal);
    }
    
}
