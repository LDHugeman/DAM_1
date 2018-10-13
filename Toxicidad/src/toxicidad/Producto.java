
package toxicidad;

/**
 *
 * @author Luis David
 */
public class Producto {
    private String nombre;
    private byte grado;
    private String tipo;
    
    public Producto (String nombreArticulo, byte gradoDeToxicidad){
        this.nombre = nombreArticulo;
        this.grado = gradoDeToxicidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        asignarTipo();
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte getGrado() {
        return grado;
    }

    public void setGrado(byte grado) {
        this.grado = grado;
    }
    
    private void asignarTipo(){
        
        if(grado>=0 && grado<=10){
            tipo = "No tóxico";
        }else if(grado==11){
            tipo = "Baja toxicidad";
        }else if(grado==12){
            tipo = "Media toxicidad";
        }else if(grado==13){
            tipo = "Alta toxicidad";
        }else if(grado>13){
            tipo = "Altamente peligroso";
        }
    }
    
    
    
    
}
