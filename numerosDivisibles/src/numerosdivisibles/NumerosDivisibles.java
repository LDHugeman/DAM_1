package numerosdivisibles;

/**
 *
 * @author David
 */
public class NumerosDivisibles {
    
    public static void main(String[] args) {
        divisibleFor(7);
        divisibleWhile(7);
        divisibleDoWhile(7);
    }
    
    public static void divisibleFor(int divisor) {
        for (int divisible = divisor; divisible <= 200; divisible += divisor) {
            mostrarDivisible(divisible, divisor);
        }
        System.out.println("");
    }
    
    public static void divisibleWhile(int divisor) {
        int divisible = divisor;
        while (divisible <= 200) {
            mostrarDivisible(divisible, divisor);
            divisible += divisor;
        }
        System.out.println("");
    }
    
    public static void divisibleDoWhile(int divisor) {
        int divisible = divisor;
        do {
            mostrarDivisible(divisible, divisor);
            divisible += divisor;
        } while (divisible <= 200);
        System.out.println("");
    }
    
    public static void mostrarDivisible(int divisible, int divisor) {
        // Miramos se e o primeiro elemento que escribimos
        if (ePrimeiroElemento(divisible, divisor)) {
            System.out.printf("%d", divisible);
        } else {
            System.out.printf(" - %d", divisible);
        }
    }
    
    public static boolean ePrimeiroElemento(int divisible, int divisor){
        return divisible == divisor
    }
    
}
