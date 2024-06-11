package lab.datos;

import lab.logica.Red;
import lab.modelo.Computadora;
import lab.modelo.Conexion;
import lab.modelo.Nodo;
import lab.modelo.Router;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase maneja la carga de un archivo con informacion de una red previamente creada
 */
public class CargarRed {
    /**
     * Este metodo recibira un parametro con el nombre de archivo a cargar y retornara una Red
     *
     * @param archivo Nombre del archivo a cargar
     * @return Red
     * @throws IOException Excepcion arrojada por no encontrar el archivo o el mismo estar corrupto
     */
    public static Red cargarRed(String archivo) throws IOException {
        Red red = new Red();

        //La correcta carga es dependiente del constructor y del nombre del archivo. Arreglar
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            //Primero cargo todos los nodos para evitar problemas en conexion
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 5) {
                    boolean status = Boolean.parseBoolean(datos[3]);
                    if (datos[0].startsWith("pc")) {
                        if (datos.length == 5) {
                            Computadora pc = new Computadora(datos[0], datos[1], datos[2], status, datos[4]);
                            red.agregarNodo(pc);
                        }
                    } else if (datos[0].startsWith("Router") || datos[0].startsWith("Modem")) {
                        if (8 == datos.length) {
                            Router router = new Router(datos[0], datos[1], datos[2], status, datos[4], datos[5], datos[6], Integer.parseInt(datos[7]));
                            red.agregarNodo(router);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            if (datos.length == 7) {
                Nodo source = red.buscar(datos[0]);
                Nodo target = red.buscar(datos[1]);

                System.out.println(target.toString());
                System.out.println(source.toString());

                boolean conexionStatus = Boolean.parseBoolean(datos[5]);
                Conexion conexion = new Conexion(source, target, datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), conexionStatus, Double.parseDouble(datos[6]));
                red.agregarConexion(conexion);
            }
        }
        return red;
    }
}
