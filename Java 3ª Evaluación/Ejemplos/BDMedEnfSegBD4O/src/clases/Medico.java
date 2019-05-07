
package clases;

import java.util.ArrayList;

/**
 *
 * @autho
 */
public class Medico {
    
    private int idMedico;
    private String nombre;
    private String especialidad;
    private String direccion;
    private String telefono;
    private ArrayList <Enfermo> enfermos;

    public Medico() {
    }

    public Medico(int idMedico, String nombre, String especialidad, String direccion, 
            String telefono) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.enfermos = new ArrayList <Enfermo>();
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Enfermo> getEnfermos() {
        return enfermos;
    }

    public void setEnfermos(ArrayList<Enfermo> enfermos) {
        this.enfermos = enfermos;
    }
    
    @Override
    public String toString() {
        int enf;
        if (enfermos.isEmpty())
            enf = 0;
        else
            enf = enfermos.size();
        
        return String.format(" \033[35m%s%-12d%1$s%1$s%-12s%1$s%1$s%-12s%1$s"
                    + "%1$s%-12s%1$s%1$s%-12s%1$s%1$s%-12d%1$s", 
                    "|", idMedico, nombre, especialidad, direccion, telefono, enf);
    }
}
