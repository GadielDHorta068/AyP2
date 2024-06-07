package lab.filemanager;

import lab.clases.Conexion;
import lab.clases.Nodo;
import lab.clases.Red;

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
