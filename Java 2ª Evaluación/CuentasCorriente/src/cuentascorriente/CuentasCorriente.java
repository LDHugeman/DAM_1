/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;

/**
 *
 * @author macbookair
 */
public class CuentasCorriente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.selecionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Menu.menuAltas(lee, clientes, cuentas);
                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        } while (opcionSeleccionada != 0);

    }
    
}
