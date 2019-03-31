package ejerciciolibrosautoresarchivos;

import java.io.File;
import java.io.IOException;
import metodos.*;

/**
 *
 * @author 
 */
public class EjercicioLibrosAutoresArchivos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int opcion;
        File fichero = new File("autores.dat");

        do {
            opcion = Menu.menu();
            switch (opcion) {
                case 1:
                    CreacionFichero.crear(fichero);
                    break;
                case 2:
                    Altas.altas(fichero);
                    break;
                case 3:
                    Modificaciones.modificarPrecio(fichero);
                    break;
                case 4:
                    BajasFisicas.bajaFisica(fichero);
                    break;
                case 5:
                    switch (Menu.submenuConsultas()) {
                        case 1:
                            Consultas.consultarAutor(fichero);
                            break;
                        case 2:
                            Consultas.consultarCiudad(fichero);
                            break;
                        case 3:
                            Consultas.consultarLibro(fichero);
                            break;
                    }
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

}
