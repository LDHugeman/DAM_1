
package objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class Ensalada {
    private String codigo;
    private String marca;
    private Date fecha;
    private Ensalada siguiente= null;
    
    public Ensalada(String codigo, String marca, Date fecha){
        this.codigo = codigo;
        this.marca = marca;
        this.fecha = fecha;
    }
    
    public String getCodigo(){
        return codigo;
    }   
    
    public String getMarca (){
        return marca;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public String getStringFecha(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fecha);
    }
    
    public Ensalada getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(Ensalada siguiente){
        this.siguiente = siguiente;
    }
}
