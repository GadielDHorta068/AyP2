package lab.datos;

import lab.logica.Red;
import lab.modelo.Conexion;
import lab.modelo.Nodo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que maneja el guardado de la red a un archivo
 */
public class GuardarRed {
    /**
     * Constructor default
     */
    public GuardarRed() {
    }

    /**
     * Metodo que convertira la red en un archivo
     *
     * @param archivo nombre del archivo a generar, recomendable de extension txt
     * @param red     Red a ser guardada
     */
    public static void guardarRed(String archivo, Red red) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Nodo nodo : red.getNodos().values()) {
                bw.write(nodo.toCSV() + "\n");
            }

            for (Conexion conexion : red.getConexiones()) {
                bw.write(conexion.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
