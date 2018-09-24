/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumocamion;

/**
 *
 * @author a18luisdvp
 */
public class ConsumoCamion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String Propietario="Luis",Matricula="1234 PO";
       float Litros=40.12f;
       float c1=1000f,c2=1200f;
       float Consumo=Litros*100/(c2-c1);
       System.out.printf("el propietario  %s%n",Propietario);
       System.out.printf("la matrícula es  %s%n",Matricula);
       System.out.printf("el consumo es %f%n",Consumo);
       
    }
    
}
