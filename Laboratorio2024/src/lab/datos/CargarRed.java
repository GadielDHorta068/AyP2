/**
 * Capa sobre el manejo de ficheros
 */
package lab.datos;

import lab.logica.Red;
import lab.modelo.Computadora;
import lab.modelo.Conexion;
import lab.modelo.Router;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * Esta clase maneja la carga de un archivo con informacion de una red previamente creada
 */
public class CargarRed {
    /**
     * Constructor default
     */
    public CargarRed() {
    }

    /**
     * Este metodo recibira un parametro con el nombre de archivo a cargar y retornara una Red
     *
     * @param archivo Nombre del archivo a cargar
     * @return Red
     * @throws IOException Excepcion arrojada por no encontrar el archivo o el mismo estar corrupto
     */
    public static Red cargarRed(String archivo) throws IOException {
        Red red = new Red();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            //Primero cargo todos los nodos para evitar problemas en conexion
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (Objects.equals(datos[0], "nodo")) {
                    boolean status = Boolean.parseBoolean(datos[4]);
                    if (datos.length == 6) {
                        Computadora pc = new Computadora(datos[1], datos[2], datos[3], status, datos[5]);
                        red.agregarNodo(pc);
                    }

                    if (9 == datos.length) {
                        Router router = new Router(datos[1], datos[2], datos[3], status, datos[5], datos[6], datos[7], Integer.parseInt(datos[8]));
                        red.agregarNodo(router);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            if (Objects.equals(datos[0], "conexion")) {
                boolean conexionStatus = Boolean.parseBoolean(datos[6]);
                Conexion conexion = new Conexion(red.buscar(datos[1]), red.buscar(datos[2]), datos[3], Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), conexionStatus, Double.parseDouble(datos[7]));
                red.agregarConexion(conexion);
            }
        }
        return red;
    }
}
