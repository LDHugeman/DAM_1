package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import objetos.Cuenta;
import objetos.ObjectOutputStreamSinCabecera;

/**
 *
 * @author a18luisdvp
 */
public class Archivo {
    
    public static void nuevoFichero (ArrayList<Cuenta> cuentas, File fichero, BufferedReader lee){
        ObjectOutputStream flujoArchivo;
        if(fichero.exists()){
            System.out.println("¿Desea eliminar el fichero actual y crear uno nuevo?");
            System.out.println("[1] Sí");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            byte opcion = Pedir.numeroByte(lee);
            if(opcion == 1){
                flujoArchivo = crearFichero(fichero);
                cerrarFlujo(flujoArchivo);
                cuentas.clear();
                System.out.println("Fichero creado");               
            }else{
                System.out.println("Operación cancelada");
            }
        } else {
            flujoArchivo = crearFichero(fichero);
            cerrarFlujo(flujoArchivo);
            System.out.println("Fichero creado");           
        }
    }

    public static ObjectOutputStream crearFichero(File fichero) {
        ObjectOutputStream flujoArchivo = null;
        try {
            flujoArchivo = new ObjectOutputStream(new FileOutputStream(fichero));
        } catch (IOException excepcion) {
            System.out.println("Error al crear el fichero");
        }
        return flujoArchivo;
    }

    public static ObjectOutputStreamSinCabecera abrirEscrituraFichero(File fichero) {
        ObjectOutputStreamSinCabecera flujoArchivo = null;
        try {
            flujoArchivo = new ObjectOutputStreamSinCabecera(new FileOutputStream(fichero, true));
        } catch (IOException excepcion) {
            System.out.println("Error al abrir el fichero");
        }
        return flujoArchivo;
    }

    public static ObjectInputStream abrirLecturaFichero(File fichero) {
        ObjectInputStream flujoArchivo = null;
        try {
            flujoArchivo = new ObjectInputStream(new FileInputStream(fichero));
        } catch (IOException excepcion) {
            System.out.println("Error al abrir el fichero");
        }
        return flujoArchivo;
    }
    
    public static void cerrarFlujo (ObjectOutputStream flujo){
        try {
            flujo.close();
        } catch (IOException excepcion) {
            System.out.println("Error al cerrar el fichero");
        }
    }
    
    public static void cerrarFlujo (ObjectInputStream flujo){
        try {
            flujo.close();
        } catch (IOException excepcion) {
            System.out.println("Error al cerrar el fichero");
        }
    }    
    
    public static File reescribirFichero(File fichero, ArrayList<Cuenta> cuentas) {
        fichero.delete();
        File nuevoFichero = new File(fichero.getName());
        ObjectOutputStream escrituraNuevoFichero = crearFichero(nuevoFichero);       
        try {
            escrituraNuevoFichero.writeObject(cuentas);
        } catch (IOException exception) {
            System.out.println("Error al abrir el fichero");
        }finally{
            Archivo.cerrarFlujo(escrituraNuevoFichero);
        }
        return nuevoFichero;
    }
}
