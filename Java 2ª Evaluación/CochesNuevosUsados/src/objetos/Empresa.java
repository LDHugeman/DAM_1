
package objetos;

import java.util.ArrayList;

/**
 *
 * @author a18luisdvp
 */
public class Empresa {
    private String cif;
    private String nombre;
    private String telefono;
    private ArrayList<Coche> coches;
    
    public Empresa(String cif, String nombre, String telefono){
        this.cif=cif;
        this.nombre=nombre;
        this.telefono=telefono;
        this.coches=new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }     
}
