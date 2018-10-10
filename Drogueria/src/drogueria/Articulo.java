
package drogueria;

/**
 *
 * @author David
 */
public class Articulo {
    private String nombre;
    private float ventasAnuales;
    private String tipo = "No existe este tipo";
    
    public Articulo (String nombreArticulo, float ventasAnuales){
        this.nombre = nombreArticulo;
        this.ventasAnuales = ventasAnuales;    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getVentasAnuales() {
        return ventasAnuales;
    }

    public void setVentasAnuales(float ventasAnuales) {
        this.ventasAnuales = ventasAnuales;
    }

    public String getTipo() {
        asignarTipo();
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    private void asignarTipo(){
        if (ventasAnuales>=0 && ventasAnuales<=100){
            tipo = "Artículo de bajo consumo";
        }else if (ventasAnuales>= 101 && ventasAnuales<=500){
            tipo = "Artículo de consumo medio";
        }else if(ventasAnuales>= 501 && ventasAnuales<=1000){
            tipo = "Artículo de consumo alto";
        }else if (ventasAnuales>1000) {
            tipo = "Artículo de primera necesidad";
        }
            
    }
}
