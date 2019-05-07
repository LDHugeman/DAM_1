
package clases;

/**
 *
 * @author 
 */
public class Seguro {
    
    private int idSeguro;
    private int precio;
    private String prestaciones;

    public Seguro() {
    }

    public Seguro(int idSeguro, int precio, String prestaciones) {
        this.idSeguro = idSeguro;
        this.precio = precio;
        this.prestaciones = prestaciones;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(String prestaciones) {
        this.prestaciones = prestaciones;
    }


    @Override
    public String toString() {
        return String.format(" \033[35m%s%-12d%1$s%1$s%-12d%1$s%1$s%-12s%1$s"
                , "|", idSeguro, precio, prestaciones);
    }
    
    
}
