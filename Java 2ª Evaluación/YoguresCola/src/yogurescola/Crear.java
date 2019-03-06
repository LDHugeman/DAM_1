package yogurescola;

import java.io.BufferedReader;
import objetos.Yogourt;

/**
 *
 * @author David
 */
public class Crear {

    public static Yogourt crearNuevaColaYogures(Yogourt cabecera, BufferedReader lee) {
        System.out.println("¿Desea eliminar la cola actual y crear una nueva?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        System.out.printf("Seleccione una opcion: ");
        byte opcionSeleccionada = Pedir.numeroByte(lee);
        if (opcionSeleccionada == 1) {
            cabecera = null;
            System.out.printf("Nueva cola de yogures creada %n");
        } else {
            System.out.printf("No se ha creado una nueva cola %n");
        }
        return cabecera;
    }

    public static Yogourt crearNuevoYogur(Yogourt cabecera, BufferedReader lee) {
        String codigo = pedirNuevoCodigo(cabecera, lee);
        String marca = pedirNuevaMarca(cabecera, lee);
        String tipo = pedirTipo(lee);
        return new Yogourt(codigo, marca, tipo);
    }

    public static String pedirNuevaMarca(Yogourt cabecera, BufferedReader lee) {
        String marca = "";
        do {
            System.out.printf("Marca: ");
            marca = Pedir.texto(lee);
        } while (Consultar.existeYogurPorMarca(marca, cabecera));
        return marca;
    }
    
    public static String pedirMarcaExistente(Yogourt cabecera, BufferedReader lee) {
        String marca = "";
        boolean existeYogur = false;
        do {
            System.out.printf("Marca: ");
            marca = Pedir.texto(lee);
            existeYogur = Consultar.existeYogurPorMarca(marca, cabecera);
            if(!existeYogur){
                System.err.printf("Esa marca no existe %n");
            }
        } while (!existeYogur);
        return marca;
    }

    public static String pedirTipo(BufferedReader lee) {
        System.out.printf("Tipo: ");
        return Pedir.texto(lee);
    }

    public static String pedirNuevoCodigo(Yogourt cabecera, BufferedReader lee) {
        String codigo = "";
        do {
            System.out.printf("Código: ");
            codigo = Pedir.texto(lee);
        } while (!Validar.esCodigoNuevoValido(codigo, cabecera));
        return codigo;
    }

    public static String pedirCodigoExistente(Yogourt cabecera, BufferedReader lee) {
        String codigo = "";
        do {
            System.out.printf("Código: ");
            codigo = Pedir.texto(lee);
        } while (!Validar.esCodigoExistenteValido(codigo, cabecera));
        return codigo;
    }

}
