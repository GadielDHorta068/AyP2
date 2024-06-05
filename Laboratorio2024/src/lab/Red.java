package lab;

import java.io.*;
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

            }
        } catch (IOException e) {
            System.out.println("Fallo la carga del archivo");
            e.printStackTrace();
        }
    }

    public void guardarRed() {
        try {
            OutputStream output = new FileOutputStream("red.bin");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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

    public Map<String, Nodo> getNodos() {
        return nodos;
    }

    public ArrayList<Conexion> getConexiones() {
        return conexiones;
    }
}
