package articulospilas;

import clases.*;
import java.io.*;

// @author 
public class Insertar {

    public static Articulo insertar(Articulo cabecera, BufferedReader leer) throws IOException {

        int codigo, unidades;
        float precio;
        Articulo nuevaCabecera=null;

        System.out.printf("Introducir código de artículo, pulse 0 para finalizar%n");
        codigo = Integer.parseInt(leer.readLine());

        while (codigo != 0) {

            System.out.printf("Introducir número de unidades%n");
            unidades = Integer.parseInt(leer.readLine());
            System.out.printf("Introducir precio del artículo%n");
            precio = Float.parseFloat(leer.readLine());

            nuevaCabecera = new Articulo(codigo, unidades, precio);
            nuevaCabecera.setSiguiente(cabecera);

            cabecera = nuevaCabecera;

            System.out.printf("%n--ARTICULO CREADO--%n");

            System.out.printf("%nIntroducir código de artículo, pulse 0 para finalizar%n");
            codigo = Integer.parseInt(leer.readLine());

        }

        return nuevaCabecera;

    }

}
