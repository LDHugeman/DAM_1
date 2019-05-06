package randomempresas;

import java.io.*;
import Clases.*;

// @author 
public class Bajas {

    public static int bajas(File fichero, int numeroRegistros, BufferedReader leer) throws IOException {

        File temporal = new File("temporal.dat");
        RandomAccessFile flujoTemporalRW = new RandomAccessFile(temporal, "rw");
        RandomAccessFile flujoDatosR = new RandomAccessFile(fichero, "r");

        C_Empresa empresa;
        String cif;
        byte numeroRegistrosTemporal = 0;

        System.out.println("Introduzca cif a borrar:");
        cif = leer.readLine();

        for (int i = 0; i < numeroRegistros; i++) {
            flujoDatosR.seek(i * 140);
            empresa = new C_Empresa(flujoDatosR.readUTF(), flujoDatosR.readUTF(), flujoDatosR.readUTF(), flujoDatosR.readUTF());

            if (empresa.getCif().compareToIgnoreCase(cif) != 0) {

                flujoTemporalRW.seek(numeroRegistrosTemporal * 140);
                flujoTemporalRW.writeUTF(empresa.getCif());
                flujoTemporalRW.writeUTF(empresa.getRazonSocial());
                flujoTemporalRW.writeUTF(empresa.getDireccion());
                flujoTemporalRW.writeUTF(empresa.getTelefono());
                numeroRegistrosTemporal++;
            }

        }

        flujoDatosR.close();
        flujoTemporalRW.close();

        fichero.delete();
        temporal.renameTo(fichero);

        if (numeroRegistrosTemporal == numeroRegistros) {
            System.out.println("--- Empresa NO ENCONTRADA ---");

        } else {
            System.out.println("---  EMPRESA BORRADA  ---");
            numeroRegistros--;
        }

        return numeroRegistros;

    }

}
