package articulospilas;

import clases.*;
import java.io.*;

// @author 
public class Buscar {

    public static void buscar(Articulo cabecera, BufferedReader leer) throws IOException {

        int codigo;

        System.out.println("Introducir código del artículo a buscar:");
        codigo = Integer.parseInt(leer.readLine());

        Articulo actual = cabecera;

        if (cabecera == null) {
            System.out.println("LISTA VACIA!!!!");
        } else {
            while (actual != null && codigo != actual.getCodigo()) {
                actual = actual.getSiguiente();
            }

            if (actual == null) {
                /*NO ENCONTRADO*/
                Visualizar.visualizar();
            } else {
                /*ENCONTRADO*/
                Visualizar.visualizar(actual);
            }

        }
    }

}
