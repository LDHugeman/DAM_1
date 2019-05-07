
package clases;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class Enfermo {
    
    private String dni;
    private String nombre;
    private String patologia;
    private ArrayList <Seguro> seguros;

    public Enfermo() {
    }

    public Enfermo(String dni, String nombre, String patologia) {
        this.dni = dni;
        this.nombre = nombre;
        this.patologia = patologia;
        this.seguros = new ArrayList <Seguro> ();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public ArrayList<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(ArrayList<Seguro> seguros) {
        this.seguros = seguros;
    }

    @Override
    public String toString() {
        int seg;
        if (seguros.isEmpty())
            seg = 0;
        else
            seg = seguros.size();
        
        return String.format(" \033[35m%s%-12s%1$s%1$s%-12s%1$s%1$s%-12s%1$s"
                    + "%1$s%-12d%1$s", "|", dni, nombre, patologia, seg);
    }
    
    
}
