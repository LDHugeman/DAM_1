/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentascorriente;

import java.util.ArrayList;
import obxetos.Cuenta;

/**
 *
 * @author Luis David
 */
public class Consultar {
    public static boolean existeCuenta(String numeroCuenta, ArrayList<Cuenta> cuentas){
        boolean existe = false;
        for (Cuenta cuenta : cuentas){
            if (cuenta.getNumero() == numeroCuenta){
                existe = true;
            }
        }
        return existe;
    }
    
    public static Cuenta encontrarCuenta(String numeroCuenta, ArrayList<Cuenta> cuentas){
        Cuenta cuentaEncontrada = null;
        for(Cuenta cuenta : cuentas){
            if(cuenta.getNumero().equals(numeroCuenta)){
                cuentaEncontrada = cuenta;
            }
        }
        return cuentaEncontrada;
    }
}
