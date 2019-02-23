
package clases;

// @author 

public class C_Articulo {
    
    private int codigo;
    private int unidades;
    private float precio;
    private C_Articulo siguiente=null;
    
    
    public C_Articulo () {}
    
    public C_Articulo (int codigo, int unidades, float precio){
        
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

    public C_Articulo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(C_Articulo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
