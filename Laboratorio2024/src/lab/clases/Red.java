package lab.clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Red {
    private static Map<String, Nodo> nodos;
    private static ArrayList<Conexion> conexiones;

    public Red() {
        nodos = new HashMap<>();
        conexiones = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.put(nodo.getId(), nodo);
    }

    public void agregarConexion(Conexion conexion) {
        conexiones.add(conexion);
    }

    public void imprimirNodos() {
        System.out.println("Lista de Nodos:");
        for (Nodo nodo : nodos.values()) {
            System.out.println(nodo);
        }
    }

    public void imprimirConexiones() {
        System.out.println("Lista de Conexiones:");
        for (Conexion conexion : conexiones) {
            System.out.println(conexion);
        }
    }

    public boolean ping(String ipAddress) {
        for (Nodo nodo : nodos.values()) {
            if (nodo.getIpAddress().equals(ipAddress) && nodo.getStatus()) {
                return true;
            }
        }
        return false;
    }

    public static Red cargarRed(String archivo) {
        System.out.println("pip pip red cargada (ponele)");
        return null;
    }

    public static void guardarRed(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Nodo nodo : nodos.values()) {
                bw.write(nodo.toCSV() + "\n");
            }

            for (Conexion conexion : conexiones) {
                bw.write(conexion.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Nodo> getNodos() {
        return nodos;
    }

    public ArrayList<Conexion> getConexiones() {
        return conexiones;
    }

    public List<String> traceroute(String ipAddress) {
        List<String> path = new ArrayList<>();
        // Implementar lógica para encontrar el camino hacia el nodo con la IP dada
        // Esto puede implicar buscar en el grafo de conexiones

        return path;
    }

    public List<Conexion> obtenerArbolExpansionMinima() {
        List<Conexion> arbol = new ArrayList<>();
        // Implementar el algoritmo de Kruskal o Prim para encontrar el árbol de expansión mínima
        // Este ejemplo utiliza Kruskal

        return arbol;
    }
}
