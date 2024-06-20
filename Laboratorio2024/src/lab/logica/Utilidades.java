package lab.logica;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import lab.modelo.Conexion;
import lab.modelo.Nodo;
import lab.modelo.Router;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.Vertex;

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
        Graph<Nodo, Conexion> grafo = new AdjacencyMapGraph<>(false);
        Map<Nodo, Vertex<Nodo>> res = new HashMap<>();

        for (Vertex<Nodo> vertex : red.getNodos().values()) {
            res.put(vertex.getElement(), grafo.insertVertex(vertex.getElement()));
        }

        for (Edge<Conexion> edge : grafo.edges()) {
            Vertex<Nodo>[] vert = grafo.endVertices(edge);
            grafo.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), edge.getElement());
        }

        // adaptador de mxGraph
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Map<String, Object> vertexMap = new HashMap<>();
            for (Vertex<Nodo> vertex : grafo.vertices()) {
                Object v = graph.insertVertex(parent, null, vertex.getElement().getId(), 0, 0, 80, 30);
                vertexMap.put(vertex.getElement().getId(), v);
            }

            for (Edge<Conexion> edge : grafo.edges()) {
                Object source = vertexMap.get(edge.getElement().getSourceNode().getId());
                Object target = vertexMap.get(edge.getElement().getTargetNode().getId());
                graph.insertEdge(parent, null, edge.getElement().getBandwidth(), source, target);
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxCircleLayout layout = new mxCircleLayout(graph);
        layout.execute(graph.getDefaultParent());

        JFrame frame = new JFrame("Visualizacion del Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        frame.getContentPane().add(graphComponent, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
