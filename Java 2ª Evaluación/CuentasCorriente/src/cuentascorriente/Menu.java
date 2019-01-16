/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;

/**
 *
 * @author macbookair
 */
public class Menu {

    public static void menuAltas(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException {
        byte opcionSeleccionada = 0;
        ArrayList<Cliente> nuevosClientes;
        do {
            opcionSeleccionada = selecionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    System.out.println("Procederase a crear clientes para a conta");
                    nuevosClientes = Crear.crearNovosClientes(lee, clientes);
                    Cuenta cuentaCorrienteNueva = Crear.nuevaCuentaCorriente(lee, nuevosClientes);
                    if (!Consultar.existeCuenta(cuentaCorrienteNueva.getNumero(), cuentas)) {
                        cuentas.add(cuentaCorrienteNueva);
                    } else {
                        System.out.println("A conta que creou xa existia anteriormente e non se gardou");
                    }

                    break;
                case 2:
                    System.out.println("Procederase a crear clientes para a conta");
                    nuevosClientes = Crear.crearNovosClientes(lee, clientes);
                    Cuenta cuentePlazoNueva = Crear.nuevaCuentaPlazo(lee, nuevosClientes);
                    if (!Consultar.existeCuenta(cuentePlazoNueva.getNumero(), cuentas)) {
                        cuentas.add(cuentePlazoNueva);
                    } else {
                        System.out.println("A conta que creou xa existia anteriormente e non se gardou");
                    }
                    break;
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuBaixas(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuAltas(lee);
            
        } while (opcionSeleccionada != 0);
    }

    public static void menuModificacions(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuAltas(lee);
            switch(opcionSeleccionada){
                case 1:
                    
                    break;
            }
        } while (opcionSeleccionada != 0);
    }

    public static void menuVisualizar(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuAltas(lee);

        } while (opcionSeleccionada != 0);
    }

    public static byte selecionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENU -------");
        System.out.println("1 - Altas");
        System.out.println("2 - Modificacions");
        System.out.println("3 - Baixas");
        System.out.println("4 - Visualizar");
        System.out.println("0 - Sair");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }

    private static byte selecionarOpcionMenuAltas(BufferedReader lee) throws IOException {
        System.out.println("------- ALTAS -------");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Plazo");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }

    private static byte selecionarOpcionMenuModificacions(BufferedReader lee) throws IOException {
        System.out.println("------- MODIFICACIONS -------");
        System.out.println("1 - Modificar interes de conta plazo");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }

    private static byte selecionarOpcionMenuBaixas(BufferedReader lee) throws IOException {
        System.out.println("------- BAIXAS -------");
        System.out.println("1 - Conta Plazo");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }

    private static byte selecionarOpcionMenuVisualizar(BufferedReader lee) throws IOException {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("1 - Clientes con conta corrente > 200.000€");
        System.out.println("2 - Clientes en numeros vermellos");
        System.out.println("3 - Saldo medio de clientes");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }
}
