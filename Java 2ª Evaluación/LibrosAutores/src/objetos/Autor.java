
package objetos;

import java.util.ArrayList;

/**
 *
 * @author a18luisdvp
 */
public class Autor {
    private String dni;
    private String nombre;
    private String ciudad;
    private ArrayList<Libro> libros;
    
    public Autor(String dni, String nombre, String ciudad, Libro primerLibro){
        this.dni = dni;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.libros= new ArrayList<>();
        libros.add(primerLibro);
    }  

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }        
}

