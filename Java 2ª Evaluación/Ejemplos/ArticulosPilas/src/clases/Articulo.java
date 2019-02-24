
package clases;

// @author 

public class Articulo {
    
    private int codigo;
    private int unidades;
    private float precio;
    private Articulo anterior=null;
    
    
    public Articulo () {}
    
    public Articulo (int codigo, int unidades, float precio){
        
        this.codigo=codigo;
        this.unidades=unidades;
        this.precio=precio;
    
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Articulo getSiguiente() {
        return anterior;
    }

    public void setSiguiente(Articulo siguiente) {
        this.anterior = anterior;
    }
    
    
    
    
    
}
