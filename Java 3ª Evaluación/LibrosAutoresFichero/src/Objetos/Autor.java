package Objetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author a18luisdvp
 */
public class Autor implements Serializable {

    private String dni;
    private String nombre;
    private String ciudad;
    private ArrayList<Libro> libros;

    public Autor(String dni, String nombre, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.libros = new ArrayList<>();
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
}
