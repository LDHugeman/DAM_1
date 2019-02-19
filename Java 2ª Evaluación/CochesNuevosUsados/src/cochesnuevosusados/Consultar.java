package cochesnuevosusados;

import static cochesnuevosusados.Crear.obtenerFecha;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import objetos.Coche;
import objetos.CocheAlquiler;
import objetos.CocheVenta;
import objetos.Uso;

/**
 *
 * @author David
 */
public class Consultar {

    public static Coche encontrarCochePorCodigo(String codigo, ArrayList<Coche> coches) {
        Coche cocheEncontrado = null;
        for (Coche coche : coches) {
            if (coche.getCodigo().equalsIgnoreCase(codigo)) {
                cocheEncontrado = coche;
            }
        }
        return cocheEncontrado;
    }

    public static boolean existeCochePorCodigo(String codigo, ArrayList<Coche> coches) {
        return encontrarCochePorCodigo(codigo, coches) != null;
    }

    public static CocheVenta encontrarCocheVentaPorCodigo(String codigo, ArrayList<Coche> coches) {
        CocheVenta cocheEncontrado = null;
        for (Coche coche : coches) {
            if (coche instanceof CocheVenta) {
                if (coche.getCodigo().equalsIgnoreCase(codigo)) {
                    cocheEncontrado = ((CocheVenta)coche);
                }
            }
        }
        return cocheEncontrado;
    }
    
    public static boolean existeCocheVentaPorCodigo(String codigo, ArrayList<Coche> coches) {
        return encontrarCocheVentaPorCodigo(codigo, coches) != null;
    }
    
    public static CocheAlquiler encontrarCocheAlquilerPorCodigo(String codigo, ArrayList<Coche> coches) {
        CocheAlquiler cocheEncontrado = null;
        for (Coche coche : coches) {
            if (coche instanceof CocheAlquiler) {
                if (coche.getCodigo().equalsIgnoreCase(codigo)) {
                    cocheEncontrado = ((CocheAlquiler)coche);
                }
            }
        }
        return cocheEncontrado;
    }
    
    public static boolean existeCocheAlquilerPorCodigo(String codigo, ArrayList<Coche> coches) {
        return encontrarCocheAlquilerPorCodigo(codigo, coches) != null;
    }
    
    public static ArrayList<Uso> obtenerUsosEntreDosFechas(BufferedReader lee, CocheAlquiler coche)throws IOException, ParseException{
        ArrayList<Uso> usosEncontrados = new ArrayList<>();
        System.out.printf("--- Introduzca dos fechas entre las que desea ver usos ---%n");
        System.out.printf("Primer fecha(dd/MM/yyyy): ");
        Date primerFecha = obtenerFecha(lee.readLine());
        System.out.printf("Segunda fecha(dd/MM/yyyy): ");                              
        Date segundaFecha = obtenerFecha(lee.readLine());  
        for(Uso uso:coche.getUsos()){
            if(estaEnRangoDeFechas(primerFecha, segundaFecha, uso)){
                usosEncontrados.add(uso);
            }            
        }
        if(usosEncontrados.isEmpty()){
            System.err.printf("No existe ningún uso entre dos fechas. %n");
        }
        return usosEncontrados;
    }  
    
    public static boolean estaEnRangoDeFechas(Date primerFecha, Date segundaFecha, Uso uso){
        long fechaUso = uso.getFechaAlquiler().getTime();
        long primerFechaMs = primerFecha.getTime();
        long segundaFechaMs = segundaFecha.getTime();
        return fechaUso> primerFechaMs && fechaUso < segundaFechaMs;
    }
}
