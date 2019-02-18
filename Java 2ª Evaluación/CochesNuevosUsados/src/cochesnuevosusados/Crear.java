
package cochesnuevosusados;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import objetos.Coche;
import objetos.CocheAlquiler;
import objetos.CocheVenta;
import objetos.Empresa;
import objetos.Uso;

/**
 *
 * @author a18luisdvp
 */
public class Crear {
    
    public static Empresa nuevaEmpresa(BufferedReader lee)throws IOException{
        System.out.printf("Cif: ");
        String cif=lee.readLine();
        System.out.printf("Nombre: ");
        String nombre=lee.readLine();
        System.out.printf("Teléfono: ");
        String telefono=lee.readLine();
        return new Empresa(cif, nombre, telefono);
    }
    
    public static CocheVenta nuevoCocheVenta(BufferedReader lee, ArrayList<Coche> coches)throws IOException{
        String codigo= pedirNuevoCodigo(lee, coches);
        System.out.printf("Marca: ");
        String marca=lee.readLine();
        System.out.printf("Modelo: ");
        String modelo=lee.readLine();
        System.out.printf("Precio: ");
        float precio=Float.parseFloat(lee.readLine());
        return new CocheVenta(codigo, marca, modelo, precio);
    }
    
    public static CocheAlquiler nuevoCocheAlquiler(BufferedReader lee, ArrayList<Coche> coches)throws IOException{
        String codigo= pedirNuevoCodigo(lee, coches);
        System.out.printf("Marca: ");
        String marca=lee.readLine();
        System.out.printf("Modelo: ");
        String modelo=lee.readLine();
        System.out.printf("Precio por día: ");
        float precioDia=Float.parseFloat(lee.readLine());
        return new CocheAlquiler(codigo, marca, modelo, precioDia);
    }
    
    public static Uso nuevoUso(BufferedReader lee)throws IOException, ParseException{
        System.out.printf("Fecha de alquiler: ");       
        Date fechaAlquiler = obtenerFecha(lee.readLine());
        System.out.printf("Fecha de devolución: ");       
        Date fechaDevolucion = obtenerFecha(lee.readLine());     
        return new Uso(fechaAlquiler, fechaDevolucion);      
    }
    
    public static Date obtenerFecha(String texto) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formatoFecha.parse(texto);
        return fecha;
    }
    
    public static String pedirNuevoCodigo(BufferedReader lee, ArrayList<Coche> coches) throws IOException {
        String codigo = "";
        do {
            System.out.printf("Código: ");
            codigo = lee.readLine();
        } while (!Validar.esCodigoCocheValido(codigo, coches));
        return codigo;
    }
    
    public static String pedirCodigoExistente(BufferedReader lee, ArrayList<Coche> coches)throws IOException{
        String codigo = "";
        do {
            System.out.printf("Código: ");
            codigo = lee.readLine();
        } while (!Validar.esCodigoCocheExistenteValido(codigo, coches));
        return codigo;
    }
}
