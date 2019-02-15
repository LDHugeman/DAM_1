
package objetos;

import interfaces.I_Nexo;

/**
 *
 * @author David
 */
public class Asignatura implements I_Nexo{
    private String nombre;
    private float nota1;
    private float nota2;
    private float nota3;
    private float notaMediaAsignatura;
    public Asignatura(String nombre, float nota1, float nota2, float nota3){
        this.nombre=nombre;
        this.nota1=nota1;
        this.nota2=nota2;
        this.nota3=nota3;
    }

    public String getNombre() {
        return nombre;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public float getNotaMediaAsignatura() {
        calcular();
        return notaMediaAsignatura;
    }

    @Override
    public float calcular() {
        notaMediaAsignatura=(nota1+nota2+nota3)/3;
        return notaMediaAsignatura;
    }
}
