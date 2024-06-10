package lab.datos;

import lab.logica.Red;
import lab.modelo.Conexion;
import lab.modelo.Nodo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarRed {
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
