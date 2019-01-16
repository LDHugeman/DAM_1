/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obxetos;

import java.util.ArrayList;

/**
 *
 * @author Luis David
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String direccion;
    private ArrayList<Cuenta> cuentas;
    
    public Cliente(String dni, String nombre, String direccion){
        this.dni = dni;
        this.direccion = direccion;
        this.nombre = nombre;
        cuentas = new ArrayList<>();
    }
}
