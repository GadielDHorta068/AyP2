package lab.logica;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import lab.modelo.Conexion;
import lab.modelo.Nodo;
import lab.modelo.Router;
import net.datastructures.Edge;
import net.datastructures.Vertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Clase con utilidades y logicas sobre el funcionamiento de la Red.
 */
public class Utilidades {
    /**
     * Constructor default
     */
    public Utilidades() {
    }

    /**
     * Genera una direccion MAC aleatoria, usada en la creacion de todo Nodo
     *
     * @return String
     */
    public static String generarMAC() {
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        //volverlo humanamente legible segun stackoverflow
        StringBuilder mac = new StringBuilder(18);
        for (byte b : macAddr) {
            if (mac.length() == 0) {
                mac.append(":");
            }
            mac.append(String.format("%02x", b));
        }
        return mac.toString().toUpperCase();
    }

    /**
     * Este metodo genera una direcion IP acorde al nodo Origen desde donde se conecta el nodo pc
     *
     * @param router Nodo origen
     * @param pc     Nodo Destino
     */
    public static void asignarDireccion(Nodo router, Nodo pc) {
        if (Router.class != pc.getClass()) {
            String[] segmentos = router.getIpAddress().split("\\.");
            if (segmentos.length != 4) {
                throw new IllegalArgumentException("Direccion IP invilida");
            }
            int ultimoSegmento = Integer.parseInt(segmentos[3]);
            ultimoSegmento = router.nuevaIP();
            segmentos[3] = String.valueOf(ultimoSegmento);
            pc.setIpAddress(String.join(".", segmentos));
        }
    }

    /**
     * Metodo que genera visualmente el grafo
     *
     * @param red Red a trabajar
     */
    public static void crearGrafo(Red red) {
        // Crear el grafo
        Graph<Nodo, Conexion> grafo = new SimpleGraph<>(Conexion.class);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();

        // Insertar vértices en el grafo
        for (Vertex<Nodo> vertex : red.getNodos().values()) {
            grafo.addVertex(vertex.getElement());
            res.put(vertex.getElement(), vertex);
        }

        // Insertar aristas en el grafo
        for (Edge<Conexion> edge : red.getSistema().edges()) {
            Vertex<Nodo>[] vert = red.getSistema().endVertices(edge);
            grafo.addEdge(res.get(vert[0].getElement()).getElement(), res.get(vert[1].getElement()).getElement(), edge.getElement());
        }

        // Crear el adaptador de mxGraph
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Map<Nodo, Object> vertexMap = new HashMap<>();
            for (Nodo vertex : grafo.vertexSet()) {
                Object v = graph.insertVertex(parent, null, vertex.getId(), 0, 0, 80, 30);
                vertexMap.put(vertex, v);
            }

            for (Conexion edge : grafo.edgeSet()) {
                Object source = vertexMap.get(grafo.getEdgeSource(edge));
                Object target = vertexMap.get(grafo.getEdgeTarget(edge));
               
                //Quitar flechitas de las lineas
                Map<String, Object> style = graph.getStylesheet().getDefaultEdgeStyle();
                style.put("endArrow", "none");

                graph.insertEdge(parent, null, edge.getBandwidth() + "MB", source, target);
            }
        } finally {
            graph.getModel().endUpdate();
        }

        // Configurar el layout del grafo
        mxCircleLayout layout = new mxCircleLayout(graph);
        layout.execute(graph.getDefaultParent());

        JFrame frame = new JFrame("Visualización del Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        frame.getContentPane().add(graphComponent, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
