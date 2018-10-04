/*
 *POJO  Objeto java básico
 */
package objetorectangulo;

/**
 *
 * @author clara
 */
public class Rectangulo {

    //Atributos=Variables Globales =Propiedades  del objeto
    private int base;
    private float altura;

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public Rectangulo() {
    }

    public Rectangulo(int base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float calculo() {
        float area = this.base * this.altura;
        return area;
    }

}
