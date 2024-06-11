import lab.interfaz.RedPanel;
import lab.logica.Red;
import lab.logica.Utilidades;
import lab.modelo.Computadora;
import lab.modelo.Conexion;
import lab.modelo.Router;

import javax.swing.*;

/**
 * Clase Main
 */
public class Main extends JFrame {
    /**
     * Este metodo crea una red para ser usada de ejemplo al abrir el programa, tambien puede ser usada para testing
     *
     * @return Red
     */
    private Red crearRedDeEjemplo() {

        Red red = new Red();

        Computadora pc1 = new Computadora("pc1", "000.000.0.000", Utilidades.generarMAC(), true, "Habitacion");
        Computadora pc2 = new Computadora("pc2", "000.000.0.000", Utilidades.generarMAC(), true, "Oficina");
        Router router1 = new Router("Router", "192.168.0.254", Utilidades.generarMAC(), true, "Oficina", "Cisco", "1.5.1.13 ", 450);
        Router modem = new Router("Modem", "192.168.0.0", Utilidades.generarMAC(), true, "Oficina", "RedUno", "1.0 ", 3500);

        red.agregarNodo(pc1);
        red.agregarNodo(pc2);
        red.agregarNodo(router1);
        red.agregarNodo(modem);

        Conexion conexion = new Conexion(router1, pc1, "WAN", 450, 2, true, 0.01);
        Conexion conexion2 = new Conexion(router1, pc2, "UTP", 100, 15, true, 0.5);
        Conexion principal = new Conexion(modem, router1, "UTP", 1000, 0, true, 0.00);

        red.agregarConexion(conexion);
        red.agregarConexion(conexion2);
        red.agregarConexion(principal);

        return red;
    }

    /**
     * Configura la ventana donde se abrira la interfaz
     */
    public Main() {
        setTitle("Gestor de redes Denebzera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
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
            Main frame = new Main();
            frame.setVisible(true);
        });
        //Prints, cambiar a algo mas visual tipo table
        // red.imprimirConexiones();
        // red.imprimirNodos();

        // Ejemplo de ping
        //   System.out.println("Ping a 192.168.0.1: " + red.ping("192.168.0.1"));
        // System.out.println("Ping a 192.168.1.1: " + red.ping("192.168.1.1"));

        //red.guardarRed("red.txt");

//        // Cargar red desde un archivo
//        Red nuevaRed = new Red();
//        nuevaRed.cargarRed("red.txt");
//        nuevaRed.imprimirNodos();
//        nuevaRed.imprimirConexiones();
    }
}
