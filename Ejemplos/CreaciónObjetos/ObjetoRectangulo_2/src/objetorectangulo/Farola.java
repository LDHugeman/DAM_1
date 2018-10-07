
package objetorectangulo;

/**
 *
 * @author David
 */
public class Farola {
   private int lumenes;
   private float altura;
   private String color;
   static int cousa;
    
    public Farola(int lumenes,float altura,String color) {
        this.altura = altura;
        this.lumenes = lumenes;
        this.color = color;
    }
  
    
    public static void escribir() {
        System.out.println("Metodo de clase");
    }
    
    public void escribirEsto() {
        System.out.println("Metodo de objeto");
        System.out.println(this.lumenes);
        
    }

    public int getLumenes (){
      return this.lumenes;
    }
    public float getAltura (){
        return this.altura;  
    }
    
    public void setLumenes (int lumenes){
        this.lumenes = lumenes;
    }
    

    public void setColor (String color){
        this.color = color;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public static int getCousa() {
        return cousa;
    }

    public static void setCousa(int cousa) {
        Farola.cousa = cousa;
    }
    
    
    
}
