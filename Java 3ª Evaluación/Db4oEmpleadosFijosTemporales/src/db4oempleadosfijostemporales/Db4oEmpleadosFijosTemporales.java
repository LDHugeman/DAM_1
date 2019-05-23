package db4oempleadosfijostemporales;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import objetos.Empleado;
import objetos.EmpleadoFijo;
import objetos.EmpleadoTemporal;
import objetos.Empresa;
import objetos.Producto;
import objetos.Venta;

/**
 *
 * @author David
 */
public class Db4oEmpleadosFijosTemporales {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        byte opcionSeleccionada = 0;
        ObjectContainer baseDatos = Db4oEmbedded.openFile(getConfiguracionDB(),"BDEmpresas");
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Menu.menuAltas(baseDatos, lee);
                    break;
                case 2:
                    Menu.menuBajas(baseDatos, lee);
                    break;
                case 3:
                    Menu.menuModificaciones(baseDatos, lee);
                    break;
                case 4:
                    Menu.menuVisualizar(baseDatos, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("No existe esa opción");
            }
        } while (opcionSeleccionada != 0);
        baseDatos.commit();
        baseDatos.close();
    }
    
    private static EmbeddedConfiguration getConfiguracionDB(){
        EmbeddedConfiguration configuracion = Db4oEmbedded.newConfiguration();
        configuracion.common().objectClass(Empresa.class).cascadeOnUpdate(true);
        configuracion.common().objectClass(Empleado.class).cascadeOnUpdate(true);
        configuracion.common().objectClass(Producto.class).cascadeOnUpdate(true);
        configuracion.common().objectClass(Venta.class).cascadeOnUpdate(true);
        configuracion.common().objectClass(EmpleadoTemporal.class).cascadeOnUpdate(true);
        configuracion.common().objectClass(EmpleadoFijo.class).cascadeOnUpdate(true);
        return configuracion;
    }

}
