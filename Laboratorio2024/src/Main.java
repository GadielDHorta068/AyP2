import lab.interfaz.RedPanel;
import lab.logica.Red;
import lab.logica.Utilidades;
import lab.modelo.Computadora;
import lab.modelo.Conexion;
import lab.modelo.Router;

import javax.swing.*;
import java.io.IOException;

/**
 * Clase Main
 */
public class Main extends JFrame {
    /**
     * Este metodo crea una red para ser usada de ejemplo al abrir el programa, tambien puede ser usada para testing
     * No esta siendo usado actualmente, queda como ejemplo de uso, la red esta siendo cargada desde graph.txt
     *
     * @return Red
     */
    private Red crearRedDeEjemplo() {

        Red red = new Red();

        // Computadoras
        Computadora pc1 = new Computadora("pc1", "0.0.0.0", Utilidades.generarMAC(), true, "Habitacion");
        Computadora pc2 = new Computadora("pc2", "0.0.0.0", Utilidades.generarMAC(), true, "Oficina");
        Computadora pc3 = new Computadora("pc3", "0.0.0.0", Utilidades.generarMAC(), true, "Laboratorio");
        Computadora pc4 = new Computadora("pc4", "0.0.0.0", Utilidades.generarMAC(), true, "Sala de reuniones");

        // Routers
        Router router1 = new Router("Router1", "192.168.1.1", Utilidades.generarMAC(), true, "Oficina", "Cisco", "1.5.1.13", 450);
        Router router2 = new Router("Router2", "192.168.2.1", Utilidades.generarMAC(), true, "Piso 2", "TP-Link", "2.1.0", 600);
        Router modem = new Router("Modem", "192.168.0.1", Utilidades.generarMAC(), true, "Sala de servidores", "RedUno", "1.0", 3500);

        // Agregar nodos a la red
        red.agregarNodo(pc1);
        red.agregarNodo(pc2);
        red.agregarNodo(pc3);
        red.agregarNodo(pc4);
        red.agregarNodo(router1);
        red.agregarNodo(router2);
        red.agregarNodo(modem);

        // Conexiones
        Conexion conexion1 = new Conexion(router1, pc1, "UTP", 100, 5, true, 0.01);
        Conexion conexion2 = new Conexion(router1, pc2, "UTP", 100, 5, true, 0.01);
        Conexion conexion3 = new Conexion(router2, pc3, "WiFi", 300, 10, true, 0.05);
        Conexion conexion4 = new Conexion(router2, pc4, "WiFi", 300, 10, true, 0.05);
        Conexion conexion5 = new Conexion(modem, router1, "Fibra optica", 1000, 1, true, 0.00);
        Conexion conexion6 = new Conexion(modem, router2, "Fibra optica", 1000, 1, true, 0.00);
        Conexion conexion7 = new Conexion(router1, router2, "Ethernet", 500, 2, true, 0.02);

        // Agregar conexiones a la red
        red.agregarConexion(conexion1);
        red.agregarConexion(conexion2);
        red.agregarConexion(conexion3);
        red.agregarConexion(conexion4);
        red.agregarConexion(conexion5);
        red.agregarConexion(conexion6);
        red.agregarConexion(conexion7);

        return red;
    }

    /**
     * Configura la ventana donde se abrira la interfaz
     */
    public Main() throws IOException {
        setTitle("Gestor de redes Denebzera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Crear la red y agregar nodos y conexiones
        Red red = crearRedDeEjemplo();

        // Crear el panel de la red y agregarlo a la ventana
        RedPanel redPanel = new RedPanel(red);
        add(redPanel);
    }

    /**
     * Aqui comienza la ejecucion, crea la red de prueba para ser lanzada en la aplicacion
     *
     * @param args argumentos por consola, ninguno en uso
     */
    public static void main(String[] args) {
        System.out.println("Gestor de redes Denebzera");
        //sanbox para romper todo

        SwingUtilities.invokeLater(() -> {
            Main frame = null;
            try {
                frame = new Main();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            frame.setVisible(true);
        });
    }
}
