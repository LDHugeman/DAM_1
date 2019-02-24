package articulospilas;

import clases.*;
import java.io.*;

// @author 
public class Borrar {

    public static Articulo borrar(Articulo p, BufferedReader leer) throws IOException {

        int codigo;

        System.out.println("Introducir código a borrar");
        codigo = Integer.parseInt(leer.readLine());

        Articulo actual = p;
        Articulo anterior = p;

        if (p == null) {
            System.out.println("LISTA VACIA!!!!");
        } else {
            while (actual != null && codigo != actual.getCodigo()) {
                anterior = actual;
                actual = actual.getSiguiente();
            }

            if (actual == null) {
                /*NO ENCONTRADO*/
                Visualizar.visualizar();
            } else {
                /*ENCONTRADO*/
                if (actual != anterior) {
                    anterior.setSiguiente(actual.getSiguiente());
                } else {
                    /*BORRAR PRIMERO DE LA LISTA*/
                    p = p.getSiguiente();
                }

                System.out.println("Articulo eliminado");
            }

        }

        return p;

    }

}
