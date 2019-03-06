
package Clases;

// @author 

public class C_Espectador {
    
    private String nombre;
    private String pelicula;
    private int asiento;
    private C_Espectador siguiente;
    
    
    public C_Espectador () {}
    
    public C_Espectador (String nombre, String pelicula, int asiento,C_Espectador siguiente) {
        
        this.nombre=nombre;
        this.pelicula=pelicula;
        this.asiento=asiento;
        this.siguiente=siguiente;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public C_Espectador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(C_Espectador siguiente) {
        this.siguiente = siguiente;
    }

}
