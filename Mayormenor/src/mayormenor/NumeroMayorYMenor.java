
package mayormenor;

/**
 *
 * @author Luis David
 */
public class NumeroMayorYMenor {
    private int numero1;
    private int numero2;
    private int numero3;
    private int numeroMayor;
    private int numeroMenor;
    
    public NumeroMayorYMenor(int numero1, int numero2, int numero3){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero3() {
        return numero3;
    }

    public void setNumero3(int numero3) {
        this.numero3 = numero3;
    }

    public int getNumeroMayor() {
        obterNumeroMayor();
        return numeroMayor;
    }

    public void setNumeroMayor(int numeroMayor) {
        this.numeroMayor = numeroMayor;
    }

    public int getNumeroMenor() {
        obterNumeroMenor();
        return numeroMenor;
    }

    public void setNumeroMenor(int numeroMenor) {
        this.numeroMenor = numeroMenor;
    }
    
    private int obterNumeroMayor(){
        if(numero1>=numero2 && numero1>=numero3){
            numeroMayor = numero1;
        }else if(numero2>=numero1 && numero2>=numero3){
            numeroMayor = numero2;
        }else if(numero3>=numero1 && numero3>=numero2){
            numeroMayor = numero3;
        }
        return numeroMayor;
    } 
    
    
    private int obterNumeroMenor(){
        if(numero1<=numero2 && numero1<=numero3){
            numeroMenor = numero1;
        }else if(numero2<=numero1 && numero2<=numero3){
            numeroMenor = numero2;
        }else if(numero3<=numero1 && numero3<=numero2){
            numeroMenor = numero3;
        }
        return numeroMenor;
    }
}
