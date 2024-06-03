package lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Red {
    private Map<String, Nodo> nodos;
    private ArrayList<Conexion> conexiones;

    public Red() {
        nodos = new HashMap<>();
        conexiones = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.put(nodo.id, nodo);
    }

    public void agregarConexion(Conexion conexion) {
        conexiones.add(conexion);
    }

    public void cargarRed(String archivo) {
        //Nose como cargarlo todavia lol
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                //save some sh**
            }
        } catch (IOException e) {
            System.out.println("Fallo la carga del archivo");
            e.printStackTrace();
        }
    }

    public boolean ping(String ipAddress) {
        System.out.println();
        for (Nodo nodo : nodos.values()) {
            if (nodo.ipAddress.equals(ipAddress)) {
                // System.out.println(("El nodo " + ipAddress + " existe"));
                if (nodo.status.equals(true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void imprimirNodos() {
        System.out.println();
        System.out.println("Lista de Nodos:");
        for (Nodo nodo : nodos.values()) {
            System.out.println(nodo.toString());
        }
    }

    public void imprimirConexiones() {
        System.out.println();
        System.out.println("Lista de Conexiones:");
        for (Conexion conexion : conexiones) {
            System.out.println(conexion.toString());
        }
    }
}
